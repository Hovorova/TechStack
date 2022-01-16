package io.techstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterYourInfoToBookTheRoomPage {
    @FindBy(xpath = "//*[@id=\"bookForm\"]/div[1]")
    private WebElement bookForm;
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement firstNameInput;
    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement lastNameInput;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"email_confirm\"]")
    private WebElement confirmEmailInput;
    @FindBy(css = "#bookForm > div.bui-group.bui-spacer--large > div > div:nth-child(3) > button > span.bui-button__text.js-button__text")
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
