package io.techstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalStepPage {
    @FindBy(xpath = ".//div[contains(text(),'Almost done!')]")
    private WebElement successfulBanner;
    @FindBy(xpath = "//*[@id=\"retain-leaving-users__modal\"]/div/div/header")
    private WebElement popupWindowMoreInfo;

    private WebDriver driver;

    public FinalStepPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean confirmUserFillBookForm() {
        return (successfulBanner.isDisplayed() || popupWindowMoreInfo.isDisplayed());
    }
}
