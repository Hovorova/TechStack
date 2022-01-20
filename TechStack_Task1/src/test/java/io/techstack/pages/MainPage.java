package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage {

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

    @FindBy(xpath = ".//button[@data-sb-id='main']")
    private WebElement searchButton;

    @FindBy(xpath = ".//input[@type='search']")
    private WebElement cityInput;

    @FindBy(xpath = ".//span[contains(@class,'icon sb-date')]")
    private WebElement checkInButton;

    @FindBy(xpath = ".//button[@data-modal-header-async-type='currencyDesktop']")
    private WebElement changeCurrencyButton;

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

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignInPage signIn() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public boolean IsUserSignedIn() {
        return userName.getText().contains("Your account");
    }

    public void changeLanguage(String language) {
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

    public void changeCurrency(String currency) {
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

    public SearchResultPage confirmSearch() {
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public void searchInput(String cityName) {
        cityInput.clear();
        cityInput.sendKeys(cityName);
        checkInButton.click();
    }

    public boolean isDistanceBetweenButtonsEqual(WebElement firstButton, WebElement secondButton, WebElement thirdButton) {
        int dimensionForSecondSpace = thirdButton.getLocation().getX() - secondButton.getLocation().getX() - secondButton.getSize().getWidth();
        int dimensionForFirstSpace = secondButton.getLocation().getX() - firstButton.getLocation().getX() - firstButton.getSize().getWidth();
        return dimensionForFirstSpace == dimensionForSecondSpace;
    }

    public boolean elementInputCityTagnameAndAttribute() {
        boolean tagIsInput = "input".equals(cityInput.getTagName());
        boolean attributeWhereAreYouGoingCity = "search".equals(cityInput.getAttribute("type"));
        return tagIsInput & attributeWhereAreYouGoingCity;
    }

    public String createXpathForCheckInAndCheckOutDate(String dateCheckInDate) {
        String finalStringCheckInDate = ".//td[@data-date='" + dateCheckInDate + "']";
        return finalStringCheckInDate;
    }
}
