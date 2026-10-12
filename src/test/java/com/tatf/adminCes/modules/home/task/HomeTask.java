package com.tatf.adminces.modules.home.task;

import com.tatf.adminces.modules.home.pom.HomePO;
import com.tatf.core.browser.IBrowser;

public class HomeTask {
    private final HomePO home;

    public HomeTask(IBrowser browser) {
        this.home = new HomePO(browser);
    }

    public String getTitle() {
        return this.home.getTitle();
    }

    public String getUserLoggedIn() {
        return this.home.getUserLogIn();
    }

    public void enterToLogin() {
        this.home.clickLoginLink();
    }

    public void enterToRegister() {
        this.home.clickRegisterLink();
    }

    public void enterToResetPassword() {
        this.home.clickResetPasswordLink();
    }

    public void enterToTesterCreate() {
        this.home.clickTesterCreateLink();
    }

    public void enterToUsersList() {
        this.home.clickUsersListLink();
    }
}
