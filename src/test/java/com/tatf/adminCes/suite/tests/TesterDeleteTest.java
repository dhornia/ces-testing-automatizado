package com.tatf.adminces.suite.tests;

import com.tatf.adminces.modules.app.data.AppData;
import com.tatf.adminces.modules.app.task.AppTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.home.task.HomeTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.users.data.UserData;
import com.tatf.adminces.modules.users.task.UserTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TesterDeleteTest extends BaseTest {

    private AppTask app;
    private HomeTask home;
    private LoginTask login;
    private UserTask users;

    @BeforeEach
    public void configurar() {
        this.app = new AppTask(browser);
        this.home = new HomeTask(browser);
        this.login = new LoginTask(browser);
        this.users = new UserTask(browser);

        this.app.enterToSystem(AppData.hash);
    }

    @Tag("regression")
    @Tag("tester-module")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/eliminar_tester_data.csv", useHeadersInDisplayName = true)
    @DisplayName("Elimina una cuenta de Tester correctamente")
    public void eliminarCuentaTesterTest(String email, String perfil) {

        this.home.enterToLogin();

        this.login.loginToSystem(LoginData.emailValue, LoginData.passwordValue);

        this.home.enterToUsersList();

        String title = this.users.getTitle();
        IVerify.create().verify(UserData.title, title, "El título no es el esperado.");

        this.users.userExistsByEmailAndProfile(email, perfil);

        String message = this.users.deleteUser(email);
        IVerify.create().verifyTrue(message.contains(email), "El mensaje contiene el email del usuario a eliminar");

        boolean userExistnotExist = !users.userExistsByEmail(email);
        IVerify.create().verifyTrue(userExistnotExist, "El usuario " + email + " no debe aparecer en la lista de usuarios");
    }
}