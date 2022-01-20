package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FinalStepPage {
    @FindBy(xpath = ".//div[contains(text(),'Almost done!')]")
    private WebElement successfulBanner;

    private WebDriver driver;

    public FinalStepPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
