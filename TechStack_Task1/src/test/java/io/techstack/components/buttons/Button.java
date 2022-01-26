package io.techstack.components.buttons;

import io.techstack.components.BaseComponent;
import org.openqa.selenium.By;

public class Button extends BaseComponent {
    @Override
    public By construct() {
        String identifier = "submit";
        return By.xpath(".//button[@type='" + identifier + "']");
    }

    public void clickOnButton() {
        instances.get(identifier).click();
    }
}