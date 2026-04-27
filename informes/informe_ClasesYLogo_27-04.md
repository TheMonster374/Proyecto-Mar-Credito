<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%20de%20Avances%20del%20Proyecto&fontSize=35&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=16&duration=3500&pause=1000&color=4F46E5&center=true&vCenter=true&width=650&lines=Implementación+inicial+del+modelo+de+usuarios;Integración+de+logo+adaptativo+en+GitHub;Documentación+de+avances" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-27%2F04%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.4-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Tipo-Avances%20de%20Implementación-orange?style=for-the-badge">
</p>

## 📌 Resumen

Este informe documenta los avances recientes del proyecto **Mar Crédito**, enfocados en:

- La mejora del **modelo de usuarios** en Java.
- La creación e integración de un **logo adaptativo** para modo claro/oscuro en GitHub.
- La actualización del **README** para presentar el logo correctamente.

---

## ☕ 1. Avance en Código (Java)

### ✅ Clases trabajadas

Se consolidó la base del modelo de usuarios mediante las clases:

- `Usuario` (clase abstracta base)
- `Prestamista` (hereda de `Usuario`)
- `Solicitante` (hereda de `Usuario`)

Ruta:

- `src/marcredito/model/Usuario.java`
- `src/marcredito/model/Prestamista.java`
- `src/marcredito/model/Solicitante.java`

### 🔧 Cambios realizados

#### 1.1. Mejora de `Usuario`

- Se definieron los atributos como `final` para mantener consistencia y evitar cambios inesperados en esta fase del proyecto.
- Se implementó el método `toString()` para facilitar la visualización y depuración de instancias.

> Nota: Por el momento no se implementa el modelo completo (por ejemplo `Prestamo`, `Pago`, `Acuerdo`, `PQRS`). Este avance busca preparar la estructura base y reflejar responsabilidades por rol.

#### 1.2. Métodos de estructura en roles (`Prestamista` y `Solicitante`)

Para evitar que las clases se perciban “vacías”, se añadieron métodos sencillos que representan responsabilidades del rol sin depender todavía de clases del dominio:

- `Prestamista`
  - `puedeFinanciar(monto)`
  - `generarAcuerdo(interesPorcentaje, plazoMeses)`
  - `financiarPrestamo(monto)`

- `Solicitante`
  - `solicitarPrestamo(monto, plazoMeses)`
  - `pagarCuota(valor)`

Estos métodos funcionan como una base de trabajo para implementar la lógica real cuando el modelo completo esté disponible.

---

## 🎨 2. Integración del Logo Adaptativo en GitHub

### ✅ Archivos gestionados

Se incluyeron versiones del logo optimizadas para los temas de GitHub:

- `assets/logo_light.png`
- `assets/logo_dark.png`

### 🌓 Integración en el README

Se integró el logo en el `README.md` usando la etiqueta HTML `<picture>`, lo cual permite que GitHub muestre automáticamente el logo correcto según el tema del usuario (claro u oscuro).

Estructura utilizada:

- `source` con `prefers-color-scheme: dark` → `assets/logo_dark.png`
- `source` con `prefers-color-scheme: light` → `assets/logo_light.png`
- `img` fallback → `assets/logo_light.png`
---

## 🖼️ Logos del Proyecto (Vista previa)

<p align="center">
  <b>Modo Claro</b><br>
  <img src="/assets/logo_light.png" width="420">
</p>

<p align="center">
  <b>Modo Oscuro</b><br>
  <img src="/assets/logo_dark.png" width="420">
</p>

---

## 📎 3. Evidencia de integración

- Se verifica visualmente el logo en la parte superior del repositorio al abrir `README.md`.
- El cambio es compatible con GitHub en modo oscuro y modo claro.

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
