package com.tatf.core.driver.manager;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FifefoxDriver extends DriverManager {
    /**
     * Crea el driver de Firefox con las opciones por defecto.
     */
    public FifefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--guest");

        this.driver = new org.openqa.selenium.firefox.FirefoxDriver(firefoxOptions);
        setDefaultConfig();
    }
}
