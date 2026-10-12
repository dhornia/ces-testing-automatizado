package com.tatf.adminces.modules.home.pom;

import com.tatf.core.browser.IBrowser;

public class HomePO {
    private final IBrowser browser;
    private static final String title = "#content p";
    private static final String loginLink = "Iniciar sesión";
    private static final String registerLink = "Registrarse";
    private static final String resetPasswordLink = "Reiniciar contraseña";
    private static final String testerCreateLink = "Crear usuario";
    private static final String usersList = "Ver usuarios";
    private static final String userDropdown = "dropdown-toggle";

    public HomePO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle() {
        return this.browser.find().css(title).getText();
    }

    public void clickLoginLink() {
        browser.find().link(loginLink).click();
    }

    public void clickRegisterLink() {
        browser.find().link(registerLink).click();
    }

    public void clickResetPasswordLink() {
        browser.find().link(resetPasswordLink).click();
    }

    public void clickTesterCreateLink() {
        browser.find().link(testerCreateLink).click();
    }

    public void clickUsersListLink() {
        browser.find().link(usersList).click();
    }

    public String getUserLogIn() {
        return browser.find().className(userDropdown).getText();
    }
}
