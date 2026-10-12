package com.tatf.adminces.modules.base;

import com.tatf.adminces.modules.app.data.AppData;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected IBrowser browser;

    @BeforeEach
    void beforeEach() {
        browser = BrowserFactory.getBrowser();

        try {
            browser.interaction().navigateTo(AppData.url);
        } catch (RuntimeException e) {
            BrowserFactory.quitBrowser();
            browser = null;
            throw e;
        }
    }

    @AfterEach
    void afterEach() {
        browser = null;
        BrowserFactory.quitBrowser();
    }
}