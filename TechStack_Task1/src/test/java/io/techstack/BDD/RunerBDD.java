package io.techstack.BDD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/io/techstack/BDD/features",
        glue = {"io/techstack/BDD/featureSteps"},
        plugin = {"pretty"}
)

public class RunerBDD {
}