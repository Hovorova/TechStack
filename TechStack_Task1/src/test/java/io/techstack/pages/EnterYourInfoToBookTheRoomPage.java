package io.techstack.pages;

import io.techstack.components.DriverWrapper;
import io.techstack.components.buttons.Button;
import io.techstack.components.formBox.FormBox;
import io.techstack.components.inputs.Input;
import io.techstack.valueObjects.User;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EnterYourInfoToBookTheRoomPage {

    private WebDriver driver;

    public EnterYourInfoToBookTheRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FinalStepPage fillTheBookForm(User user) {
        DriverWrapper wrapper = new DriverWrapper();
        FormBox parent = wrapper.component(driver, FormBox.class, "bookForm");
        wrapper.<Input>getComponent(driver, Input.class, "firstname", parent).sendKeys(user.getFirstName());
        wrapper.<Input>getComponent(driver, Input.class, "lastname", parent).sendKeys(user.getLastName());
        wrapper.<Input>getComponent(driver, Input.class, "email", parent).sendKeys(user.getEmail());
        wrapper.<Input>getComponent(driver, Input.class, "email_confirm", parent).sendKeys(user.getEmail());
        wrapper.<Button>getComponent(driver, Button.class, "submit").submit();
        return new FinalStepPage(driver);
    }
}
