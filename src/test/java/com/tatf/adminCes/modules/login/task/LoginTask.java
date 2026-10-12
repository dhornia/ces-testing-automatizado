package com.tatf.adminces.modules.login.task;

import com.tatf.adminces.modules.login.pom.LoginPO;
import com.tatf.core.browser.IBrowser;

public class LoginTask {
    private final LoginPO login;

    public LoginTask(IBrowser browser) {
        this.login = new LoginPO(browser);
    }

    public String getTitle() {
        return this.login.getTitle();
    }

    public void loginToSystem(String email, String password) {
        this.login.enterEmail(email);
        this.login.enterPassword(password);
        this.login.clickIngresar();
        this.login.clickPopup();
    }
}
