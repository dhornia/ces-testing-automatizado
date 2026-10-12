package com.tatf.adminces.modules.tester.pom;

import com.tatf.core.browser.IBrowser;

public class CrearTesterPO {
    private final IBrowser browser;
    private static final String title = "h5";
    private static final String firstNameInput = "inputFirstName";
    private static final String lastNameInput = "inputLastName";
    private static final String emailInput = "inputEmail";
    private static final String countryInput = "inputCountry";
    private static final String passwordInput = "inputPassword";
    private static final String registerButton = "btnRegister";
    private static final String confirmButton = "swal2-confirm";
    private static final String confirmMessage = "swal2-html-container";

    public CrearTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public String getTitle() {return this.browser.find().tag(title).getText();}

    public void enterFirstName(String firstName) {
        browser.find().name(firstNameInput).write(firstName);
    }

    public void enterLastName(String lastName) {
        browser.find().name(lastNameInput).write(lastName);
    }

    public void enterEmail(String email) {
        browser.find().name(emailInput).write(email);
    }

    public void selectCountry(String country) {
        browser.find().name(countryInput).selectValue(country);
    }

    public void enterPassword(String password) {
        browser.find().name(passwordInput).write(password);
    }

    public void selectProfile(String profile) {
        browser.find()
                .xpath("//label[text()='" + profile + "']")
                .click();
    }

    public void clickRegisterButton() {
        browser.find().id(registerButton).click();
    }

    public void clickConfirm() {
        browser.find().className(confirmButton).click();
    }

    public String getConfirmationMessage() {
        return browser.find().id(confirmMessage).getText();
    }
}
