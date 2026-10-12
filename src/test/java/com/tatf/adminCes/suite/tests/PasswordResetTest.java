package com.tatf.adminces.suite.tests;

import com.tatf.adminces.modules.app.data.AppData;
import com.tatf.adminces.modules.app.task.AppTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.passwordReset.data.passwordResetData;
import com.tatf.adminces.modules.passwordReset.task.passwordResetTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PasswordResetTest extends BaseTest {
    private AppTask app;
    private HomeTask home;
    private LoginTask login;
    private passwordResetTask resetPassword;

    @BeforeEach
    public void configurar() {
        this.app = new AppTask(browser);
        this.home = new HomeTask(browser);
        this.resetPassword = new passwordResetTask(browser);
        this.login = new LoginTask(browser);

        this.app.enterToSystem(AppData.hash);
    }

    @Tag("regression")
    @Tag("authentication")
    @Tag("password-reset")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/reiniciar_contrasena_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Cambio de contrasena exitoso")
    public void reiniciarContrasenaTest(String email, String contrasena, String nombre, String apellido) {

        this.home.enterToResetPassword();

        String title = this.resetPassword.getTitle();
        IVerify.create().verify(passwordResetData.title, title, "El título no es el esperado.");

        String msg = this.resetPassword.resetPassword(email, contrasena);
        IVerify.create().verify(passwordResetData.successMsg, msg, "El " + "mensaje no es el esperado");

        this.home.enterToLogin();
        this.login.loginToSystem(email, contrasena);

        String logguedUser = this.home.getUserLoggedIn();
        IVerify.create().verify(nombre + " " + apellido, logguedUser, "El usuario no es " + "correcto");
    }

    @Tag("regression")
    @Tag("authentication")
    @Tag("password-reset")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/user_not_found_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Rechaza cambio de contrasena a usuario inexistente")
    public void noReiniciarClaveUsuarioInexistenteTest(String email, String contrasena) {

        this.home.enterToResetPassword();

        String title = this.resetPassword.getTitle();
        IVerify.create().verify(passwordResetData.title, title, "El título no es el esperado.");

        String msg = this.resetPassword.resetPassword(email, contrasena);
        IVerify.create().verify(passwordResetData.userNotFoundMessage, msg, "El " + "mensaje no es el esperado");
    }
}
