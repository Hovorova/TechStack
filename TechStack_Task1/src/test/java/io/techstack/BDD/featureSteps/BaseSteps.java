package io.techstack.BDD.featureSteps;

import org.openqa.selenium.WebDriver;

public class BaseSteps {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
