package io.techstack.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverWrapper extends ChromeDriver {

    public <T extends BaseComponent> WebElement getComponent(Class componentClass, String identifier) {
        return getComponent(componentClass, identifier, null);
    }

    public <T extends BaseComponent> WebElement getComponent(Class componentClass, String identifier, BaseComponent parent) {
        T component;
        try {
            component = (T) componentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        component.setIdentifier(identifier);
        component.build(parent);
        component.instances.put(identifier, findElement(component.construct()));
        return findElement(component.construct());
    }

    public <Component extends BaseComponent> Component component(Class componentClass, String identifier) {
        return component(componentClass, identifier, null);
    }

    public <Component extends BaseComponent> Component component(Class componentClass, String identifier, BaseComponent parent) {
        Component component;
        try {
            component = (Component) componentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        component.setIdentifier(identifier);
        component.instances.put(identifier, findElement(component.construct()));
        return component;
    }
}
