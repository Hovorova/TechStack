package io.TechStack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    @FindBy(className = "_a48a3fc0e")
    private WebElement SetYourOwnBudgetButton;
    @FindBy(xpath = ".//span[@class='_af5d9ea85'][1]")
    private WebElement SelectedBudgetInfo;
    @FindBy(xpath = "//div[@data-testid='filters-group-slider']//div[@role='none'][1]")
    private WebElement UpperDotOnBudgetLine;
    @FindBy(xpath = "//div[@data-testid='filters-group-slider']//div[@role='none'][2]")
    private WebElement TargetDotOnBudgetLine;
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement cityNameField;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[5]/div[2]/button")
    private WebElement submitChangesButton;
    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div[1]/div[1]/div[4]/div[4]/div[1]/div/div/div/div[5]/div[4]/div[1]/div[2]/div/div[1]/div/div[1]/div/div[1]/div/h3/a/div[1]")
    private WebElement titlleafterChangingParam;
    @FindBy(xpath = "//*[@id=\"search_results_table\"]/div[1]/div/div/div/div[5]/div[5]/div[1]/div[1]/div/div[2]/span/button")
    private WebElement addToFavouriteIcon;

    private WebDriver driver;


    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void ChangeParam(){
        cityNameField.clear();
        cityNameField.sendKeys("Kyiv");
        submitChangesButton.click();
    }
    public boolean verifyChangeParam(){
        String resultStringAfterChangingParam = driver.findElement(By.xpath("//*[@id=\"right\"]/div[1]/div/div/div/h1")).getText();
        return resultStringAfterChangingParam.contains("Kyiv");
    }

    public void  AddToFavorites(){
         addToFavouriteIcon.click();
    }

    public void SetBudget() {
        SetYourOwnBudgetButton.click();
        Actions action = new Actions(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 200);",UpperDotOnBudgetLine );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.dragAndDrop(UpperDotOnBudgetLine, TargetDotOnBudgetLine).build().perform();
    }

    public Boolean ConfirmUserSetBudget(){
        return SelectedBudgetInfo.isDisplayed();
    }
}
