package io.techstack.components.inputs;

import io.techstack.components.BaseComponent;
import org.openqa.selenium.By;

public class Input extends BaseComponent {
    @Override
    public By construct() {
        return By.xpath(".//input[@name='" + identifier + "']");
    }
}
