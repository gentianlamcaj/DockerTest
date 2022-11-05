package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li/a")
    public List<WebElement> mainModules;


    public void clickAModuleFromMainModules(String string) {
        for (int i = 0; i < mainModules.size() - 1; i++) {
            if (mainModules.get(i).getAttribute("aria-label").equals(string)) {
                mainModules.get(i).click();
            }
        }
    }

}
