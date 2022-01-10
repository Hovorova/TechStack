package io.TechStack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    //For sort
    @FindBy(xpath = "//*[@id=\"ajaxsrwrap\"]/div[2]/div/div/div[2]/ul/li[3]/a")
    private WebElement fromLowestPrice;

    //For filter set your own budget
    @FindBy(className = "_a48a3fc0e")
    private WebElement SetYourOwnBudgetButton;
    @FindBy(xpath = "//*[@id=\"searchboxInc\"]/div[1]/div/div/div[1]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/span[2]/span")
    private WebElement SelectedBudgetInfo;
    @FindBy(xpath = "//*[@id=\"searchboxInc\"]/div[1]/div/div/div[1]/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]")
    private WebElement UpperDotOnBudgetLine;
    @FindBy(xpath = "//*[@id=\"searchboxInc\"]/div[1]/div/div/div[1]/div[2]/div/div/div/div/div[2]/div[1]/span[22]")
    private WebElement TargetDotOnBudgetLine;


    //For Changing param
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement cityNameField;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[5]/div[2]/button")
    private WebElement submitChangesButton;
    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div[1]/div[1]/div[4]/div[4]/div[1]/div/div/div/div[5]/div[4]/div[1]/div[2]/div/div[1]/div/div[1]/div/div[1]/div/h3/a/div[1]")
    private WebElement titlleafterChangingParam;

    //For add to favourite
    @FindBy(xpath = "//*[@id=\"search_results_table\"]/div[1]/div/div/div/div[5]/div[5]/div[1]/div[1]/div/div[2]/span/button")
    private WebElement addToFavouriteIcon;

    private WebDriver driver;


    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void FilterByPrice(){
        fromLowestPrice.click();
    }

    public Boolean ButtonFromLowestPriceIsDisabled(){
        return fromLowestPrice.isEnabled();
    }

    // For changing param
    public void ChangeParam(){
        cityNameField.clear();
        cityNameField.sendKeys("Kyiv");
        submitChangesButton.click();
    }
    public boolean verifyChangeParam(){
        String resultStringAfterChangingParam = driver.findElement(By.xpath("//*[@id=\"right\"]/div[1]/div/div/div/h1")).getText();
        return resultStringAfterChangingParam.contains("Kyiv");
    }

    // for adding to favorite
    public void  AddToFavorites(){
         addToFavouriteIcon.click();
    }

    // for filter
    public void SetBudget(){
        SetYourOwnBudgetButton.click();
        Actions action = new Actions(driver);
        action.clickAndHold(UpperDotOnBudgetLine).moveToElement(TargetDotOnBudgetLine).release().build().perform();
    }

    public Boolean ConfirmUserSetBudget(){
        return SelectedBudgetInfo.isDisplayed();
    }
}
