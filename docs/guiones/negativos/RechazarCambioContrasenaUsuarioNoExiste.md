Escenario: Rechaza cambio de contrasena a usuario inexistente

Descripción: Verificar que el sistema rechace reiniciar la contraseña cuando el email ingresado no corresponde a 
ningún usuario registrado.

Precondiciones:
- La aplicación debe estar disponible y accesible mediante la URL indicada
- Disponer de un hash válido para acceder al sitio
- El email utilizado en la prueba no debe pertenecer a ningún usuario registrado

Guión:
1. [[Ingresar a la aplicación AdminCES]]
2. Clic en la opción del menú Reiniciar contraseña
3. Ingresar {{email}} en el campo Email
4. Ingresar {{nuevaContraseña}} en el campo Contraseña
5. Ingresar {{nuevaContraseña}} en el campo Repetir Contraseña
6. Clic en el botón Rei. Contraseña
7. Clic en la opción OK en el popup 
8. Verificar que el sistema rechace la operación y muestre el mensaje correspondiente a un usuario inexistente