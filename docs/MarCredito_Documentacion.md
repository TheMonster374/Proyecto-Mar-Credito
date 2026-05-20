# 📁 Documentación del Proyecto — Mar Crédito
**Paquete base:** `marcredito`  
**Arquitectura:** MVC (Modelo - Vista - Controlador) + capa de servicio y persistencia

---

## 🚀 App.java — Punto de entrada de la aplicación

Clase principal del proyecto. Contiene el método `main` que arranca todo el sistema.

**¿Qué hace?**
1. Crea una instancia de `SistemaBanco` (lógica de negocio en memoria) y `Persistencia` (lectura/escritura de archivos).
2. Carga desde los archivos `.dat` todos los usuarios y préstamos previamente guardados, inyectándolos al sistema en memoria.
3. Crea el `ControladorBanco` pasándole ambas dependencias.
4. Lanza la ventana `Login` en el hilo de eventos de Swing (`EventQueue.invokeLater`).

---

## 📂 controller/

### ControladorBanco.java — Controlador central del sistema

Es el intermediario entre las vistas (pantallas) y la lógica del negocio. Las vistas nunca tocan directamente el modelo ni la persistencia; todo pasa por aquí.

**Responsabilidades:**
- `registrarSolicitante(...)` / `registrarPrestamista(...)` — Crea un usuario del tipo correspondiente, lo agrega al sistema en memoria y lo guarda en disco.
- `buscarUsuarioPorId(id)` — Busca y retorna un usuario por su ID.
- `crearPrestamo(...)` — Construye un `Acuerdo` y un `Prestamo`, lo agrega a la lista en memoria y persiste toda la lista de préstamos.
- `actualizarPrestamo(...)` — Reemplaza un préstamo existente en la lista (por ID) y vuelve a guardar la lista completa.
- `getPrestamos()` — Retorna todos los préstamos del sistema.
- `obtenerPrimerPrestamista()` — Recorre los usuarios y retorna el primer prestamista encontrado.
- `obtenerPrestamosDeUsuario(idUsuario)` — Filtra y retorna solo los préstamos que pertenecen a un usuario específico.

---

## 📂 model/

### Usuario.java — Clase base abstracta para usuarios

Define los atributos comunes a todos los usuarios del sistema: `id`, `nombre` y `correo`. Implementa `Serializable` para poder guardarse en archivos binarios. Es la superclase de `Solicitante` y `Prestamista`.

---

### Solicitante.java — Usuario que solicita préstamos

Extiende `Usuario`. Representa a la persona que pide un préstamo en el sistema.

**Métodos destacados:**
- `solicitarPrestamo(monto, plazoMeses)` — Genera una descripción textual de la solicitud (actualmente informativo).
- `pagarCuota(valor)` — Imprime por consola el pago de una cuota (pendiente de integración completa).

---

### Prestamista.java — Usuario que financia préstamos

Extiende `Usuario`. Representa a la entidad o persona que otorga el dinero.

**Métodos destacados:**
- `puedeFinanciar(monto)` — Valida que el monto sea positivo.
- `generarAcuerdo(interes, plazoMeses)` — Genera una descripción textual de las condiciones.
- `financiarPrestamo(monto)` — Imprime confirmación de financiamiento.

---

### Acuerdo.java — Condiciones financieras de un préstamo

Clase inmutable (atributos `final`) que encapsula el interés y el plazo de un préstamo. Es parte del `Prestamo` y se serializa junto a él.

**Atributos:** `interes` (porcentaje) y `plazoMeses`.

---

### Prestamo.java — Entidad principal del dominio

Representa un préstamo completo. Es la clase más rica del modelo.

**Atributos clave:**
- `idPrestamo` — ID generado aleatoriamente con formato `P####`.
- `monto` — Capital solicitado.
- `estado` — Estado del préstamo: `"Pendiente"`, `"Aprobado"` o `"Rechazado"`.
- `motivo` — Razón de aprobación o rechazo (ingresada por el prestamista).
- `acuerdo` — Referencia al `Acuerdo` con el interés y el plazo.
- `solicitante` / `prestamista` — Referencias a los usuarios involucrados.
- `pagos` — Lista de objetos `Pago` registrados contra este préstamo.

**Métodos clave:**
- `calcularTotalPagar()` — Retorna `monto + (monto * interés / 100)`.
- `resumen()` — Genera una cadena descriptiva del préstamo.

---

### Pago.java — Registro de un pago individual

Clase simple e inmutable que representa un pago hecho contra un préstamo. Guarda el `valor` (monto pagado) y la `fecha` como texto.

---

## 📂 persistence/

### Persistencia.java — Manejo de archivos binarios

Gestiona la lectura y escritura de datos en disco usando serialización Java (`ObjectInputStream` / `ObjectOutputStream`).

**Archivos que maneja:**
- `prestamos.dat` — Lista completa de préstamos.
- `usuarios.dat` — Lista completa de usuarios.

**Métodos:**
- `guardarPrestamos(lista)` — Sobreescribe el archivo con la lista completa de préstamos.
- `listarPrestamos()` — Lee y retorna todos los préstamos; si el archivo no existe, retorna lista vacía.
- `guardarUsuario(usuario)` — Lee la lista existente, agrega el nuevo usuario y reescribe el archivo.
- `listarUsuarios()` — Lee y retorna todos los usuarios; si el archivo no existe, retorna lista vacía.

---

## 📂 service/

### SistemaBanco.java — Lógica de negocio en memoria

Actúa como repositorio en tiempo de ejecución. Mantiene las listas de `usuarios` y `prestamos` mientras la app está corriendo.

**Métodos:**
- `agregarUsuario(u)` / `agregarPrestamo(p)` — Agregan entidades a las listas internas.
- `buscarUsuarioPorId(id)` — Itera la lista de usuarios buscando por ID.
- `obtenerPrestamosDeUsuario(usuario)` — Filtra los préstamos cuyo solicitante coincide con el usuario dado.
- `getUsuarios()` / `getPrestamos()` — Exponen las listas completas (usadas por el controlador).

---

## 📂 view/

> Todas las vistas son ventanas Swing (`JFrame`) generadas con el editor visual de NetBeans. Cada una tiene un archivo `.java` (lógica) y un `.form` (diseño visual, solo editable desde el IDE).

---

### Login.java / Login.form — Pantalla de inicio de sesión

Ventana principal de entrada al sistema. Muestra un formulario con campos de usuario y contraseña.

**Flujo:**
- Al hacer clic en **INGRESAR**, busca el usuario por ID usando `controller.buscarUsuarioPorId(id)`.
- Si es un `Solicitante`, abre `MenuSolicitante`.
- Si es un `Prestamista`, muestra un mensaje de "en construcción" (pendiente de implementar).
- El enlace **Registro** navega a la ventana `Register`.

---

### Register.java / Register.form — Pantalla de registro de nuevos usuarios

Permite crear una cuenta de tipo `Solicitante` en el sistema.

**Flujo:**
- Solicita nombre y contraseña (con confirmación).
- Genera un ID automático con el formato `MC##` (número aleatorio de 2 dígitos).
- Genera un correo ficticio basado en el nombre.
- Llama a `controller.registrarSolicitante(id, nombre, correo)`.
- Muestra el ID generado al usuario y redirige al `Login`.

---

### MenuSolicitante.java / MenuSolicitante.form — Panel principal del solicitante

Pantalla que ve un usuario de tipo `Solicitante` después de iniciar sesión.

**Funcionalidades:**
- Muestra una tabla con todos sus préstamos (ID, nombre, monto, plazo, total, estado).
- Si no tiene préstamos, muestra un botón grande para crear la primera solicitud.
- Si ya tiene préstamos, muestra la tabla junto a botones de "Nueva solicitud" y "Ver detalles".
- **Nueva solicitud:** pide monto y plazo por diálogos, crea el préstamo con un interés fijo del 5% y lo asigna al primer prestamista disponible.
- **Ver detalles:** muestra un resumen completo del préstamo seleccionado, incluyendo el motivo si ya fue procesado.

---

### MenuPrestamista.java / MenuPrestamista.form — Panel principal del prestamista

Pantalla del usuario `Prestamista`. Muestra todos los préstamos que tiene asignados.

**Funcionalidades:**
- Tabla con los préstamos asociados al prestamista logueado.
- **Ver detalles:** muestra la información completa del préstamo seleccionado.
  - Si el préstamo está en estado `"Pendiente"`, ofrece las opciones **Aprobar** o **Rechazar**, solicitando un motivo en ambos casos.
  - Si ya fue procesado, solo muestra los detalles y el motivo registrado.
- Llama a `controller.actualizarPrestamo(...)` para persistir el cambio de estado.

---

## 🗺️ Resumen de la arquitectura

```
App.java
  └── ControladorBanco (controller)
        ├── SistemaBanco (service) ← listas en memoria
        └── Persistencia (persistence) ← archivos .dat

Vistas (view):
  Login → Register
       → MenuSolicitante
       → MenuPrestamista

Modelo (model):
  Usuario (abstracto)
    ├── Solicitante
    └── Prestamista
  Prestamo
    ├── Acuerdo
    └── Pago
```
