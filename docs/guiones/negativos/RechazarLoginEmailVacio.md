Escenario: Rechazar el inicio de sesión con el email vacío

Descripción: Verificar que el sistema impida iniciar sesión cuando el usuario no ingresa un email

Precondiciones:
- La aplicación debe estar disponible y accesible mediante la url indicada
- Disponer de un hash válido para acceder al sitio

Guión:
1. [[Ingresar a la aplicación AdminCES]]
2. [[Iniciar sesión({{adminEmail}}, {{adminContraseña}})]]
3. Verificar que el sistema rechace el inicio de sesión y muestre el mensaje correspondiente al email vacío
