package io.TechStack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelPage {
    @FindBy(xpath = "//*[@id=\"hprt_nos_select_803467301_341664530_3_0_0\"]")
    private WebElement SelectRoomDropDown;
    @FindBy(xpath = "//*[@id=\"hprt_nos_select_803467301_341664530_3_0_0\"]/option[2]")
    private WebElement SelectOption;

    private WebDriver driver;

    public HotelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void handleDropDownListAndSubmitReserve(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", SelectRoomDropDown);
        Select objSelect = new Select(SelectRoomDropDown);
        objSelect.selectByValue("1");
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector("span[class='bui-button__text js-reservation-button__text']"))).build().perform();
    }
}
