package io.techstack.pages;

import io.techstack.beforeActionAndTestResources.WaitUtils;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SearchResultPage {
    @FindBy(xpath = ".//span[@class='_a48a3fc0e']")
    private WebElement setYourOwnBudgetButton;

    @FindBy(xpath = ".//span[@class='_af5d9ea85'][1]")
    private WebElement selectedBudgetInfo;

    @FindBy(xpath = "//div[@data-testid='filters-group-slider']//div[@role='none'][1]")
    private WebElement upperDotOnBudgetLine;

    @FindBy(xpath = "//div[@data-testid='filters-group-slider']//div[@role='none'][2]")
    private WebElement targetDotOnBudgetLine;

    @FindBy(xpath = ".//input[@type='search']")
    private WebElement cityNameField;

    @FindBy(xpath = ".//button[@data-sb-id='main']")
    private WebElement submitChangesButton;

    @FindBy(xpath = ".//button[@data-testid='wishlist-button']")
    private WebElement addToFavouriteIcon;

    @FindBy(xpath = ".//h1[@class='_30227359d _0db903e42']")
    private WebElement titleWithCityName;

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void changeParam(String cityName) {
        cityNameField.clear();
        cityNameField.sendKeys(cityName);
        submitChangesButton.click();
    }

    public void setBudget() {
        setYourOwnBudgetButton.click();
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);", upperDotOnBudgetLine);
        WaitUtils.fluentWaitElementToBeVisible(driver, upperDotOnBudgetLine);
        action.dragAndDrop(upperDotOnBudgetLine, targetDotOnBudgetLine).build().perform();
    }
}
