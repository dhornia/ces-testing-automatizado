package com.tatf.adminces.suite.tests;

import com.tatf.adminces.modules.app.data.AppData;
import com.tatf.adminces.modules.app.task.AppTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.home.data.HomeData;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTest extends BaseTest {
    private AppTask app;
    private HomeTask home;
    private LoginTask login;

    @BeforeEach
    public void configurar() {
        this.app = new AppTask(browser);
        this.home = new HomeTask(browser);
        this.login = new LoginTask(browser);

        this.app.enterToSystem(AppData.hash);
    }

    @Tag("smoke")
    @Tag("regression")
    @Tag("authentication")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/login_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Inicia sesión con usuario y contraseña correcto")
    public void iniciarSesionCorrectoTest(String email, String contrasena, String nombre, String apellido) {

        String homeTitle = this.home.getTitle();
        IVerify.create().verify(HomeData.title, homeTitle, "El título no es el esperado.");

        this.home.enterToLogin();

        String loginTitle = this.login.getTitle();
        IVerify.create().verify(LoginData.title, loginTitle, "El título no es el esperado.");

        this.login.loginToSystem(email, contrasena);

        String loggedUser = this.home.getUserLoggedIn();
        IVerify.create().verify(nombre + " " + apellido, loggedUser, "El usuario no es el esperado.");
    }

    @Tag("smoke")
    @Tag("regression")
    @Tag("authentication")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/invalid_user_data.csv", useHeadersInDisplayName = true)
    @DisplayName("No inicia sesión cuando el email está vacío")
    public void noIniciarSesionSinEmailTest(String email, String contrasena) {

        String homeTitle = this.home.getTitle();
        IVerify.create().verify(HomeData.title, homeTitle, "El título no es el esperado.");

        this.home.enterToLogin();

        String loginTitle = this.login.getTitle();
        IVerify.create().verify(LoginData.title, loginTitle, "El título no es el esperado.");

        this.login.loginToSystem(email, contrasena);

        String loggedUser = this.home.getUserLoggedIn();
        IVerify.create().verify("Iniciar sesión", loggedUser, "El sistema no debería permitir el acceso sin email.");
    }
}
