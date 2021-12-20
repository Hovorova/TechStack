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

    //For filter
    @FindBy(name = "SustainablePropertyFilter")
    private WebElement filterValue;


    //For Changing param
    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement cityNameField;
    @FindBy(xpath = "//*[@id=\"frm\"]/div[5]/div[2]/button")
    private WebElement submitChangesButton;
    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div[1]/div[1]/div[4]/div[4]/div[1]/div/div/div/div[5]/div[4]/div[1]/div[2]/div/div[1]/div/div[1]/div/div[1]/div/h3/a/div[1]")
    private WebElement titlleafterChangingParam;

    //For add to favourite
    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div[1]/div[1]/div[4]/div[4]/div[1]/div/div/div/div[5]/div[2]/div[1]/div[1]/div/div[2]/span/button")
    private WebElement addToFavouriteIcon;
    @FindBy(xpath = "/html/body/div[15]/div")
    private WebElement messegeIsAdded;

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
    }
    public Boolean DoesMessageIsAddedAppear(){
        if(messegeIsAdded.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    //for filter
    public void setFilterValue(){
        filterValue.click();
    }
    public Boolean DoesCheckboxValueIsActive(){
        if(filterValue.isSelected()){
            return true;
        } else{
            return false;
        }
    }
}
