package io.techstack.XPaths;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import java.util.ArrayList;
import java.util.List;

public class XPaths {
    @FindBy(xpath = ".//div[starts-with(text(), 'Very good')]")
    private List<WebElement> hotelsWithVeryGoodRateLable;

    @FindBy(xpath = ".//div[@class='bui-group__item']//parent::*")
    private WebElement mainMenu;

    @FindBy(xpath = ".//div[@data-testid='review-score']//div[@aria-label and text()>='9']")
    private List<WebElement> hotelsWithRateOver9Label;

    @FindBy(xpath = ".//div[@data-testid='property-card'] //*[text()='FREE cancellation' or text()='No prepayment needed']")
    private List<WebElement> hotelsWithFreeCancellationOrNoPrepaymentLabel;

    @FindBy(xpath = ".//div[contains(text(),'Almost done!')]")
    private WebElement successfulBanner;

    @FindBy(xpath = ".//div[contains(@class,'bui-group bui')]//preceding-sibling::a[contains(@class,'bui-button bui-button--sec')]")
    private WebElement registerButton;

    @FindBy(xpath = ".//div[@class='bui-group__item'][last()]")
    private WebElement signInButton;

    @FindBy(xpath = ".//div[contains(@class,'bui-group bui-button')]//descendant::button")
    private WebElement languageButton;

    @FindBy(xpath = ".//div[@class='bui-header__main']/following-sibling::*")
    private WebElement mainMenuWithoutLogo;

    @FindBy(xpath = ".//li[@class='bui-tab__item']//ancestor::nav[contains(@class,'bui-tab bui-head')]")
    private WebElement underMenuPartnersLinks;

    @FindBy(xpath = "//a[@role='button']/preceding::div[@data-testid='property-card']")
    private WebElement hotelsInKharkivCards;

    @FindBy(xpath = "//div[count(input)] ")
    private WebElement inputsOnPage;

    @FindBy(xpath = ".//input[not(@type='password'=false())]")
    private WebElement enterPasswordInput;

    @FindBy(xpath = "//input | //button")
    private WebElement findsAllInputsOrButtons;

    @FindBy(xpath = "//div[@aria-label and text() mod 3]")
    private WebElement usingMod;
}
