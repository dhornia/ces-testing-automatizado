package com.tatf.adminces.modules.admin.task;

import com.tatf.adminces.modules.admin.pom.CrearAdminPO;
import com.tatf.core.browser.IBrowser;

public class CrearAdminTask {
    IBrowser browser;
    private final CrearAdminPO admin;

    public CrearAdminTask(IBrowser browser) {
        this.browser = browser;
        this.admin = new CrearAdminPO(browser);
    }

    public String getTitle() {
        return this.admin.getTitle();
    }

    public String createAdminAccount(
            String firstName,
            String lastName,
            String email,
            String password,
            String country) {

        admin.enterFirstName(firstName);
        admin.enterLastName(lastName);
        admin.enterEmail(email);
        admin.enterPassword(password);
        admin.enterRepeatPassword(password);
        admin.enterCountry(country);
        admin.clickRegisterButton();
        String msg = admin.getConfirmationMessage();
        admin.clickConfirm();
        return msg;
    }
}