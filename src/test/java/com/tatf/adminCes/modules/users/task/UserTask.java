package com.tatf.adminces.modules.users.task;

import com.tatf.adminces.modules.users.pom.UserPO;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;

public class UserTask {
    private final UserPO users;

    public UserTask(IBrowser browser) {
        this.users = new UserPO(browser);
    }

    public String getTitle() {
        return this.users.getTitle();
    }

    public boolean userExistsByEmailAndProfile(String email, String profile) {
        Element user = users.findUserByEmailAndProfile(email, profile);
        return user.isDisplayed();
    }

    public boolean userExistsByEmail(String email) {
        return users.userExistsByEmail(email);
    }

    public String deleteUser(String email) {
        this.users.clickUserDeleteBtn(email);

        String message = this.users.getConfirmationMessage();
        this.users.clickDeleteConfirm();
        this.users.clickConfirm();
        return message;
    }
}