<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%20de%20Cambios%20de%20los%20Diagramas%20UML&fontSize=35&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=16&duration=3500&pause=1000&color=4F46E5&center=true&vCenter=true&width=600&lines=Evolución+y+Mejora+de+Diagramas+UML;Versión+preliminar+→+Versión+profesional;Sistema+de+préstamos+Banco+Diario" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-08%2F04%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versión-1.2-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Tipo-Diagramas%20UML-orange?style=for-the-badge">
</p>

---

## 📌 Resumen

Este documento detalla los ajustes realizados para pasar de una versión preliminar a una versión profesional, alineada con la lógica de un sistema de préstamos.

---

## 🏗️ 1. Diagrama de Clases (Estructura de Datos)

En la versión nueva **(1.2)**, se aplicaron principios de Programación Orientada a Objetos (POO) para dar robustez al diseño:

### 🔗 Implementación de Herencia (Generalización)
Antes, `Prestamista` y `Solicitante` eran clases aisladas. Ahora heredan de la clase `Usuario`. Esto centraliza los atributos comunes y es más eficiente.

### ✏️ Corrección de Multiplicidades
Se ajustaron las relaciones de negocio. Se definió que un `Usuario (1)` puede tener muchos `Préstamos (*)` y muchos `PQRS (*)`, corrigiendo la restricción previa de 1 a 1.

### 🔷 Uso de Agregación (`o--`)
Se utilizó para representar que `SistemaBanco` gestiona colecciones (como `ArrayList`s) de `Usuario` y `Prestamo`. Indica que el sistema "contiene" estos datos, pero no es dueño de su ciclo de vida absoluto.

### 🔶 Uso de Composición (`*--`)
Se aplicó en las clases `Pago` y `Acuerdo` respecto a `Prestamo`. Esto garantiza que, si un préstamo se elimina del sistema, sus pagos y su contrato legal asociado también desaparezcan, manteniendo la integridad referencial.

### 🖼️ Comparación Visual — Diagrama de Clases

> Nota: En v1.2 los archivos ya usan el nombre del proyecto renombrado (**Mar Crédito**), mientras que v1.1 conserva el nombre histórico (**Banco Diario**).

| Versión 1.1 (Anterior) | Versión 1.2 (Nueva) |
|:---:|:---:|
| ![Diagrama de Clases v1.1](../diagrams_history/1.1/diagrams_png/Banco%20Diario%20Diagrama%20Clases%20(1.1).png) | ![Diagrama de Clases v1.2](../diagrams_history/1.2/diagrams_png/Mar%20Credito%20Diagrama%20Clases%20(1.2).png) |

---

## 🎭 2. Diagrama de Casos de Uso (Funcionalidad)

La mejora aquí se centró en la lógica de permisos y la claridad visual:

### 👥 Delimitación de Roles

| Actor | Permisos asignados |
|---|---|
| 🟢 **Solicitante** | Gestión exclusiva de sus propios pagos |
| 🔵 **Prestamista** | Generación de acuerdos y validación de préstamos |
| 🔴 **Administrador** | Acceso total: administración del sistema y base de usuarios |

### 🔄 Consistencia de Entidades
Se añadió el caso de uso **"Gestionar PQRS"** para ser coherente con la nueva clase incluida en el diagrama estructural.

### 🎨 Mejora Estética y Semántica
- Se reemplazaron las relaciones de agregación/composición (que no pertenecen a este diagrama) por **líneas de asociación dirigidas** (`-->`).
- Se implementó un **código de colores** para facilitar la lectura rápida de responsabilidades:
  - 🔵 Azul → Prestamista
  - 🟢 Verde → Solicitante
  - 🔴 Rojo → Administrador

### 🖼️ Comparación Visual — Diagrama de Casos de Uso

| Versión 1.1 (Anterior) | Versión 1.2 (Nueva) |
|:---:|:---:|
| ![Diagrama UC v1.1](../diagrams_history/1.1/diagrams_png/Banco%20Diario%20Diagrama%20UC%20(1.1).png) | ![Diagrama UC v1.2](../diagrams_history/1.2/diagrams_png/Mar%20Credito%20Diagrama%20UC%20(1.2).png) |

---

## 🎓 3. Justificación Técnica

> *"Los diagramas ahora son consistentes entre sí. El `Usuario` del diagrama de clases tiene su reflejo en los Casos de Uso mediante las funciones de perfil y PQRS. Las relaciones de agregación del diagrama de clases justifican técnicamente cómo el software almacenará las listas de datos (mediante `ArrayList`s) que los actores manipulan en los casos de uso."*

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
