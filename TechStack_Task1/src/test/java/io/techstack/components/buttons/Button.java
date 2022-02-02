package io.techstack.components.buttons;

import io.techstack.components.BaseComponent;
import org.openqa.selenium.By;

public class Button extends BaseComponent {
    @Override
    public By construct() {
        return By.xpath(".//button[@type='" + identifier + "']");
    }
}