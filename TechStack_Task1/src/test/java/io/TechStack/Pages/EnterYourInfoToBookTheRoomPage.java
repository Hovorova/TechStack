package io.TechStack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterYourInfoToBookTheRoomPage {
    @FindBy(xpath = "//*[@id=\"bookForm\"]/div[1]")
    private WebElement bookForm;
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement FirstNameInput;
    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement LastNameInput;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement EmailInput;
    @FindBy(xpath = "//*[@id=\"email_confirm\"]")
    private WebElement ConfirmEmailInput;
    @FindBy(css = "#bookForm > div.bui-group.bui-spacer--large > div > div:nth-child(3) > button > span.bui-button__text.js-button__text")
    private WebElement SubmitFormButton;

    private WebDriver driver;

    public EnterYourInfoToBookTheRoomPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean ConfirmUserHasSelectedTheRoom() {
        return bookForm.isDisplayed();
    }

    public void FillTheBookForm(){
        FirstNameInput.sendKeys("Firstname");
        LastNameInput.sendKeys("Lastname");
        EmailInput.sendKeys("testemail@gmail.com");
        ConfirmEmailInput.sendKeys("testemail@gmail.com");
        SubmitFormButton.submit();
    }
}
