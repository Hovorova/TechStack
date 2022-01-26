package io.techstack.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseComponent {
    public Map<String, WebElement> instances = new HashMap<>();
    public String identifier;
    public BaseComponent parent;

    public abstract By construct();

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void build(BaseComponent parent){
        if (parent != null){
            this.parent = parent;
        }
    }
}