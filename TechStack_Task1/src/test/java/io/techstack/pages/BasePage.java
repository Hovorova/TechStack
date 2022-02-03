package io.techstack.pages;

import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.components.DriverWrapper;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BasePage {
    @FindBy(xpath = "//div[contains(@class, 'bui-button-group')]//span[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = ".//span[contains(text(),'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = ".//span[contains(text(),'List your property')]")
    private WebElement ListYourProperty;

    @FindBy(xpath = ".//button[@data-modal-id='language-selection']")
    private WebElement changeLanguageButton;

    @FindBy(xpath = ".//a[@data-lang='en-gb']")
    private WebElement englishIcon;

    @FindBy(xpath = ".//a[@data-lang='ru']")
    private WebElement russianIcon;

    @FindBy(xpath = ".//a[@data-lang='uk']")
    private WebElement ukrainianIcon;

    @FindBy(xpath = ".//a[@data-lang='pl']")
    private WebElement polskiIcon;

    @FindBy(xpath = ".//button[@data-modal-header-async-type='currencyDesktop']")
    private WebElement changeCurrencyButton;

    @FindBy(xpath = ".//img[contains(@class, 'image' )and contains(@src,'en')]")
    private WebElement enIcon;

    @FindBy(xpath = ".//img[contains(@class, 'image' )and contains(@src,'pl')]")
    private WebElement plIcon;

    @FindBy(xpath = ".//img[contains(@class, 'image' )and contains(@src,'ru')]")
    private WebElement ruIcon;

    @FindBy(xpath = ".//img[contains(@class, 'image' )and contains(@src,'ua')]")
    private WebElement uaIcon;

    @FindBy(partialLinkText = "EUR")
    private WebElement currencyEuro;

    @FindBy(partialLinkText = "USD")
    private WebElement currencyDollar;

    @FindBy(partialLinkText = "UAH")
    private WebElement currencyHryvnia;

    @FindBy(partialLinkText = "RUB")
    private WebElement currencyRuble;

    @FindBy(xpath = ".//span[@class='bui-avatar-block__title']")
    private WebElement userName;

    @FindBy(xpath = ".//div[contains(@class,'bui-group bui-button-group')]")
    private WebElement mainMenu;


    private DriverWrapper driver;

    public BasePage(DriverWrapper driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignInPage signIn() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public boolean IsUserSignedIn(String username) {
        return userName.getText().contains(username);
    }

    public boolean confirmTheLanguageHasChanged(String languge) {
        switch (languge){
            case "English":
                return enIcon.isDisplayed();
            case "Russian":
                return ruIcon.isDisplayed();
            case "Ukrainian":
                return uaIcon.isDisplayed();
            case "Polski":
                return plIcon.isDisplayed();
        }
        return false;
    }

    public void changeLanguage(String language) {
        changeLanguageButton.click();
        switch (language) {
            case "English":
                WaitUtils.waitForElementToBeVisible(driver, englishIcon);
                englishIcon.click();
                break;
            case "Russian":
                WaitUtils.waitForElementToBeVisible(driver, russianIcon);
                russianIcon.click();
                break;
            case "Ukrainian":
                WaitUtils.waitForElementToBeVisible(driver, ukrainianIcon);
                ukrainianIcon.click();
                break;
            case "Polski":
                WaitUtils.waitForElementToBeVisible(driver, polskiIcon);
                polskiIcon.click();
                break;
        }
    }

    public void changeCurrency(String currency) {
        Actions action = new Actions(driver);
        changeCurrencyButton.click();
        switch (currency) {
            case "Euro":
                WaitUtils.waitForElementToBeVisible(driver, currencyEuro);
                action.click(currencyEuro).build().perform();
                break;
            case "Dollar":
                WaitUtils.waitForElementToBeVisible(driver, currencyDollar);
                action.click(currencyDollar).build().perform();
                break;
            case "Hryvnia":
                WaitUtils.waitForElementToBeVisible(driver, currencyHryvnia);
                action.click(currencyHryvnia).build().perform();
                break;
            case "Ruble":
                WaitUtils.waitForElementToBeVisible(driver, currencyRuble);
                action.click(currencyRuble).build().perform();
                break;
        }
    }

    public boolean isDistanceBetweenButtonsEqual(WebElement firstButton, WebElement secondButton, WebElement thirdButton) {
        int dimensionForSecondSpace = thirdButton.getLocation().getX() - secondButton.getLocation().getX() - secondButton.getSize().getWidth();
        int dimensionForFirstSpace = secondButton.getLocation().getX() - firstButton.getLocation().getX() - firstButton.getSize().getWidth();
        return dimensionForFirstSpace == dimensionForSecondSpace;
    }
}
