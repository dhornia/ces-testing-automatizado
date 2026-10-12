package com.tatf.adminces.modules.tester.task;

import com.tatf.adminces.modules.tester.pom.CrearTesterPO;
import com.tatf.core.browser.IBrowser;

public class CrearTesterTask {
    private final CrearTesterPO tester;

    public CrearTesterTask(IBrowser browser) {
        this.tester = new CrearTesterPO(browser);
    }

    public String getTitle() {
        return this.tester.getTitle();
    }

    public String createTesterAccount(
            String firstName,
            String lastName,
            String email,
            String country,
            String password,
            String profile) {

        tester.enterFirstName(firstName);
        tester.enterLastName(lastName);
        tester.enterEmail(email);
        tester.selectCountry(country);
        tester.enterPassword(password);
        tester.selectProfile(profile);
        tester.clickRegisterButton();
        String msg = tester.getConfirmationMessage();
        tester.clickConfirm();
        return msg;
    }
}