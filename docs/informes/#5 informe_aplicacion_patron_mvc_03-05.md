<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%20de%20Aplicación%20del%20MVC&fontSize=33&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=16&duration=3500&pause=1000&color=4F46E5&center=true&vCenter=true&width=650&lines=Separación+de+responsabilidades;Organización+por+capas;Implementación+de+controlador+y+servicios" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-03%2F05%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.4.1-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Tipo-Arquitectura%20MVC-orange?style=for-the-badge">
</p>

## 📌 Resumen

Este informe documenta la reorganización del proyecto utilizando el patrón MVC para separar correctamente las responsabilidades del sistema.

---

## 🧠 1. Aplicación del patrón MVC

### ✅ Objetivo

Separar la lógica del proyecto en capas independientes para mejorar la organización y el mantenimiento del código.

---

### 🔧 Actividades realizadas

- Se centralizó la gestión del sistema en `SistemaBanco`.
- Se implementó `ControladorBanco` como intermediario entre interfaz y modelo.
- Se definió que las vistas solo se encarguen de capturar y mostrar información.
- Se reorganizaron paquetes siguiendo la estructura MVC.

---

### 📂 Estructura aplicada

- `model` → entidades y clases del sistema
- `controller` → lógica de coordinación
- `service` → administración de datos y estado
- `view` → interfaces gráficas Swing

---

### 🧩 Resultado

- El sistema quedó más organizado y desacoplado.
- Se facilitó la integración futura de nuevas interfaces y funcionalidades.

---

### 📎 Evidencias

- `src/marcredito/service/SistemaBanco.java`
- `src/marcredito/controller/ControladorBanco.java`

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
