package com.tatf.adminces.modules.passwordReset.task;

import com.tatf.adminces.modules.passwordReset.pom.passwordResetPO;
import com.tatf.core.browser.IBrowser;

public class passwordResetTask {

    private final passwordResetPO resetPassword;

    public passwordResetTask(IBrowser browser) {
        this.resetPassword = new passwordResetPO(browser);
    }

    public String getTitle() {
        return this.resetPassword.getTitle();
    }

    public String resetPassword(String email, String password) {
        this.resetPassword.enterEmail(email);
        this.resetPassword.enterPassword(password);
        this.resetPassword.enterRepeatPassword(password);
        this.resetPassword.clickResetButton();
        String message = this.resetPassword.getConfirmationMessage();
        this.resetPassword.clickConfirm();
        return message;
    }
}