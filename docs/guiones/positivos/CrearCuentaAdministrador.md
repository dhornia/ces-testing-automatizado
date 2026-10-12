Escenario: Crear cuenta Administrador

Descripción: Verificar que se pueda registrar correctamente una cuenta de usuario con perfil Administrador y que el usuario creado quede registrado con el perfil correspondiente.

Precondiciones:
- La aplicación debe estar disponible y accesible mediante la url indicada
- Disponer de un hash válido para acceder al sitio
- Disponer de credenciales válidas de una cuenta de administrador

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
11. [[Iniciar sesión({{adminEmail}}, {{adminContraseña}})]]
12. [[Verificar usuario({{email}}, Administrador)]]


