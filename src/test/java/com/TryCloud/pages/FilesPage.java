package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {
    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@class='settings-button'] ")   //button[normalize-space()='Settings']
    public WebElement settingsButton;

    @FindBy(xpath = "//div[@id='files-setting-richworkspace']")
    public WebElement richWorkPlaceButton;

    @FindBy(xpath = "//div[@id='recommendations-setting-enabled']")
    public WebElement recommendationsButton;

    @FindBy(xpath = "//div[@id='files-setting-showhidden']")
    public WebElement showHiddenButton;

    @FindBy(xpath = "//li[@id='quota']/a/p")
    public WebElement storageUsage;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusButton;

    @FindBy(xpath = "//span[@class='svg icon icon-upload']")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//table[@id='filestable']//tbody/tr/td//span[@class='innernametext']")
    public List<WebElement> fileNames;

    @FindBy(xpath = "//*[@id=\"rightClickMenu\"]/ul/li[6]/a/span[1]")
    public WebElement righClickDeleteButton;



}
