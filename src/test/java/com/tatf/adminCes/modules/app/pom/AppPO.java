package com.tatf.adminces.modules.app.pom;

import com.tatf.core.browser.IBrowser;

public class AppPO {
    private final IBrowser browser;
    private static final String passInput = "pass";

    public AppPO(IBrowser browser) {
        this.browser = browser;
    }

    public void enterHash(String hash) {
        browser.find().id(passInput).write(hash);
    }

    public void clickIngresar() {
        browser.find().id("loginForm").tag("button").click();
    }
}
