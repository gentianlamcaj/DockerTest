package com.TryCloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int seconds){

        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e){

            System.out.println("Exception happened in sleep method");
        }

    }


    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());

    }


    public static void switchWindowAndVrity(String expectedInUrl, String expectedTitle){
        Set<String> allWindows = Driver.getDriver().getWindowHandles();


        for(String eachWindow : allWindows){

            Driver.getDriver().switchTo().window(eachWindow);

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
            break;
        }
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle(), "Title verification failed");


    }

    public static List<String> dropdownOptionsAsString(WebElement dropdown){

        Select select = new Select(dropdown);

        List<WebElement> actualOptionsAsWebElements = select.getOptions();

        List<String> actualOptions = new ArrayList<>();

        for( WebElement each : actualOptionsAsWebElements){
            actualOptions.add(each.getText());
        }
        return  actualOptions;
    }

    /**
     * Accept List<WebElement> and return List<String> of each text between opening and closing tags for that list of web elements
     * @param webElementList
     * @return List<String>
     */

    public static List<String> listOfWebElementsToListOfString(List<WebElement> webElementList){
        List<String> webElementString= new ArrayList<>();
        for(WebElement each: webElementList){
            webElementString.add(getTextDynamic(each));
        }
        return webElementString;
    }

    /**
     * Accept WebElement and return the text between opening and closing tags even for cases when getText() doesn't work
     * @param webElement
     * @return String
     */
    public static String getTextDynamic(WebElement webElement){
        String webElementText=null;
        webElementText=webElement.getText();
        if(webElementText.equals("")){
            webElementText=webElement.getAttribute("innerText");
            if(webElementText.equals("")){
                webElementText=webElement.getAttribute("textContent");
            }
        }
        return webElementText;
    }



}
