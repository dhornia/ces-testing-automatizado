package com.tatf.adminces.suite.tests;

import com.tatf.adminces.modules.admin.data.CrearAdminData;
import com.tatf.adminces.modules.app.data.AppData;
import com.tatf.adminces.modules.app.task.AppTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.tester.task.CrearTesterTask;
import com.tatf.adminces.modules.users.task.UserTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TesterCreateTest extends BaseTest {

    private AppTask app;
    private HomeTask home;
    private CrearTesterTask crearTester;
    private LoginTask login;
    private UserTask user;

    @BeforeEach
    public void configurar() {
        this.app = new AppTask(browser);
        this.home = new HomeTask(browser);
        this.crearTester = new CrearTesterTask(browser);
        this.login = new LoginTask(browser);
        this.user = new UserTask(browser);

        this.app.enterToSystem(AppData.hash);
    }

    @Tag("regression")
    @Tag("tester-module")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/crear_tester_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Crea una cuenta de usuario de tipo Tester correctamente")
    public void crearTesterCorrectamenteTest(String nombre, String apellido, String email, String pais, String contrasena, String perfil) {

        this.home.enterToLogin();

        String title = this.login.getTitle();
        IVerify.create().verify(LoginData.title, title, "El título no es el esperado.");

        this.login.loginToSystem(LoginData.emailValue, LoginData.passwordValue);

        String logguedUser = this.home.getUserLoggedIn();
        IVerify.create().verify(LoginData.adminName + " " + LoginData.adminLastname, logguedUser, "El usuario no es " + "correcto");

        this.home.enterToTesterCreate();

        String message = this.crearTester.createTesterAccount(nombre, apellido, email, pais, contrasena, perfil);
        IVerify.create().verify(CrearAdminData.successMsg, message, "El sistema no mostró mensaje de usuario creado.");

        this.home.enterToUsersList();
        boolean userDisplayed = this.user.userExistsByEmailAndProfile(email, perfil);
        IVerify.create().verifyTrue(userDisplayed, "El usuario no se visualiza en la tabla de usuarios");
    }
}