Escenario: Crear cuenta Tester

Descripción: Verificar que un usuario Administrador pueda registrar correctamente una cuenta de usuario con perfil Tester y que el usuario creado quede registrado con el perfil correspondiente.

Precondiciones:
- La aplicación debe estar disponible y accesible mediante la url indicada
- Disponer de un hash válido para acceder al sitio
- Disponer de credenciales válidas de una cuenta de administrador

Guión:
1. [[Ingresar a la aplicación AdminCES]]
2. [[Iniciar sesión({{adminEmail}}, {{adminContraseña}})]]
3. Clic en la opción del menú Crear usuario
4. Ingresar {{nombre}} en el campo Nombre
5. Ingresar {{apellido}} en el campo Apellido
6. Ingresar {{email}} en el campo Email
7. Seleccionar {{país}} en el campo País de nacimiento
8. Ingresar {{contraseña}} en el campo Contraseña por defecto
9. Seleccionar el {{perfil}} correspondiente para el tester
10. Clic en el botón Crear cuenta
11. Clic en la opción OK en el popup
12. [[Verificar usuario({{email}}, {{perfil}})]]

