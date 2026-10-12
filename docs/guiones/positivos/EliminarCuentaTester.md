Escenario: Eliminar cuenta Tester

Descripción: Verificar que un usuario Administrador puede eliminar correctamente una cuenta de usuario con perfil Tester y que el usuario eliminado deje de aparecer en la lista de usuarios registrados.

Precondiciones:
- La aplicación debe estar disponible y accesible mediante la url indicada
- Disponer de un hash válido para acceder al sitio
- Disponer de credenciales válidas de una cuenta de administrador
- Debe existir una cuenta de usuario con perfil Tester que se pueda eliminar

Guión:
1. [[Ingresar a la aplicación AdminCES]]
2. [[Iniciar sesión(adminEmail, adminContraseña)]]
3. [[Verificar usuario({{email}}, {{perfil}})]]
4. Clic en el botón con ícono de papelera correspondiente al usuario
5. Verificar que el email del usuario es el mismo que se muestra en el popup de confirmación
6. Clic en la opción Sí en el popup
7. Clic en la opción OK en el popup con mensaje Usuario eliminado
8. Verificar que no se encuentre el email {{email}} en la lista de usuarios registrados

