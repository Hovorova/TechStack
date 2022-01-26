package io.techstack.components.inputs;

import io.techstack.components.BaseComponent;
import org.openqa.selenium.By;

public class Input extends BaseComponent {
    @Override
            // id = firstname
    public By construct() {
        return By.xpath(".//input[@name='" + identifier + "']");
    }

    public void inputText(String input) {
        instances.get(identifier).sendKeys(input);
    }
}
