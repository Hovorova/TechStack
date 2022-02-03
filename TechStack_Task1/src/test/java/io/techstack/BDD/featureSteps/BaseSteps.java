package io.techstack.BDD.featureSteps;

import io.techstack.components.DriverWrapper;

public class BaseSteps {
    private DriverWrapper driver;

    public DriverWrapper getDriver() {
        return driver;
    }

    public void setDriver(DriverWrapper driver) {
        this.driver = driver;
    }
}
