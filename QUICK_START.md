# 🚀 Quick Start: Balance General Automático en Ventas

## En 2 Minutos

### ✅ ¿Qué se implementó?

Cuando creas una **venta**, el sistema **automáticamente**:
1. Genera un asiento contable (`DiarioCabecera`)
2. Crea dos líneas de detalle (debe y haber)
3. Calcula y devuelve los totales

### 🔗 Endpoints Disponibles

#### 1️⃣ Crear Venta (Devuelve Balance Automáticamente)

```bash
POST /api/ventas
Content-Type: application/json

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

**Respuesta:**
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

#### 2️⃣ Consultar Balance de un Asiento (Opcional)

```bash
GET /api/balance-general/456
```

**Respuesta:**
```json
{
  "diaCabCompId": 456,
  "glosa": "Asiento por venta: F001-000001",
  "totalDebe": 1000.00,
  "totalHaber": 1000.00,
  "estado": "BALANCEADO",
  "detalleCount": 2
}
```

---

## 📝 Campos Completados Automáticamente

| Campo | Se Completa Con |
|-------|-----------------|
| `empresaId` | De la venta |
| `vtaCabFecha` | Fecha de venta o fecha actual |
| `monedaId` | De la venta |
| `usrSistema` | Del usuario actual |
| `cuentaId` (Debe) | "1001" (Caja - Personalizable) |
| `cuentaId` (Haber) | "4001" (Ingresos - Personalizable) |
| `totalDebe/Haber` | Del monto total de la venta |

---

## ⚙️ Personalización: Cambiar Cuentas Contables

Las cuentas por defecto son "1001" (Caja) y "4001" (Ingresos). Para cambiarlas:

**Archivo:** `src/main/java/org/luis/proyecto/application/usecase/venta/impl/CrearVentaUseCaseImpl.java`

**Líneas 84-92** (Cambiar cuenta de DEBE):
```java
DiarioDetalle debe = cabCreada.agregarDetalle(
    total,
    "DEBE",
    "Debe - Venta " + numComprobante,
    "1001",  // ← CAMBIAR AQUÍ por tu cuenta de Caja
    null,
    monedaId,
    usuario
);
```

**Líneas 97-105** (Cambiar cuenta de HABER):
```java
DiarioDetalle haber = cabCreada.agregarDetalle(
    total,
    "HABER",
    "Haber - Ingresos por venta " + numComprobante,
    "4001",  // ← CAMBIAR AQUÍ por tu cuenta de Ingresos
    null,
    monedaId,
    usuario
);
```

---

## 🧪 Prueba Rápida con cURL

```bash
# 1. Crear venta
curl -X POST http://localhost:8080/api/ventas \
  -H "Content-Type: application/json" \
  -d '{
    "empresaId": "E001",
    "vtaCabNumComp": "F001-000001",
    "vtaCabFecha": "2026-07-07T10:30:00",
    "clienId": 1,
    "monedaId": 1,
    "vtaCabValTotal": 500.00,
    "usrSistema": "admin"
  }'

# 2. Si quieres verificar el balance (reemplaza 456 con el diaCabCompId de la respuesta)
curl http://localhost:8080/api/balance-general/456
```

---

## 📊 Qué Ocurre Internamente

```
Venta creada
    ↓
[Se guarda en BD]
    ↓
[Crea DiarioCabecera con empresa, fecha, usuario, etc.]
    ↓
[Crea 2 DiarioDetalle: DEBE (cta 1001) + HABER (cta 4001)]
    ↓
[Calcula totales: Debe = 500, Haber = 500]
    ↓
[Devuelve respuesta con estadoAsiento = "BALANCEADO"]
```

---

## ⚠️ Importante

1. **Transaccionalidad**: Si falla la creación del asiento, la venta NO se revierte. Usa `@Transactional` en producción.
2. **Cuentas**: Las cuentas "1001" y "4001" son placeholders. Personaliza según tu plan contable.
3. **Campos**: Se completan automáticamente: empresa, fecha, usuario, moneda. Los campos que falten (centro costo, división, etc.) permanecen vacíos.

---

## 📚 Para Más Información

- **Documentación Completa**: `BALANCE_GENERAL_DOCUMENTACION.md`
- **Resumen de Cambios**: `IMPLEMENTACION_RESUMEN.md`
- **Compilación**: ✅ Exitosa (sin errores)

---

## 🎯 Casos de Uso

### Caso 1: Venta Simple
```json
Venta por: 1000.00
↓
Asiento generado:
  DEBE: Cta 1001 = 1000
  HABER: Cta 4001 = 1000
↓
Estado: BALANCEADO ✅
```

### Caso 2: Venta con IGV (Futuro)
Para manejar IGV separado, crea 3 o más detalles:
```json
DEBE: Cta 1001 = 1180 (Caja/total)
HABER: Cta 4001 = 1000 (Ingreso)
HABER: Cta 4011 = 180 (IGV)
```

---

## 🔗 Próximos Pasos (Opcional)

1. **Mapeo de Cuentas Dinámico**: Crear tabla `VentaCuentaMapping` para diferentes tipos de venta
2. **Detalles por Línea**: Crear asientos más complejos con un detalle por cada producto
3. **Transaccionalidad**: Agregar `@Transactional` para garantizar atomicidad
4. **Tests**: Crear tests unitarios para validar balance correcto

---

¿Preguntas? Revisa la documentación completa en `BALANCE_GENERAL_DOCUMENTACION.md`.

