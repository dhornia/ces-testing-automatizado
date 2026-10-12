package com.tatf.adminces.modules.login.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {
    private final IBrowser browser;
    private static final String title = "h5";
    private static final String emailInput = "inputEmail";
    private static final String passwordInput = "inputPassword";
    private static final String btnLogin = "#formLogin button";
    private static final String btnPopup = "swal2-confirm";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle() {return this.browser.find().tag(title).getText();}

    public void enterEmail(String emailValue) {
        this.browser.find().name(emailInput).write(emailValue);
    }

    public void enterPassword(String password) {
        this.browser.find().name(passwordInput).write(password);
    }

    public void clickIngresar() {
        this.browser.find().css(btnLogin).click();
    }

    public void clickPopup() {
        this.browser.find().className(btnPopup).click();
    }
}
