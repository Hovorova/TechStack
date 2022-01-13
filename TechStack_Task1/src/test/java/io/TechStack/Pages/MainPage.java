package io.TechStack.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@id=\"profile-menu-trigger--title\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[2]/button")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[1]/div/div[2]/div/ul/div[1]/ul/li[2]/a")
    private WebElement englishIcon;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[7]/ul/li[1]/a")
    private WebElement russianIcon;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[8]/ul/li[4]/a")
    private WebElement ukrainianIcon;
    @FindBy(xpath = "//*[@id=\"language-selection\"]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[6]/ul/li[3]/a")
    private WebElement polskiIcon;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")
    private WebElement stringTitle;
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement CityInput;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")
    private WebElement CheckInButton;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[5]/span/span")
    private WebElement dateCheckIn;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[5]/td[7]/span/span")
    private WebElement dateCheckOut;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
    private WebElement searchButton;
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

    // For getSizeAndLocationOfSignInButton
    @FindBy(css = "#b2indexPage > header > nav.bui-header__bar > div.bui-group.bui-button-group.bui-group--inline.bui-group--align-end.bui-group--vertical-align-middle > div:nth-child(6) > a")
    private WebElement signInButton;
    @FindBy(xpath = ".//a[@class='bui-button bui-button--light bui-traveller-header__product-action']")
    private WebElement ListYourPropertyButton;
    @FindBy(css = "#b2indexPage > header > nav.bui-header__bar > div.bui-group.bui-button-group.bui-group--inline.bui-group--align-end.bui-group--vertical-align-middle > div:nth-child(5) > a")
    private WebElement RegisterButton;


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getUserName() {
        return username.getText();
    }

    public void ChangeLanguage(String language) {
        changeLanguageButton.click();
        switch (language) {
            case "English":
                englishIcon.click();
                break;
            case "Russian":
                russianIcon.click();
                break;
            case "Ukrainian":
                ukrainianIcon.click();
                break;
            case "Polski":
                polskiIcon.click();
                break;
        }
    }

    public void ChangeCurrency(String currency) {
        Actions action = new Actions(driver);
        changeCurrencyButton.click();
        switch (currency) {
            case "Euro":
                action.click(currencyEuro).build().perform();
                break;
            case "Dollar":
                action.click(currencyDollar).build().perform();
                // currencyDollar.click();
                break;
            case "Hryvnia":
                action.click(currencyHryvnia).build().perform();
                break;
            case "Ruble":
                action.click(currencyRuble).build().perform();
                break;
        }
    }

    public void Search() {
        CityInput.clear();
        CityInput.sendKeys("Kharkiv");
        CheckInButton.click();
        dateCheckIn.click();
        dateCheckOut.click();
        searchButton.click();
    }

    public Dimension getSizeOfSignInButton() {
        return signInButton.getSize();
    }

    public Point getLocationOfSignInButton() {
        return signInButton.getLocation();
    }

    public boolean DistanceBetweenButtons(){
        int dimensionForSecondSpace = signInButton.getLocation().getX() - RegisterButton.getLocation().getX() - RegisterButton.getSize().getWidth();
        int dimensionForFirstSpace = RegisterButton.getLocation().getX() - ListYourPropertyButton.getLocation().getX() - ListYourPropertyButton.getSize().getWidth();
        return dimensionForFirstSpace == dimensionForSecondSpace;
    }

    public Boolean elementInputCityTagnameAndAttribute() {
        boolean tagIsInput = "input".equals(CityInput.getTagName());
        boolean attributeWhereAreYouGoingCity = "search".equals(CityInput.getAttribute("type"));
        return tagIsInput & attributeWhereAreYouGoingCity;
    }

    public String GetElementTagName(WebElement element) {
        return element.getTagName();
    }
}
