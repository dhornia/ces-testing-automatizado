Escenario: Reiniciar contraseña

Descripción: Verificar que un usuario con perfil administrador pueda establecer una nueva contraseña y utilizarla para iniciar sesión correctamente.

Precondiciones:
- La aplicación debe estar disponible y accesible mediante la URL indicada.
- Disponer de un hash válido para acceder al sitio
- Disponer del email de un usuario registrado

Guión:
1. [[Ingresar a la aplicación AdminCES]]
2. Clic en la opción del menú Reiniciar contraseña
3. Ingresar {{email}} en el campo Email
4. Ingresar {{nuevaContraseña}} en el campo Contraseña
5. Ingresar {{nuevaContraseña}} en el campo Repetir Contraseña
6. Clic en el botón Rei. Contraseña
7. Clic en la opción OK en el popup
8. [[Iniciar sesión({{email}}, {{nuevaContraseña}})]]