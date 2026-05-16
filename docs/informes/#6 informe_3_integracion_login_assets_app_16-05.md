<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%203%20—%20Integración%20de%20Login,%20Assets%20y%20App&fontSize=30&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-16%2F05%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.6-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Tipo-Integración%20GUI-orange?style=for-the-badge">
</p>

---

## 🎯 Objetivo

Integrar la interfaz gráfica del Login al flujo del proyecto y asegurar que el programa se ejecute correctamente desde una clase principal (`App`) con los recursos gráficos funcionando desde el classpath.

---

## 🛠️ Actividades realizadas

### 1) Integración del Login con el controlador

- Se modificó `Login` para recibir un `ControladorBanco` por constructor (`Login(ControladorBanco controller)`), manteniendo también el constructor vacío `Login()` para el diseñador de NetBeans.
- El botón **INGRESAR** quedó conectado al controlador mediante búsqueda por ID (`controller.buscarUsuarioPorId(id)`).
- Se ajustó el comportamiento estético de *placeholder* para que no borre lo escrito indebidamente.

### 2) Clase principal `App`

- Se creó `src/marcredito/App.java` como punto de arranque único del proyecto.
- `App` inicializa `SistemaBanco`, crea `ControladorBanco` y luego abre el Login usando `new Login(controller)`.
- Se agregaron usuarios de prueba (`S1`, `P1`) para poder validar login sin tener aún `RegistroUsuarios`.

### 3) Recursos / imágenes

- Se reorganizaron los assets para que `getResource("/Imagenes/...")` funcione correctamente.
- Imágenes de ejecución ubicadas en `src/Imagenes/`.
- Se mantuvo una carpeta de “almacén” (`assets/`) para conservar recursos originales si se requiere.

### 4) Ejecución por defecto del proyecto

- Se configuró el proyecto para que NetBeans ejecute por defecto `marcredito.App` (Run Project / F6), evitando tener que usar “Run File” manualmente.

---

## ✅ Resultado

- El Login se ejecuta correctamente desde `App`, con controlador no nulo y recursos cargando bien.
- El repositorio quedó listo para que cualquier integrante lo clone, lo abra en NetBeans (Ant) y lo corra.

---

## 📎 Evidencias (en repositorio)

- `src/marcredito/App.java`
- `src/marcredito/view/Login.java`
- `src/Imagenes/*` (recursos)
- `nbproject/` y `build.xml` (configuración Ant/NetBeans)

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
