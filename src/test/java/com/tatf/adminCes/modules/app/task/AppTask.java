package com.tatf.adminces.modules.app.task;

import com.tatf.adminces.modules.app.pom.AppPO;
import com.tatf.core.browser.IBrowser;

public class AppTask {
    private final AppPO app;

    public AppTask(IBrowser browser) {
        this.app = new AppPO(browser);
    }

    public void enterToSystem(String hash) {
        this.app.enterHash(hash);
        this.app.clickIngresar();
    }
}
