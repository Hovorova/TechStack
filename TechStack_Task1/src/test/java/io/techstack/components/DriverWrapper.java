package io.techstack.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverWrapper {
    public <T extends BaseComponent> WebElement getComponent(WebDriver driver, Class componentClass, String identifier) {
        return getComponent(driver, componentClass, identifier, null);
    }

    public <T extends BaseComponent> WebElement getComponent(WebDriver driver, Class componentClass, String identifier, BaseComponent parent) {
        T component;
        try {
            component = (T) componentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        component.setIdentifier(identifier);
        component.build(parent);
        component.instances.put(identifier, driver.findElement(component.construct()));
        return driver.findElement(component.construct());
    }

    public <Component extends BaseComponent> Component component(WebDriver driver, Class componentClass, String identifier){
        return component(driver, componentClass, identifier, null);
    }

    public <Component extends BaseComponent> Component component(WebDriver driver, Class componentClass, String identifier, BaseComponent parent){
        Component component;
        try {
            component = (Component) componentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        component.setIdentifier(identifier);
        component.instances.put(identifier, driver.findElement(component.construct()));
        return component;
    }
}
