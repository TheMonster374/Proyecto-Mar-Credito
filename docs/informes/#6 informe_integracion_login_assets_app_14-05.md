<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%20de%20Integración%20del%20Login&fontSize=33&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=16&duration=3500&pause=1000&color=4F46E5&center=true&vCenter=true&width=650&lines=Integración+de+interfaz+gráfica;Configuración+de+App+y+controlador;Organización+de+recursos+e+imágenes" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-14%2F05%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.4.3-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Tipo-Integración%20Visual-orange?style=for-the-badge">
</p>

## 📌 Resumen

Este informe documenta la integración inicial de la interfaz gráfica de Login junto con la configuración de arranque principal del proyecto.

---

## 🖥️ 1. Integración de Login y App

### ✅ Objetivo

Conectar la interfaz gráfica con el controlador y asegurar un flujo funcional de ejecución del sistema.

---

### 🔧 Actividades realizadas

- Se integró `Login` con `ControladorBanco`.
- Se configuró `App.java` como punto principal de ejecución.
- Se añadieron usuarios de prueba para validar el acceso al sistema.
- Se reorganizaron recursos gráficos para permitir carga correcta mediante `getResource()`.

---

### 📦 Recursos organizados

- `src/Imagenes/`
- `assets/`

---

### ▶️ Ejecución del proyecto

El sistema ahora inicia desde:

- `src/marcredito/App.java`

Inicializando:

- `SistemaBanco`
- `ControladorBanco`
- `Login`

---

### 🧩 Resultado

- El Login funciona correctamente conectado al controlador.
- Los recursos visuales cargan desde el classpath sin errores.
- El proyecto puede ejecutarse directamente desde NetBeans mediante `Run Project`.

---

### 📎 Evidencias

- `src/marcredito/App.java`
- `src/marcredito/view/Login.java`
- `src/Imagenes/`

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
