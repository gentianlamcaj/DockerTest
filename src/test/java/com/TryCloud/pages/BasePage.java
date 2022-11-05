package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> mainMenuList;

    public void chooseFromMainMenu(String string) {
        for (WebElement each : mainMenuList) {
            if (each.getAttribute("aria-label").equalsIgnoreCase(string)) {
                each.click();
            }
        }


    }}
