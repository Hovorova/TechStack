package io.techstack.pages;

import io.techstack.valueObjects.User;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EnterYourInfoToBookTheRoomPage {

    @FindBy(xpath = ".//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = ".//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = ".//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@name='email_confirm']")
    private WebElement confirmEmailInput;

    @FindBy(xpath = ".//button[@name='book']")
    private WebElement submitFormButton;

    private WebDriver driver;

    public EnterYourInfoToBookTheRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FinalStepPage fillTheBookForm(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        confirmEmailInput.sendKeys(user.getEmail());
        submitFormButton.submit();
        return new FinalStepPage(driver);
    }
}
