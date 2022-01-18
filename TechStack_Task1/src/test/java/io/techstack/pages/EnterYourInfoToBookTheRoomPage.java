package io.techstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterYourInfoToBookTheRoomPage {
    @FindBy(xpath = ".//section[contains(@class,'bui-card bp-card--unit')]")
    private WebElement bookForm;

    @FindBy(xpath = ".//input[@name=\"firstname\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = ".//input[@name=\"lastname\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = ".//input[@name=\"email\"]")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@name=\"email_confirm\"]")
    private WebElement confirmEmailInput;

    @FindBy(xpath = ".//button[@name=\"book\"]")
    private WebElement submitFormButton;

    private WebDriver driver;

    public EnterYourInfoToBookTheRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean confirmUserHasSelectedTheRoom() {
        return bookForm.isDisplayed();
    }

    public void fillTheBookForm() {
        firstNameInput.sendKeys("Firstname");
        lastNameInput.sendKeys("Lastname");
        emailInput.sendKeys("testemail@gmail.com");
        confirmEmailInput.sendKeys("testemail@gmail.com");
        submitFormButton.submit();
    }
}
