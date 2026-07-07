# Documentación de Tablas de Catálogos Contables
## Cuenta, SubCuenta, Divisionaria y SubDivisionaria

## Resumen de Implementación

Se han creado todas las clases necesarias para gestionar las 4 tablas de catálogos contables siguiendo la arquitectura de capas del proyecto:
- **Cuenta**: Catálogo principal de cuentas contables
- **SubCuenta**: Subcuentas dependientes de una Cuenta
- **Divisionaria**: Divisiones dentro de cada SubCuenta
- **SubDivisionaria**: Subdivisiones dentro de cada Divisionaria

## Estructura de Tablas y Relaciones

```
Cuenta (1)
    ↓
SubCuenta (N)
    ↓
Divisionaria (N)
    ↓
SubDivisionaria (N)
```

## Archivos Creados por Categoría

### 1. Modelos de Dominio (4 archivos)
- `Cuenta.java`
- `SubCuenta.java`
- `Divisionaria.java`
- `SubDivisionaria.java`

### 2. Entidades JPA (4 + 4 PK = 8 archivos)
- `CuentaEntity.java` - ID Simple (String)
- `SubCuentaEntity.java` - ID Compuesta (CuentaId, SubCtaId)
- `SubCuentaPK.java` - Clase PK
- `DivisionariaEntity.java` - ID Compuesta (CuentaId, SubCtaId, DivisioId)
- `DivisionariaPK.java` - Clase PK
- `SubDivisionariaEntity.java` - ID Compuesta (CuentaId, SubCtaId, DivisioId, SubDivId)
- `SubDivisionariaPK.java` - Clase PK

### 3. Repositorios de Dominio (4 archivos)
- `CuentaRepository.java`
- `SubCuentaRepository.java`
- `DivisionariaRepository.java`
- `SubDivisionariaRepository.java`

### 4. Repositorios JPA (4 archivos)
- `JpaCuentaRepository.java`
- `JpaSubCuentaRepository.java`
- `JpaDivisionariaRepository.java`
- `JpaSubDivisionariaRepository.java`

### 5. Adaptadores de Repositorio (4 archivos)
- `CuentaRepositoryAdapter.java`
- `SubCuentaRepositoryAdapter.java`
- `DivisionariaRepositoryAdapter.java`
- `SubDivisionariaRepositoryAdapter.java`

### 6. Mappers (4 archivos)
- `CuentaMapper.java`
- `SubCuentaMapper.java`
- `DivisionariaMapper.java`
- `SubDivisionariaMapper.java`

### 7. DTOs Request (4 archivos)
- `CuentaRequest.java`
- `SubCuentaRequest.java`
- `DivisionariaRequest.java`
- `SubDivisionariaRequest.java`

### 8. DTOs Response (4 archivos)
- `CuentaResponse.java`
- `SubCuentaResponse.java`
- `DivisionariaResponse.java`
- `SubDivisionariaResponse.java`

### 9. Servicios (4 + 4 = 8 archivos)
- `CuentaService.java` + `CuentaServiceImpl.java`
- `SubCuentaService.java` + `SubCuentaServiceImpl.java`
- `DivisionariaService.java` + `DivisionariaServiceImpl.java`
- `SubDivisionariaService.java` + `SubDivisionariaServiceImpl.java`

### 10. Controladores REST (4 archivos)
- `CuentaController.java`
- `SubCuentaController.java`
- `DivisionariaController.java`
- `SubDivisionariaController.java`

### 11. Configuraciones de Beans (4 archivos)
- `CuentaBeanConfig.java`
- `SubCuentaBeanConfig.java`
- `DivisionariaBeanConfig.java`
- `SubDivisionariaBeanConfig.java`

## Total de Archivos Creados: 60 archivos

## Endpoints REST Disponibles

### Cuenta
```
GET     /api/cuenta                    - Obtener todas las cuentas
POST    /api/cuenta                    - Crear nueva cuenta
GET     /api/cuenta/{id}               - Obtener cuenta por ID
PUT     /api/cuenta/{id}               - Actualizar cuenta
DELETE  /api/cuenta/{id}               - Eliminar cuenta
```

### SubCuenta
```
GET     /api/subcuenta                 - Obtener todas las subcuentas
POST    /api/subcuenta                 - Crear nueva subcuenta
GET     /api/subcuenta/{cuentaId}/{subCtaId}              - Obtener subcuenta
GET     /api/subcuenta/cuenta/{cuentaId}                  - Obtener por Cuenta
PUT     /api/subcuenta/{cuentaId}/{subCtaId}              - Actualizar
DELETE  /api/subcuenta/{cuentaId}/{subCtaId}              - Eliminar
DELETE  /api/subcuenta/cuenta/{cuentaId}                  - Eliminar todas por Cuenta
```

### Divisionaria
```
GET     /api/divisionaria                                           - Obtener todas
POST    /api/divisionaria                                           - Crear nueva
GET     /api/divisionaria/{cuentaId}/{subCtaId}/{divisioId}         - Obtener por ID
GET     /api/divisionaria/subcuenta/{cuentaId}/{subCtaId}           - Obtener por SubCuenta
PUT     /api/divisionaria/{cuentaId}/{subCtaId}/{divisioId}         - Actualizar
DELETE  /api/divisionaria/{cuentaId}/{subCtaId}/{divisioId}         - Eliminar
DELETE  /api/divisionaria/subcuenta/{cuentaId}/{subCtaId}           - Eliminar por SubCuenta
```

### SubDivisionaria
```
GET     /api/subdivisionaria                                                      - Obtener todas
POST    /api/subdivisionaria                                                      - Crear nueva
GET     /api/subdivisionaria/{cuentaId}/{subCtaId}/{divisioId}/{subDivId}         - Obtener por ID
GET     /api/subdivisionaria/divisionaria/{cuentaId}/{subCtaId}/{divisioId}       - Obtener por Divisionaria
PUT     /api/subdivisionaria/{cuentaId}/{subCtaId}/{divisioId}/{subDivId}         - Actualizar
DELETE  /api/subdivisionaria/{cuentaId}/{subCtaId}/{divisioId}/{subDivId}         - Eliminar
DELETE  /api/subdivisionaria/divisionaria/{cuentaId}/{subCtaId}/{divisioId}       - Eliminar por Divisionaria
```

## Características Implementadas

✅ Relaciones bidireccionales entre tablas (OneToMany y ManyToOne)
✅ Claves primarias compuestas con @IdClass
✅ Repositorios con operaciones CRUD
✅ Mappers para conversión de datos
✅ DTOs para entrada/salida de datos REST
✅ Servicios con lógica de negocio
✅ Controladores REST con validación
✅ Inyección de dependencias mediante configuración de beans
✅ Manejo de excepciones con ResourceNotFoundException
✅ Compilación exitosa sin errores

## Tipos de Datos Mapeados

- **char** → String
- **varchar** → String
- **nvarchar** → String
- **bit** → Boolean
- **int** → Integer
- **datetime** → LocalDateTime

## Validación

✅ **BUILD SUCCESS** - El proyecto compila correctamente con todas las nuevas clases

## Pasos Siguientes

1. Asegúrate que las tablas existan en la base de datos SQL Server
2. Compila el proyecto: `mvn clean compile`
3. Ejecuta la aplicación: `mvn spring-boot:run`
4. Accede a los endpoints a través de `http://localhost:8080/api/cuenta`, etc.

## Ejemplo de Jerarquía de Datos

```
Cuenta: C001
├── SubCuenta: C001-SC01
│   ├── Divisionaria: C001-SC01-D01
│   │   ├── SubDivisionaria: C001-SC01-D01-SD01
│   │   ├── SubDivisionaria: C001-SC01-D01-SD02
│   │   └── SubDivisionaria: C001-SC01-D01-SD03
│   └── Divisionaria: C001-SC01-D02
├── SubCuenta: C001-SC02
└── SubCuenta: C001-SC03
```

## Notas Importantes

- SubCuenta depende de Cuenta por la FK `CuentaId`
- Divisionaria depende de SubCuenta por las FK `CuentaId` y `SubCtaId`
- SubDivisionaria depende de Divisionaria por las FK `CuentaId`, `SubCtaId` y `DivisioId`
- Cuando eliminas una Cuenta, todas sus SubCuentas, Divisionarias y SubDivisionarias se eliminan en cascada
- Las operaciones de búsqueda por ID requieren los valores de todas las claves compuestas

