package io.techstack.pages;

import io.techstack.components.DriverWrapper;
import io.techstack.components.buttons.Button;
import io.techstack.components.formBox.FormBox;
import io.techstack.components.inputs.Input;
import io.techstack.valueObjects.User;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class EnterYourInfoToBookTheRoomPage {

    private DriverWrapper driver;

    public EnterYourInfoToBookTheRoomPage(DriverWrapper driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FinalStepPage fillTheBookForm(User user) {
        FormBox parent = driver.component(FormBox.class, "bp-personal-details-form");
        driver.getComponent(Input.class, "firstname", parent).sendKeys(user.getFirstName());
        driver.getComponent(Input.class, "lastname", parent).sendKeys(user.getLastName());
        driver.getComponent(Input.class, "email", parent).sendKeys(user.getEmail());
        driver.getComponent(Input.class, "email_confirm", parent).sendKeys(user.getEmail());
        driver.getComponent(Button.class, "submit").submit();
        return new FinalStepPage(driver);
    }
}
