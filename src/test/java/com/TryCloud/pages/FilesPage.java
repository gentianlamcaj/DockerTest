package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.bouncycastle.crypto.params.X448PrivateKeyParameters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.List;

public class FilesPage extends BasePage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//span[@class='icon icon-add']")
    public WebElement newButton;

    //@FindBy(xpath ="//span[.='Upload file']")
    @FindBy(xpath ="//input[@type='file']")
    public WebElement uploadFile;

    @FindBy(xpath ="//li[@id='quota']//p")
    public WebElement quota;

    @FindBy(xpath ="//button[normalize-space()='Settings']")
    public WebElement settingsButton;

    @FindBy(xpath ="//div[@id='app-settings-content']//input[@class='checkbox']")
    public List <WebElement> settingsCheckboxButtons;

    @FindBy(id="uploadprogressbar" )
    public WebElement uploadprogressbar;

    @FindBy(xpath = "//div[@id='app-content-files']//span[@class='nametext']")
    public List<WebElement> listOfNameOnFileTable;

    @FindBy(xpath = "//span[@class='icon icon icon-delete']")
    public WebElement deleteFile;


    @FindBy(xpath="//a[.='Favorites']")
    public WebElement favoritesLink;

    @FindBy(xpath="//span[.='Add to favorites']")
    public WebElement addToFavoritesLink;

    @FindBy(xpath="//span[.='Remove from favorites']")
    public WebElement removeFromFavoritesLink;

    @FindBy(xpath="//div[@class='fileActionsMenu popovermenu bubble open menu']")
    public List<WebElement> listOfActionsMenu;



    @FindBy(xpath="//span[.='Details']")
    public WebElement detailsLink;

    @FindBy(xpath="//div[@id='app-content-files']//table[@id='filestable']//a[@data-action='menu']")
    public List<WebElement> listOfIconMore;



    @FindBy(xpath="//h2[@class='app-sidebar-header__maintitle']")
    public WebElement appSidebarHeaderMainTitle;

    @FindBy(xpath="//div[@id='app-content-favorites']//span[@class='innernametext']")
    public List<WebElement> listOfFavoriteFiles;




















}
