package io.techstack.pages;

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
    @FindBy(xpath = ".//select[contains(@name,'nr_rooms')]")
    private WebElement selectRoomDropDown;

    @FindBy(xpath = ".//div[contains(@class,'reservation-c')]")
    private WebElement illReserveButton;

    @FindBy(xpath = ".//div[contains(@class, 'gallery-header')]")
    private WebElement hotelGallery;

    private WebDriver driver;

    public HotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public EnterYourInfoToBookTheRoomPage handleDropDownListAndSubmitReserve() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", selectRoomDropDown);
        Select objSelect = new Select(selectRoomDropDown);
        objSelect.selectByValue("1");
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector("span[class='bui-button__text js-reservation-button__text']"))).build().perform();
        return new EnterYourInfoToBookTheRoomPage(driver);
    }
}
