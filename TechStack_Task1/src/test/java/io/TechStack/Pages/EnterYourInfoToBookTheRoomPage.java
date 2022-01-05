package io.TechStack.Pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//*[@id=\"bookForm\"]/div[4]/div/div[2]/button")
    private WebElement SubmitFormButton;

    private WebDriver driver;

    public EnterYourInfoToBookTheRoomPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // For SelectRoomForBookingTest
    public Boolean ConfirmUserHasSelectedTheRoom() {
        return bookForm.isDisplayed();
    }

    //Filling the bookForm
    public void FillTheBookForm(){
        FirstNameInput.sendKeys("Firstname");
        LastNameInput.sendKeys("Lastname");
        EmailInput.sendKeys("testemail@gmail.com");
        ConfirmEmailInput.sendKeys("testemail@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bookForm\"]/div[4]/div/div[2]/button")).submit();
    }
}
