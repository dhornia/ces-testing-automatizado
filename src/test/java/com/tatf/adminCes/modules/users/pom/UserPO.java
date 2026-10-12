package com.tatf.adminces.modules.users.pom;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;

public class UserPO {
    private final IBrowser browser;
    private static final String userByEmailAndProfileXpath = "//table//tr[td[3][normalize-space(.)='%s'] and td[5][contains(translate(normalize-space(.), 'íÍ', 'iI'), translate('%s', 'íÍ', 'iI'))]]";
    private static final String userByEmailXpath = "//table//tr[td[3][text()='%s']]";
    private static final String title = "h4";
    private static final String confirmationMessage = "swal2-html-container";
    private static final String deleteConfirmButton = "swal2-confirm";
    private static final String confirmButton = "swal2-confirm";

    public UserPO(IBrowser browser) {
        this.browser = browser;
    }

    public Element findUserByEmailAndProfile(String email, String profile) {
        String xpath = String.format(userByEmailAndProfileXpath, email, profile);
        return browser.find().xpath(xpath);
    }

    public boolean userExistsByEmail(String email) {
        String xpath = String.format(userByEmailXpath, email);
        return !browser.find().xpathList(xpath).isEmpty();
    }

    public String getTitle() {
        return this.browser.find().tag(title).getText();
    }

    public void clickUserDeleteBtn(String email) {
        browser.find().id(email).click();
    }

    public String getConfirmationMessage() {
        return browser.find().id(confirmationMessage).getText();
    }

    public void clickDeleteConfirm() {
        browser.find().className(deleteConfirmButton).click();
    }

    public void clickConfirm() {
        browser.find().className(confirmButton).click();
    }
}