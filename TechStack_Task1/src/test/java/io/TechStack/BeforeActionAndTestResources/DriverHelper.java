package io.TechStack.BeforeActionAndTestResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DriverHelper {
        public static WebDriver getDriver() {
            WebDriver driver;
            System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        }
    }
