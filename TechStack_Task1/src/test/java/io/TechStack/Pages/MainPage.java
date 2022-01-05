package io.TechStack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

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
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[7]/ul/li[1]/a")
    private WebElement russianIcon;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[8]/ul/li[4]/a")
    private  WebElement ukrainianIcon;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[6]/ul/li[3]/a")
    private WebElement polskiIcon;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")
    private WebElement stringTitle;

    //For Search Places
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement whereAreYouGoingInput;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")
    private WebElement CheckInButton;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[5]/span/span")
    private WebElement dateCheckIn;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[7]/span/span")
    private WebElement dateCheckOut;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
    private WebElement searchButton;

    //For changing currency
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[1]/button")
    private WebElement changeCurrencyButton;
    @FindBy(partialLinkText = "EUR")
    private WebElement currencyEuro;
    @FindBy(partialLinkText = "USD")
    private WebElement currencyDollar;
    @FindBy(partialLinkText = "UAH")
    private WebElement currencyHryvnia;
    @FindBy(partialLinkText = "RUB")
    private WebElement currencyRuble;


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

    //For Changing lang to eng
    public void ChangeLanguageToEng(){
        changeLanguageButton.click();
        englishIcon.click();
    }

    //For changing language
    public void ChangeLanguage(){
        String language = "Polski";
        switch (language){
            case "English":
                changeLanguageButton.click();
                englishIcon.click();
                break;
            case "Russian":
                changeLanguageButton.click();
                russianIcon.click();
                break;
            case "Ukrainian":
                changeLanguageButton.click();
                ukrainianIcon.click();
                break;
            case "Polski":
                changeLanguageButton.click();
                polskiIcon.click();
                break;
        }
    }

    //For changing currency to euro
    public void ChangeCurrencyToEuro(){
        changeCurrencyButton.click();
        currencyEuro.click();
    }

    // For changing currency
    public void ChangeCurrency() {
        String currency = "Dollar";
        Actions action = new Actions(driver);
        switch (currency) {
            case "Euro":
                changeCurrencyButton.click();
                currencyEuro.click();
                break;
            case "Dollar":
                changeCurrencyButton.click();
                action.click(currencyDollar).build().perform();
                // currencyDollar.click();
                break;
            case "Hryvnia":
                changeCurrencyButton.click();
                currencyHryvnia.click();
                break;
            case "Ruble":
                changeCurrencyButton.click();
                currencyRuble.click();
                break;
        }
    }

    //For Search
    public void Search(){
        whereAreYouGoingInput.clear();
        whereAreYouGoingInput.sendKeys("Kharkiv");
        CheckInButton.click();
        dateCheckIn.click();
        dateCheckOut.click();
        searchButton.click();
    }

}
