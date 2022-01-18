package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
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

    @FindBy(xpath = ".//div[@class='bui-modal__inner']")
    private WebElement popUpSomePeopleLookedForThisPlace;

    @FindBy(xpath = ".//button[@class='bui-modal__close']")
    private WebElement closePopUpButton;

    @FindBy(xpath = ".//div[@class='required_fields_description bui-spacer--large']")
    private WebElement succesfulBanner;

    private WebDriver driver;

    public EnterYourInfoToBookTheRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillTheBookForm() {
        firstNameInput.sendKeys("Firstname");
        lastNameInput.sendKeys("Lastname");
        emailInput.sendKeys("testemail@gmail.com");
        confirmEmailInput.sendKeys("testemail@gmail.com");
        submitFormButton.submit();
    }

    public void handlePopUpWindowOtherPeopleIsLookingForThisPlace() {
        if (popUpSomePeopleLookedForThisPlace.isDisplayed()) {
            closePopUpButton.click();
        }
    }
}
