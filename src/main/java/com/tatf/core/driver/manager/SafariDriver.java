package com.tatf.core.driver.manager;


import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class SafariDriver extends DriverManager{
    /**
     * Crea el driver de Safari con las opciones por defecto.
     */
    public SafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("safari:diagnose", true);
        this.driver = new org.openqa.selenium.safari.SafariDriver(safariOptions);

        setDefaultConfig();
    }

    @Override
    protected void setDefaultConfig() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_DEFAULT_SECONDS));
        driver.manage().window().maximize();
    }
}
