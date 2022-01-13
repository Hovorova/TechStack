package io.TechStack.XPaths;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class XPathsForSearchResultPage {
    @FindBy(xpath = ".//div[starts-with(text(), 'Very good')]")
    private List<WebElement> hotelsWithVeryGoodRate;

    @FindBy(xpath = ".//div[@class='bui-group__item']//parent::*")
    private WebElement mainMenu;

    @FindBy(xpath = ".//div[@data-testid='review-score']//div[@aria-label and text()>'9']")
    private List<WebElement> hotelsWithRateOver9;

    @FindBy(xpath = ".//div[@data-testid='property-card'] //*[text()='FREE cancellation' or text()='No prepayment needed']")
    private List<WebElement> hotelsWithFreeCancellationOrNoPrepayment;
}
