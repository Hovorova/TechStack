package io.techstack.beforeActionAndTestResources;

import io.techstack.components.DriverWrapper;

public class DriverHelper {
    public static DriverWrapper getDriver() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        DriverWrapper driver = new DriverWrapper();
        driver.manage().window().maximize();
        return driver;
    }
}
