package io.TechStack.Tests.SearchPageTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortAndFilterTests {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void SortByLowerPriceTest() {
        WebElement fromLowestPrice = driver.findElement(By.xpath("//*[@id=\"ajaxsrwrap\"]/div[2]/div/div/div[2]/ul/li[3]/a"));
        fromLowestPrice.click();
        Assert.assertTrue(fromLowestPrice.isEnabled());
    }

    @Test
    public void FilterSetYourBudgetTest() {
        searchResultPage.SetBudget();
        Assert.assertTrue(searchResultPage.ConfirmUserSetBudget());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
        }
}
