# Documentación de Tablas DiarioCabecera y DiarioDetalle

## Resumen de Implementación

Se han creado todas las clases necesarias para gestionar las tablas `DiarioCabecera` y `DiarioDetalle` siguiendo la arquitectura de capas del proyecto.

## Estructura de Archivos Creados

### 1. Modelos de Dominio (Domain Model)
- `DiarioCabecera.java` - Modelo de dominio para cabecera diaria
- `DiarioDetalle.java` - Modelo de dominio para detalle diario

### 2. Entidades JPA (Infrastructure - Persistence)
- `DiarioCabeceraEntity.java` - Entidad JPA mapeada a tabla DiarioCabecera
- `DiarioDetalleEntity.java` - Entidad JPA mapeada a tabla DiarioDetalle con relación ManyToOne a DiarioCabeceraEntity

### 3. Repositorios de Dominio (Domain Repository)
- `DiarioCabeceraRepository.java` - Interfaz de repositorio de dominio para DiarioCabecera
- `DiarioDetalleRepository.java` - Interfaz de repositorio de dominio para DiarioDetalle

### 4. Repositorios JPA (Infrastructure - Persistence Repository)
- `JpaDiarioCabeceraRepository.java` - Repositorio JPA con métodos personalizados
- `JpaDiarioDetalleRepository.java` - Repositorio JPA con métodos personalizados

### 5. Adaptadores de Repositorio (Infrastructure - Persistence Adapter)
- `DiarioCabeceraRepositoryAdapter.java` - Adaptador que implementa DiarioCabeceraRepository
- `DiarioDetalleRepositoryAdapter.java` - Adaptador que implementa DiarioDetalleRepository

### 6. Mappers (Infrastructure - Mapper)
- `DiarioCabeceraMapper.java` - Mapper para convertir entre entidades, modelos de dominio y DTOs
- `DiarioDetalleMapper.java` - Mapper para convertir entre entidades, modelos de dominio y DTOs

### 7. DTOs de Solicitud (Infrastructure - REST Request)
- `DiarioCabeceraRequest.java` - DTO para recibir solicitudes de DiarioCabecera
- `DiarioDetalleRequest.java` - DTO para recibir solicitudes de DiarioDetalle

### 8. DTOs de Respuesta (Infrastructure - REST Response)
- `DiarioCabeceraResponse.java` - DTO para responder solicitudes de DiarioCabecera
- `DiarioDetalleResponse.java` - DTO para responder solicitudes de DiarioDetalle

### 9. Use Cases (Application - Use Case)

#### DiarioCabecera Use Cases:
- `CrearDiarioCabeceraUseCase.java` - Interfaz para crear DiarioCabecera
- `ActualizarDiarioCabeceraUseCase.java` - Interfaz para actualizar DiarioCabecera
- `EliminarDiarioCabeceraUseCase.java` - Interfaz para eliminar DiarioCabecera
- `ObtenerDiarioCabeceraUseCase.java` - Interfaz para obtener DiarioCabecera
- `ListaDiarioCabeceraUseCase.java` - Interfaz para listar DiarioCabecera

#### DiarioDetalle Use Cases:
- `CrearDiarioDetalleUseCase.java` - Interfaz para crear DiarioDetalle
- `ActualizarDiarioDetalleUseCase.java` - Interfaz para actualizar DiarioDetalle
- `EliminarDiarioDetalleUseCase.java` - Interfaz para eliminar DiarioDetalle
- `ObtenerDiarioDetalleUseCase.java` - Interfaz para obtener DiarioDetalle
- `ListaDiarioDetalleUseCase.java` - Interfaz para listar DiarioDetalle

### 10. Implementaciones de Use Cases

#### DiarioCabecera Use Case Implementations:
- `CrearDiarioCabeceraUseCaseImpl.java`
- `ActualizarDiarioCabeceraUseCaseImpl.java`
- `EliminarDiarioCabeceraUseCaseImpl.java`
- `ObtenerDiarioCabeceraUseCaseImpl.java`
- `ListaDiarioCabeceraUseCaseImpl.java`

#### DiarioDetalle Use Case Implementations:
- `CrearDiarioDetalleUseCaseImpl.java`
- `ActualizarDiarioDetalleUseCaseImpl.java`
- `EliminarDiarioDetalleUseCaseImpl.java`
- `ObtenerDiarioDetalleUseCaseImpl.java`
- `ListaDiarioDetalleUseCaseImpl.java`

### 11. Servicios (Application - Service)
- `DiarioCabeceraService.java` - Interfaz de servicio
- `DiarioCabeceraServiceImpl.java` - Implementación de servicio
- `DiarioDetalleService.java` - Interfaz de servicio
- `DiarioDetalleServiceImpl.java` - Implementación de servicio

### 12. Controladores REST (Infrastructure - REST Controller)
- `DiarioCabeceraController.java` - Controlador con endpoints CRUD para DiarioCabecera
- `DiarioDetalleController.java` - Controlador con endpoints CRUD para DiarioDetalle

### 13. Configuración de Beans (Infrastructure - Config)
- `DiarioCabeceraBeanConfig.java` - Configuración de beans para inyección de dependencias
- `DiarioDetalleBeanConfig.java` - Configuración de beans para inyección de dependencias

## Endpoints REST Disponibles

### DiarioCabecera
- `GET /api/diario-cabecera` - Obtener todos
- `POST /api/diario-cabecera` - Crear nuevo
- `GET /api/diario-cabecera/{id}` - Obtener por ID
- `GET /api/diario-cabecera/empresa/{empresaId}` - Obtener por EmpresaId
- `GET /api/diario-cabecera/periodo/{ano}/{mes}` - Obtener por año y mes
- `PUT /api/diario-cabecera/{id}` - Actualizar
- `DELETE /api/diario-cabecera/{id}` - Eliminar

### DiarioDetalle
- `GET /api/diario-detalle` - Obtener todos
- `POST /api/diario-detalle` - Crear nuevo
- `GET /api/diario-detalle/{id}` - Obtener por ID
- `GET /api/diario-detalle/cabecera/{diaCabCompId}` - Obtener por DiaCabCompId
- `PUT /api/diario-detalle/{id}` - Actualizar
- `DELETE /api/diario-detalle/{id}` - Eliminar
- `DELETE /api/diario-detalle/cabecera/{diaCabCompId}` - Eliminar todos por DiaCabCompId

## Características Implementadas

✅ Modelo completo de capas (Domain, Application, Infrastructure)
✅ Relación bidireccional entre DiarioCabecera y DiarioDetalle
✅ Repositorios con operaciones CRUD
✅ Mappers para conversión de datos
✅ DTOs para entrada/salida de datos
✅ Use cases para casos de uso específicos
✅ Servicios que orquestan los use cases
✅ Controladores REST con validación
✅ Inyección de dependencias mediante configuración de beans
✅ Manejo de excepciones con ResourceNotFoundException
✅ Compilación exitosa sin errores

## Nota sobre la Base de Datos

Para que el sistema funcione correctamente, las tablas `DiarioCabecera` y `DiarioDetalle` deben existir en la base de datos SQL Server según las especificaciones proporcionadas. Las entidades JPA mapearan automáticamente a estas tablas.

## Estado de Compilación

✅ **BUILD SUCCESS** - El proyecto compila sin errores con 374 archivos fuente compilados exitosamente.

