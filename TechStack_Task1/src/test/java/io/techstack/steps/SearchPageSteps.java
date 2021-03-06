package io.techstack.steps;

import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchPageSteps {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    public SearchPageSteps(WebDriver driver) {
        this.driver = driver;
        searchResultPage = new SearchResultPage(driver);
    }

    public static void whenUserAddsHotelToFavorites() {
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.getAddToFavouriteIcon().click();
    }

    public static void thenSuccessfulBannerIsDisplayed() {
        WaitUtils.fluentWaitElementToBeVisible(driver, searchResultPage.getSuccesfullyAddedToFavoritesBanner());
        assertTrue(searchResultPage.getSuccesfullyAddedToFavoritesBanner().isDisplayed());
    }

    public static void whenUserClickOnSortFromLowestPrice() {
        WaitUtils.waitForElementToBeClickable(driver, searchResultPage.getSortFromLowestPrice());
        searchResultPage.getSortFromLowestPrice().click();
    }

    public static void thenButtonSortFromLowestPriceIsEnable() {
        assertTrue(searchResultPage.getSortFromLowestPrice().isEnabled());
    }

    public static void whenUserUseFilterSetYourOwnBudget() {
        WaitUtils.waitForElementToBeVisible(driver, searchResultPage.getSetYourOwnBudgetButton());
        searchResultPage.setBudget();
    }

    public static void thenBoundariesOfBudgetIsDispayed() {
        assertTrue(searchResultPage.getSelectedBudgetInfo().isDisplayed());
    }
}
