package com.tatf.adminces.modules.passwordReset.pom;

import com.tatf.core.browser.IBrowser;

public class passwordResetPO {
    private final IBrowser browser;
    private static final String title = "h5";
    private static final String emailInput = "inputEmail";
    private static final String passwordInput = "inputPassword";
    private static final String repeatPasswordInput = "inputRepeatPassword";
    private static final String resetButton = "btnReset";
    private static final String confirmButton = "swal2-confirm";
    private static final String confirmationMessage = "swal2-html-container";

    public passwordResetPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle() {return this.browser.find().tag(title).getText();}

    public void enterEmail(String email) {
        browser.find().name(emailInput).write(email);
    }

    public void enterPassword(String password) {
        browser.find().name(passwordInput).write(password);
    }

    public void enterRepeatPassword(String password) {
        browser.find().name(repeatPasswordInput).write(password);
    }

    public void clickResetButton() {
        browser.find().id(resetButton).click();
    }

    public void clickConfirm() {
        browser.find().className(confirmButton).click();
    }

    public String getConfirmationMessage() {
        return browser.find().id(confirmationMessage).getText();
    }
}