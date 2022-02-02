package io.techstack.pages;

import io.techstack.components.DriverWrapper;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    private DriverWrapper driver;

    public MainPage(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SearchResultPage search(String cityName, String dateCheckIn, String dateCheckOut) {
        cityInput.clear();
        cityInput.sendKeys(cityName);
        checkInButton.click();
        driver.findElement(By.xpath(".//td[@data-date='" + dateCheckIn + "']")).click();
        driver.findElement(By.xpath(".//td[@data-date='" + dateCheckOut + "']")).click();
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public boolean elementInputCityTagnameAndAttribute() {
        boolean tagIsInput = "input".equals(cityInput.getTagName());
        boolean attributeWhereAreYouGoingCity = "search".equals(cityInput.getAttribute("type"));
        return tagIsInput & attributeWhereAreYouGoingCity;
    }
}
