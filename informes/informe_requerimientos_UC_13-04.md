<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=120&section=header&text=📋%20Informe%20de%20Requerimientos&fontSize=35&fontColor=ffffff" />
</p>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=16&duration=3500&pause=1000&color=4F46E5&center=true&vCenter=true&width=600&lines=Definici%C3%B3n+de+Requerimientos+Funcionales;Especificaci%C3%B3n+por+Caso+de+Uso;Sistema+de+Gesti%C3%B3n+Financiera+Banco+Diario" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Fecha-13%2F04%2F2026-4F46E5?style=for-the-badge">
  <img src="https://img.shields.io/badge/Versi%C3%B3n-1.3-22C55E?style=for-the-badge">
  <img src="https://img.shields.io/badge/Proyecto-Banco Diario-orange?style=for-the-badge">
</p>

---

## 📌 Resumen

Este documento establece los requerimientos mínimos de funcionamiento para cada caso de uso del sistema **Nexo** (anteriormente BancoDiario). El objetivo es transformar el modelo visual en una hoja de ruta técnica para el desarrollo del software.

---

## ⚙️ Especificación de Requerimientos 

A continuación, se detallan las reglas de negocio y funcionalidades técnicas que rigen cada interacción del sistema:

### 👤 1. Registrar/Gestionar Perfil
* **RF1.1:** El sistema debe permitir la creación de cuentas validando documento de identidad y correo.
* **RF1.2:** El sistema debe **cifrar las contraseñas antes de almacenarlas** para garantizar la seguridad.
* **RF1.3:** Los usuarios podrán actualizar datos de contacto con validación de formato en tiempo real.
* **RF1.4:** Implementación de un flujo de recuperación de acceso mediante correo electrónico.
* **RF1.5:** Soporte para carga de documentos de identidad en formatos digitales (PDF/JPG).

### 📝 2. Generar Acuerdos
* **RF2.1:** Definición de términos personalizados: interés, cuotas y frecuencia de cobro.
* **RF2.2:** Generación automática de contratos legales en formato PDF.
* **RF2.3:** Validación de límites de crédito según el cupo disponible del prestamista.
* **RF2.4:** Registro histórico de versiones de acuerdos para auditoría.
* **RF2.5:** Notificación automática al solicitante al emitirse un nuevo acuerdo.

### 📨 3. Gestionar PQRS
* **RF3.1:** Asignación de un código de radicado único para seguimiento de solicitudes.
* **RF3.2:** Capacidad de adjuntar evidencias multimedia (capturas de pantalla o fotos).
* **RF3.3:** Clasificación de prioridad (Alta, Media, Baja) por parte del administrador.
* **RF3.4:** Sistema de alertas para casos sin respuesta tras 15 días hábiles.
* **RF3.5:** Visualización del estado del trámite en el panel del usuario.

### 💰 4. Gestionar Préstamos
* **RF4.1:** Cálculo automático de tablas de amortización y proyección de intereses.
* **RF4.2:** Visualización de saldo pendiente y fechas de cobro en tiempo real para el solicitante.
* **RF4.3:** Facultad del administrador para suspender préstamos ante irregularidades detectadas.
* **RF4.4:** Generación de alertas de mora automáticas para pagos diarios atrasados.
* **RF4.5:** Restricción de desembolsos hasta la validación de la firma digital del contrato.

### 💳 5. Gestionar Pagos
* **RF5.1:** Integración con pasarelas de pago o registro manual de comprobantes.
* **RF5.2:** Actualización automática del saldo de capital e intereses tras cada abono.
* **RF5.3:** Emisión de recibos digitales descargables inmediatamente después del pago.
* **RF5.4:** Herramientas de reversión de pagos para el administrador en caso de error.
* **RF5.5:** Bloqueo de registros duplicados para evitar errores en la base de datos.

### 🛡️ 6. Gestionar Usuarios y Administrar Sistema
* **RF6.1:** Control de estado de cuentas (Activo/Inactivo) por el administrador.
* **RF6.2:** Registro de logs (auditoría) de todas las acciones realizadas por administradores.
* **RF6.3:** Configuración global de parámetros financieros (tasas de interés máximas).
* **RF6.4:** Ejecución de copias de seguridad automáticas de la base de datos cada 24 horas.
* **RF6.5:** Gestión de roles y permisos específicos para proteger información sensible.

---

## 🎓 Justificación de la Evolución

> *"Con la transición al nombre **Nexo**, el sistema deja de ser un simple registro diario para convertirse en una plataforma de intermediación financiera robusta. Los requerimientos aquí listados aseguran que la seguridad (mediante el cifrado de datos) y la integridad (mediante la gestión de pagos y acuerdos) sean los pilares técnicos del proyecto."*

---

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:4F46E5,100:22C55E&height=80&section=footer"/>
</p>
