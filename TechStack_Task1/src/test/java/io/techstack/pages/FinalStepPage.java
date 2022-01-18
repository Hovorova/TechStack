package io.techstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalStepPage {
    @FindBy(xpath = ".//div[contains(text(),'Almost done!')]")
    private WebElement successfulBanner;

    @FindBy(xpath = ".//div[@class='bui-modal__slot']")
    private WebElement popupWindowMoreInfo;

    @FindBy(xpath = ".//button[@class='bui-modal__close']")
    private WebElement closePopupWindowButton;

    private WebDriver driver;

    public FinalStepPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean confirmUserFillBookForm() {
        if (popupWindowMoreInfo.isDisplayed()) {
            closePopupWindowButton.click();
        }
        return (successfulBanner.isDisplayed());
    }
}
