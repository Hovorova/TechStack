package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@id=\"profile-menu-trigger--title\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[6]/div/div/div/ul/form/li/button")
    private WebElement logout;

    //For ChangeLanguageTest
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[2]/button")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[1]/div/div[2]/div/ul/div[1]/ul/li[2]/a")
    private WebElement englishIcon;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")
    private WebElement stringTitle;

    //For SearchPlacesTest
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement whereAreYouGoingInput;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")
    private WebElement CheckInButton;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[5]/td[5]")
    private WebElement dateCheckIn;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[6]/td[1]")
    private WebElement dateCheckOut;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
    private WebElement searchButton;

    //For changing currency
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[1]/button")
    private WebElement changeCurrencyButton;
    @FindBy(className = "bui-inline-container__main")
    private WebElement currencyEuro;

    private WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public String getUserName(){
        return username.getText();
    }
    public void logout(){
        username.click();
        logout.click();
    }

    //For Changing lang
    public void ChangeLanguage(){
        changeLanguageButton.click();
        englishIcon.click();
    }
    public String getCurrentLanguage(){
        return stringTitle.getText();
    }

    //For changing currency
    public void ChangeCurrency(){
        changeCurrencyButton.click();
        currencyEuro.click();
    }
    public String getCurrentCurrency(){
        return changeCurrencyButton.getText();
    }

    //For Search
    public void Search(){
        whereAreYouGoingInput.sendKeys(TestResources.getProperty("whereAreYouGoing"));
        CheckInButton.click();
        dateCheckIn.click();
        dateCheckOut.click();
        searchButton.click();
    }

}
