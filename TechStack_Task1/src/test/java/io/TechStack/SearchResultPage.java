package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    @FindBy(xpath = "//*[@id=\"bodyconstraint-inner\"]/div[1]/div/div/div/nav/ol/li[5]/span/a/span")
    private WebElement verificateStatusOfPage;

    //For sort
    @FindBy(xpath = "//*[@id=\"ajaxsrwrap\"]/div[2]/div/div/div[2]/ul/li[3]/a")
    private WebElement fromLowestPrice;

    //For Changing param
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement cityNameField;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[5]/div[2]/button")
    private WebElement submitChangesButton;
    @FindBy(xpath = "//*[@id=\"right\"]/div[1]/div/div/div/h1")
    private WebElement titlleafterChangingParam;

    //For add to favourite
    @FindBy(xpath = "//*[@id=\"search_results_table\"]/div[1]/div/div/div/div[5]/div[1]/div[1]/div[1]/div/div[2]/span/div/span/button/span/svg/path")
    private WebElement addToFavouriteIcon;
    @FindBy(xpath = "//*[@id=\"__bui-136\"]/div/div/div/div/div[1]/a/span")
    private WebElement titleAddedToFavorites;
    @FindBy(xpath = "//*[@id=\"b2mywishlistPage\"]/div[2]/div[2]/div/div/div[1]/div/h1")
    private WebElement myFavorites;

    private WebDriver driver;


    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public String getCurrentStatusOfPage(){
        return verificateStatusOfPage.getText();
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
        cityNameField.sendKeys("Киев");
        submitChangesButton.click();
    }
    public String getTitleAfterChangingParam(){
        return titlleafterChangingParam.getText();
    }

    // for adding to favorite
    public void  AddToFavorites(){
        addToFavouriteIcon.click();
        titleAddedToFavorites.click();
    }
    public String IsAddedToFavorites(){
        return myFavorites.getText();
    }

}
