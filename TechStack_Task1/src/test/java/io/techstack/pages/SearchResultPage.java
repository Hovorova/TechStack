package io.techstack.pages;

import io.techstack.beforeActionAndTestResources.WaitUtils;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SearchResultPage {
    @FindBy(xpath = ".//label[@data-on-value='Set your own budget']")
    private WebElement setYourOwnBudgetButton;

    @FindBy(xpath = ".//div[@data-testid='filters-group-slider']")
    private WebElement selectedBudgetInfo;

    @FindBy(xpath = "//div[@data-testid='filters-group-slider']//div[@role='none'][1]")
    private WebElement upperDotOnBudgetLine;

    @FindBy(xpath = "//div[@data-testid='filters-group-slider']//div[@role='none'][2]")
    private WebElement targetDotOnBudgetLine;

    @FindBy(xpath = ".//button[@data-testid='wishlist-button']")
    private WebElement addToFavouriteIcon;

    @FindBy(xpath = ".//div[@data-testid='wishlist-popover-content']")
    private WebElement succesfullyAddedToFavoritesBanner;

    @FindBy(xpath = ".//div[@data-component='arp-header']")
    private WebElement titleWithCityName;

    @FindBy(xpath = ".//li[@data-id='price']")
    private WebElement sortFromLowestPrice;

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
