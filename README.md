<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="assets/logo_dark.png">
    <source media="(prefers-color-scheme: light)" srcset="assets/logo_light.png">
    <img src="assets/logo_light.png" width="600">
  </picture>
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=18&duration=3500&pause=1000&color=22C55E&center=true&vCenter=true&width=500&lines=Sistema+de+gesti%C3%B3n+de+pr%C3%A9stamos;Proyecto+acad%C3%A9mico+en+desarrollo;Conectando+prestamistas+y+solicitantes" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Estado-En%20Desarrollo-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.5-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/Java-(Logica)-orange?style=for-the-badge&logo=java">
</p>

---

## 🧠 Descripción del Proyecto

**Mar Crédito** es una aplicación diseñada para conectar prestamistas y solicitantes de dinero, permitiendo gestionar préstamos a corto plazo de forma estructurada.

El sistema permite:
- 📊 Registrar montos, plazos e intereses
- 📄 Gestionar acuerdos financieros
- 👤 Administrar usuarios (prestamistas y solicitantes)
- 📌 Controlar el estado de cada préstamo

Este proyecto nace como una solución académica enfocada en modelado de sistemas mediante diagramas UML y desarrollo progresivo en Java.

---

## 🚀 Estado Actual

> 🟡 Proyecto en fase de integración (MVP funcional) — versión 1.5

### 📁 Estructura actual
- Código: `src/`
- Recursos GUI: `src/Imagenes/`
- Documentación: `docs/`
  - Diagramas fuente: `docs/diagrams/`
  - Diagramas exportados (PNG): `docs/diagrams_png/`
  - Historial de diagramas: `docs/diagrams_history/`
  - Informes: `docs/informes/`

### ✅ Documentación y análisis
- ✔️ Diagramas UML (Casos de uso y Clases)
- ✔️ Requerimientos de casos de uso
- ✔️ Renombre del proyecto (Banco Diario → Mar Crédito) y asignación de roles

### ✅ Identidad visual
- ✔️ Creación del logo de Mar Crédito
- ✔️ Integración del logo en el README

### ✅ Implementación actual
- ✔️ Modelo de dominio creado: `Usuario`, `Solicitante`, `Prestamista`, `Prestamo`, `Pago`, `Acuerdo`, `PQRS`
- ✔️ Capas base implementadas: `service` (`SistemaBanco`) y `controller` (`ControladorBanco`)
- ✔️ Punto de entrada del proyecto: `App`
- ✔️ Login integrado a la lógica (autenticación por ID con usuarios de prueba)

### ⏳ Próximos pasos
- ⏳ Implementar menús por rol (Solicitante / Prestamista) y navegación posterior al login
- ⏳ Completar los flujos de casos de uso en la interfaz (solicitud de préstamo, pagos, acuerdos, PQRS)
- ⏳ Mejoras de validación (IDs repetidos, campos vacíos, mensajes de error)
- ⏳ (Opcional) Persistencia de datos / almacenamiento (archivos o BD) si se requiere
---

## 🔖 Versionado

- **Versión actual del proyecto:** `1.5`
- Los diagramas vigentes **no incluyen la versión en el nombre del archivo**.
- Los snapshots históricos se guardan por carpeta dentro de `docs/diagrams_history/`.

---

## 🛠️ Tecnologías

- ☕ Java  
- 🧰 NetBeans  
- 📐 UML (Modelado del sistema)  
- 🗂️ Git & GitHub
- 🤖 Apoyo asistido con IA (GPT & Copilot)

---

## 👥 Integrantes y Roles

<p align="center">
  <b>Carlos Rodriguez</b> — Gestión del repositorio (GitHub), estandarización de código y control de calidad (bugs)<br>
  <b>Samuel Del Castillo</b> — Desarrollo de la interfaz gráfica (GUI) y apoyo en gestión del repositorio<br>
  <b>Andriu Polanco</b> — Diseño e implementación de la lógica del sistema (backend) y apoyo en documentación<br>
  <b>Matthews Perez</b> — Documentación del proyecto (.md) y apoyo en desarrollo del sistema
</p>

---

## 📌 Objetivo

Desarrollar un sistema funcional que permita gestionar préstamos de manera clara, controlada y escalable, aplicando buenas prácticas de análisis y diseño de software.

---

## ⚠️ Notas

- Este proyecto es de carácter académico  
- Se encuentra en constante desarrollo  
- La implementación funcional aún no está disponible  

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
