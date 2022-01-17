package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
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

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitFormButton;

    @FindBy(xpath = "//div[@class='bp-personal-details-form']")
    private WebElement enterYourDetailsForm;

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
