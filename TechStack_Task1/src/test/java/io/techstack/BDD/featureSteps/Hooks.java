package io.techstack.BDD.featureSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.techstack.beforeActionAndTestResources.DriverHelper;

public class Hooks extends BaseSteps {
    private BaseSteps baseSteps;

    public Hooks(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @Before
    public void setup() {
        baseSteps.setDriver(DriverHelper.getDriver());
    }

    @After
    public void teardown() {
        baseSteps.getDriver().close();
    }
}
