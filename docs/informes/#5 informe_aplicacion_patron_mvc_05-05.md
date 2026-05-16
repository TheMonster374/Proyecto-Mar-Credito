<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%202%20—%20Aplicación%20del%20Patrón%20MVC&fontSize=32&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-16%2F05%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.6-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Tipo-Arquitectura%20MVC-orange?style=for-the-badge">
</p>

---

## 🎯 Objetivo

Aplicar el patrón MVC para separar responsabilidades:

- **Modelo**: datos y entidades (`model`)
- **Controlador**: coordina casos de uso y valida entradas (`controller`)
- **Servicio**: administra el estado/almacenamiento en memoria (`service`)
- **Vista**: interfaz Swing (`view`)

---

## 🛠️ Actividades realizadas

- Se centralizó la lógica en `SistemaBanco` (capa `service`), como estructura principal que mantiene/gestiona información del sistema.
- Se creó/ajustó `ControladorBanco` (capa `controller`) como punto de acceso para la UI: la vista no manipula directamente el modelo.
- Se definió que la vista (Swing) solo:
  - captura datos del usuario,
  - llama al controlador,
  - muestra resultados (mensajes / navegación).

---

## ✅ Resultado

- El proyecto quedó con una arquitectura más limpia y mantenible.
- Se redujo el acoplamiento: la interfaz no depende directamente de estructuras internas del modelo.

---

## 📎 Evidencias (en repositorio)

- `src/marcredito/service/SistemaBanco.java`
- `src/marcredito/controller/ControladorBanco.java`

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
