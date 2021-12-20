package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeSearchParamPage {
    @FindBy(xpath = "//*[@id=\"right\"]/div[1]/div/div/div/h1")
    private WebElement TitleAfterChangingParam;

    private WebDriver driver;

    public ChangeSearchParamPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitleAfterChangingParam(){
        return TitleAfterChangingParam.getText();
    }
}
