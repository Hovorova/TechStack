package io.techstack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelPage {
    @FindBy(xpath = ".//select[contains(@class,'hprt-nos-select js-hprt')]")
    private WebElement selectRoomDropDown;

    @FindBy(xpath = ".//select[contains(@class,'hprt-nos-select')]//option[@value='1']")
    private WebElement selectOption;

    private WebDriver driver;

    public HotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void handleDropDownListAndSubmitReserve() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", selectRoomDropDown);
        Select objSelect = new Select(selectRoomDropDown);
        objSelect.selectByValue("1");
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector("span[class='bui-button__text js-reservation-button__text']"))).build().perform();
    }
}
