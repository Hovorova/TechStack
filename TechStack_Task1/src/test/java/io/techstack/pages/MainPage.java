package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = ".//button[@data-sb-id='main']")
    private WebElement searchButton;

    @FindBy(xpath = ".//input[@type='search']")
    private WebElement cityInput;

    @FindBy(xpath = ".//span[contains(@class,'icon sb-date')]")
    private WebElement checkInButton;

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
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

    public boolean elementInputCityTagnameAndAttribute() {
        boolean tagIsInput = "input".equals(cityInput.getTagName());
        boolean attributeWhereAreYouGoingCity = "search".equals(cityInput.getAttribute("type"));
        return tagIsInput & attributeWhereAreYouGoingCity;
    }

    public String createXpathForCheckInAndCheckOutDate(String checkInDate) {
        String finalStringCheckInDate = ".//td[@data-date='" + checkInDate + "']";
        return finalStringCheckInDate;
    }
}
