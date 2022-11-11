package com.TryCloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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


    public static Integer getTextToInt(WebElement webElement){
        String str=getTextDynamic(webElement);
        char [] ch =str.toCharArray();
        String temp="";
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])){
                temp+=ch[i];
            }
        }
        return Integer.parseInt(temp);

    }

    /**
     * Accept a WebElement element and waits until invisibility of element for 20 seconds
     * @param element
     */
    public static void waitUntilInvisibility(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void moveToElement(WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(element).contextClick().perform();
    }

    /**
     * Accept a String argument and removes the extension from the file, example .pdf, .docx, .img
     * @param file
     * @return String
     */
    public static String removeExtensionFromFile(String file){
        String str=file.substring(0, file.indexOf("c"));
        return str;
    }


    public static boolean invisibilityOf(WebElement element)
    {
        try {
            return !element.isDisplayed();
        }catch(StaleElementReferenceException | NoSuchElementException e )
        {
            System.out.println("Element is stale or not found which means element is invisible.");
            return true;
        }
    }





}
