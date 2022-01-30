package io.techstack.components.formBox;

import io.techstack.components.BaseComponent;
import org.openqa.selenium.By;

public class FormBox extends BaseComponent {
    @Override
    public By construct() {
        return By.xpath(".//form[@id = '"+ identifier +"']");
    }
}
