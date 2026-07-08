# Documentación: Generación Automática de Asientos Contables y Balance General

## Descripción General

Cuando se crea una **venta**, el sistema automáticamente:
1. Guarda la venta en la base de datos
2. Genera un **asiento contable** (`DiarioCabecera`)
3. Crea dos **detalles contables** (`DiarioDetalle`): uno en DEBE y otro en HABER
4. Devuelve la información de la venta junto con los **totales del balance** (debe y haber)

## Flujo de Ejecución

### 1. Crear una Venta

**Endpoint:**
```
POST /api/ventas
```

**Request (JSON):**
```json
{
  "empresaId": "E001",
  "vtaCabNumComp": "F001-000001",
  "vtaCabFecha": "2026-07-07T10:30:00",
  "clienId": 1,
  "monedaId": 1,
  "vtaCabValTotal": 1000.00,
  "usrSistema": "admin"
}
```

**Response (JSON):**
```json
{
  "ventaId": 123,
  "numComprobante": "F001-000001",
  "totalVenta": 1000.00,
  "diaCabCompId": 456,
  "totalDebe": 1000.00,
  "totalHaber": 1000.00,
  "estadoAsiento": "BALANCEADO"
}
```

### 2. ¿Qué Sucede Internamente?

```
VentaController.createVenta()
  └─> VentaService.crearConBalance()
       ├─> CrearVentaUseCase.crear()
       │    ├─> VentaRepository.save()  [Guarda la venta]
       │    ├─> CrearDiarioCabeceraUseCase.crear()  [Crea cabecera del asiento]
       │    │    └─> Genera DiarioCabecera con:
       │    │        - empresaId
       │    │        - fecha actual
       │    │        - glosa: "Asiento por venta: F001-000001"
       │    │
       │    ├─> DiarioCabecera.agregarDetalle()  x2
       │    │    ├─> Detalle 1 (DEBE): cuentaId="1001", monto=1000
       │    │    └─> Detalle 2 (HABER): cuentaId="4001", monto=1000
       │    │
       │    └─> CrearDiarioDetalleUseCase.crear()  x2  [Persiste los detalles]
       │
       └─> BalanceGeneralService.obtenerBalance()
            └─> Calcula totales de debe y haber
```

## Componentes Implementados

### 1. Modelo de Dominio

#### `DiarioCabecera.java`
- Agregó método `agregarDetalle()` que encapsula la lógica de crear detalles
- Automatiza la asignación de valores de debe/haber según el tipo

#### `VentaConAsiento.java` (Nuevo)
- Modelo auxiliar para transportar Venta + diaCabCompId

### 2. Usecases

#### `CrearVentaUseCaseImpl.java` (Modificado)
- Inyecta `CrearDiarioCabeceraUseCase` y `CrearDiarioDetalleUseCase`
- Después de guardar la venta, crea el asiento contable
- Usa `ThreadLocal` para almacenar el `diaCabCompId` generado
- Método estático `obtenerUltimaDiaCabCompId()` para acceder al ID

#### `ObtenerBalanceGeneralUseCase.java` (Nuevo)
- Interface para obtener la cabecera con sus detalles

#### `ObtenerBalanceGeneralUseCaseImpl.java` (Nuevo)
- Implementación que usa `DiarioCabeceraRepository.findById()`

### 3. Servicios

#### `BalanceGeneralService.java` (Nuevo)
- Calcula totales de debe y haber para un asiento
- Retorna `BalanceGeneralResponse` con estado (BALANCEADO/DESBALANCEADO)

#### `BalanceGeneralServiceImpl.java` (Nuevo)
- Implementación que itera los detalles y suma debe/haber

#### `VentaService.java` (Modificado)
- Agregó método `crearConBalance()` que devuelve `VentaConBalanceResponse`

#### `VentaServiceImpl.java` (Modificado)
- Implementa `crearConBalance()` usando `CrearVentaUseCaseImpl` y `BalanceGeneralService`
- Limpia el `ThreadLocal` después de consumir el `diaCabCompId`

### 4. DTOs de Respuesta

#### `BalanceGeneralResponse.java` (Nuevo)
- Contiene: `diaCabCompId`, `glosa`, `totalDebe`, `totalHaber`, `estado`, `detalleCount`

#### `VentaConBalanceResponse.java` (Nuevo)
- Combina datos de venta con balance: `ventaId`, `numComprobante`, `totalVenta`, `diaCabCompId`, `totalDebe`, `totalHaber`, `estadoAsiento`

### 5. Controladores

#### `BalanceGeneralController.java` (Nuevo)
- **GET** `/api/balance-general/{diaCabCompId}` - Obtiene balance de un asiento específico

#### `VentaController.java` (Modificado)
- **POST** `/api/ventas` - Ahora devuelve `VentaConBalanceResponse` con balance incluido

### 6. Configuración

#### `BalanceGeneralBeanConfig.java` (Nuevo)
- Registra beans: `ObtenerBalanceGeneralUseCase`, `BalanceGeneralService`

#### `VentaBeanConfig.java` (Modificado)
- Actualizado `crearVentaUseCase()` para inyectar usecases del diario
- Actualizado `ventaService()` para inyectar `BalanceGeneralService`

---

## Cuentas Contables por Defecto

Las cuentas utilizadas en la implementación actual son placeholders. **AJUSTA SEGÚN TU PLAN CONTABLE:**

| Concepto | Cuenta Actual | Descripción |
|----------|--------------|-------------|
| Venta (DEBE) | `1001` | Caja / Bancos (asumido) |
| Venta (HABER) | `4001` | Ingresos por Ventas (asumido) |

**Para modificar las cuentas**, edita `CrearVentaUseCaseImpl.crear()` líneas 67-80.

---

## Campos Completados Automáticamente

Cuando se crea un asiento por venta, se completan:

| Campo | Origen | Valor |
|-------|--------|-------|
| `empresaId` | Venta | Venta.empresaId |
| `diaCabFecha` | Venta | Venta.vtaCabFecha o ahora() |
| `diaCabAno` | Sistema | Año actual |
| `diaCabMes` | Sistema | Mes actual |
| `usrSistema` | Venta | Venta.usrSistema |
| `monedaId` (Detalle) | Venta | Venta.monedaId |
| `cuentaId` (Detalle) | Configurado | "1001" o "4001" |
| `diaDetDebe`/`diaDetHaber` | Venta | Venta.vtaCabValTotal |
| `diaDetNumDoc` | Venta | Venta.vtaCabNumComp |

---

## Ejemplos de Uso

### Desde el Frontend

#### JavaScript/TypeScript con Fetch

```typescript
// Crear venta y obtener balance automáticamente
async function crearVentaConBalance() {
  const ventaData = {
    empresaId: "E001",
    vtaCabNumComp: "F001-000001",
    vtaCabFecha: new Date().toISOString(),
    clienId: 1,
    monedaId: 1,
    vtaCabValTotal: 1500.00,
    usrSistema: "admin"
  };

  const response = await fetch('/api/ventas', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(ventaData)
  });

  const resultado = await response.json();
  console.log('Venta creada:', resultado);
  console.log(`Total Debe: ${resultado.totalDebe}`);
  console.log(`Total Haber: ${resultado.totalHaber}`);
  console.log(`Estado: ${resultado.estadoAsiento}`);
}
```

#### Obtener Balance de un Asiento Específico

```typescript
async function obtenerBalance(diaCabCompId) {
  const response = await fetch(`/api/balance-general/${diaCabCompId}`);
  const balance = await response.json();
  
  console.log('Balance General:');
  console.log(`Total Debe: ${balance.totalDebe}`);
  console.log(`Total Haber: ${balance.totalHaber}`);
  console.log(`Estado: ${balance.estado}`);
  console.log(`Cantidad de Detalles: ${balance.detalleCount}`);
}
```

---

## Validaciones y Seguridad

### Transaccionalidad
⚠️ **IMPORTANTE**: Actualmente, si la creación del asiento falla, la venta **NO SE REVIERTE**. Para garantizar atomicidad:

1. **Opción A**: Agregar `@Transactional` a nivel de servicio
```java
@Service
@Transactional  // Revierte todo si algo falla
public class VentaServiceImpl implements VentaService { ... }
```

2. **Opción B**: Usar compensación/eventos para manejar inconsistencias

### Balance Validado
El sistema verifica que todo asiento esté **BALANCEADO** (Total Debe = Total Haber).
Si no, la respuesta devuelve estado: `"DESBALANCEADO"` (esto indicaría un bug en la lógica).

---

## Próximas Mejoras Sugeridas

1. **Mapeo de Cuentas Dinámico**
   - Crear tabla `VentaCuentaMapping` para mapear tipos de venta → cuentas contables
   - Consultar esta tabla en lugar de usar valores hardcodeados

2. **Detalles por Línea de Venta**
   - En lugar de un solo debe/haber, crear un detalle por cada `DetalleVenta` (ítems)
   - Mapear producto → cuenta contable específica

3. **Soporte IGV/ISC Separado**
   - Crear detalles adicionales para IGV y otros impuestos
   - Usar cuentas específicas (40 para IGV, 42 para ISC, etc.)

4. **Transaccionalidad Garantizada**
   - Implementar `@Transactional` y manejo de excepciones

5. **Auditoría y Eventos**
   - Registrar quién y cuándo se creó el asiento
   - Implementar eventos de dominio para integraciones

6. **Tests Unitarios**
   - Tests para verificar balance correcto
   - Tests para validar cuentas mapeadas
   - Tests de integración E2E

---

## Troubleshooting

### El balance no se devuelve en la respuesta
- Verifica que `BalanceGeneralService` esté siendo inyectado correctamente
- Chequea que `DiarioCabeceraRepository` cargue los detalles (relación OneToMany)

### Estado "DESBALANCEADO"
- Indica que totalDebe ≠ totalHaber
- Revisa la lógica en `DiarioCabecera.agregarDetalle()`

### El ID de la cabecera es null
- Verifica que el generado (IDENTITY) funcione en tu BD
- Chequea que `DiarioCabeceraRepository.save()` retorne la entidad con ID

---

## Archivos Afectados/Creados

### Creados (7)
- BalanceGeneralBeanConfig.java
- BalanceGeneralController.java
- BalanceGeneralResponse.java
- BalanceGeneralService.java (interface)
- BalanceGeneralServiceImpl.java
- ObtenerBalanceGeneralUseCase.java (interface)
- ObtenerBalanceGeneralUseCaseImpl.java
- VentaConAsiento.java
- VentaConBalanceResponse.java

### Modificados (6)
- DiarioCabecera.java (agregó método agregarDetalle)
- CrearVentaUseCaseImpl.java (lógica de asiento + ThreadLocal)
- VentaService.java (agregó crearConBalance)
- VentaServiceImpl.java (implementó crearConBalance)
- VentaBeanConfig.java (actualizó inyecciones)
- VentaController.java (POST devuelve VentaConBalanceResponse)

