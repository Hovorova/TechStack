package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter
public class HotelPage {
    @FindBy(xpath = "//*[@id=\"hprt_nos_select_803467301_341664530_3_0_0\"]")
    private WebElement selectRoomDropDown;

    @FindBy(xpath = "//*[@id=\"hprt_nos_select_803467301_341664530_3_0_0\"]/option[2]")
    private WebElement selectOption;

    @FindBy(xpath = ".//div[@class='k2-hp--gallery-header bui-grid__column bui-grid__column-9']")
    private WebElement hotelGallery;

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
