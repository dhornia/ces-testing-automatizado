Escenario: Rechazar la creación de un administrador con email existente

Descripción: Verificar que no se permita registrar dos cuentas con el mismo email.

Precondiciones
- La aplicación debe estar disponible y accesible mediante la url indicada
- Disponer de un hash válido para acceder al sitio
- Disponer de una cuenta registrada con el correo que se utilizará en la prueba

Guión:
1. [[Ingresar a la aplicación AdminCES]]
2. Clic en la opción del menú Registrarse
3. Ingresar {{nombre}} en el campo Nombre
4. Ingresar {{apellido}} en el campo Apellido
5. Ingresar {{email}} en el campo Email
6. Ingresar {{contraseña}} en el campo Contraseña
7. Ingresar {{contraseña}} en el campo Repetir Contraseña
8. Ingresar {{país}} en el campo País nacimiento
9. Clic en el botón Registrarse
10. Clic en la opción OK en el popup
11. Verificar que el sistema rechace el registro y muestre el mensaje correspondiente a un correo ya registrado