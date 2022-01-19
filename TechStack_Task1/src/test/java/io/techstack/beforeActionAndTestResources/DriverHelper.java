package io.techstack.beforeActionAndTestResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        return driver;
    }
}
