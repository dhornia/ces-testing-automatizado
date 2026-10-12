# QA Automation Framework | AdminCES

**Automatización de pruebas funcionales web con Java y Selenium WebDriver.**

Framework de automatización desarrollado como proyecto de especialización en Testing Funcional, enfocado en validar flujos críticos de una aplicación web, mejorar la mantenibilidad de las pruebas y facilitar la ejecución organizada de escenarios automatizados.

## 🛠️ Tecnologías

- **Java** — lenguaje de programación.
- **Selenium WebDriver** — automatización de la interfaz web.
- **JUnit 6** — ejecución, organización y parametrización de pruebas.
- **Maven** — gestión de dependencias y ejecución del proyecto.
- **Allure** — generación de reportes de pruebas.

## 🧪 Cobertura funcional

El framework contempla escenarios de prueba para:

- **Autenticación:** inicio de sesión con credenciales válidas e inválidas.
- **Recuperación de acceso:** reinicio de contraseña.
- **Gestión de usuarios:** creación de administradores y testers.
- **Eliminación de usuarios:** validación del flujo de eliminación de testers.

Los escenarios se organizan en clases de prueba y suites funcionales para facilitar su mantenimiento y ejecución.

## 🏗️ Arquitectura

El proyecto aplica una separación de responsabilidades inspirada en Page Object Model (POM):

- **PO (Page Objects):** interacción con los elementos de la interfaz.
- **Task:** encapsulación de acciones y flujos funcionales.
- **Data:** centralización de datos de prueba.
- **Tests:** definición de escenarios y validaciones.
- **Suites:** agrupación de pruebas por funcionalidad y objetivo de ejecución.

Esta organización favorece la reutilización de componentes, reduce el acoplamiento y facilita la incorporación de nuevos escenarios.

## ▶️ Ejecución

### Requisitos previos

- JDK compatible con la configuración del proyecto.
- Maven.
- Google Chrome | Firefox | Safari.
- Acceso al entorno de pruebas de AdminCES.

### Ejecutar las pruebas

Desde la carpeta `automation-framework`:

```bash
mvn clean test
```

Para ejecutar las pruebas desde IntelliJ IDEA, abre el proyecto Maven y ejecuta la clase de prueba o suite que quieras validar.

## 📊 Reportes

El proyecto incorpora Allure para facilitar el análisis de resultados y la identificación de pruebas fallidas.

Los resultados de ejecución se generan en el directorio `target/`. La integración del reporte debe verificarse después de ejecutar las pruebas.

## 🚀 Objetivo del proyecto

Desarrollar una base de automatización mantenible, reutilizable y escalable, aplicando buenas prácticas de diseño de pruebas funcionales y organización del código.

**Enfoque:** calidad del software, automatización funcional, reutilización de componentes y análisis de resultados.

## 📚 Documentación de pruebas

- [Escenarios funcionales](docs/guiones/)

