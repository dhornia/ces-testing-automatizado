package com.tatf.adminces.suite.tests;

import com.tatf.adminces.modules.admin.data.CrearAdminData;
import com.tatf.adminces.modules.app.data.AppData;
import com.tatf.adminces.modules.app.task.AppTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.admin.task.CrearAdminTask;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.users.task.UserTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AdminCreateTest extends BaseTest {
    private AppTask app;
    private HomeTask home;
    private LoginTask login;
    private CrearAdminTask crearAdmin;
    private UserTask user;

    @BeforeEach
    public void configurar() {
        this.app = new AppTask(browser);
        this.home = new HomeTask(browser);
        this.login = new LoginTask(browser);
        this.crearAdmin = new CrearAdminTask(browser);
        this.user = new UserTask(browser);

        this.app.enterToSystem(AppData.hash);
    }

    @Tag("regression")
    @Tag("admin-module")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/crear_admin_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Crea una cuenta de usuario de tipo administrador correctamente")
    public void crearAdministradorCorrectamenteTest(String nombre, String apellido, String email, String contrasena, String pais) {

        this.home.enterToRegister();

        String title = this.crearAdmin.getTitle();
        IVerify.create().verify(CrearAdminData.title, title, "El título no es el esperado.");

        String message = this.crearAdmin.createAdminAccount(nombre, apellido, email, contrasena, pais);
        IVerify.create().verify(CrearAdminData.successMsg, message, "El sistema no mostró mensaje de usuario creado.");

        this.home.enterToLogin();
        this.login.loginToSystem(email, contrasena);
        String logguedUser = this.home.getUserLoggedIn();
        IVerify.create().verify(nombre + " " + apellido, logguedUser, "No se visualizan los datos correctos");
    }

    @Tag("regression")
    @Tag("admin-module")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/crear_admin_ya_existe_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Rechaza la creación de un administrador con email registrado en el sistema")
    public void noCrearAdminYaExisteTest(String nombre, String apellido, String email, String contrasena, String pais) {

        this.home.enterToRegister();

        String title = this.crearAdmin.getTitle();
        IVerify.create().verify(CrearAdminData.title, title, "El título no es el esperado.");

        String message = this.crearAdmin.createAdminAccount(nombre, apellido, email, contrasena, pais);
        IVerify.create().verify(CrearAdminData.userExist, message, "El sistema no mostró el mensaje esperado.");
    }
}