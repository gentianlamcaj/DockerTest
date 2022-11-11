package com.TryCloud.step_definition;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FilesModuleFavorites_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    String fileName = "";

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() throws InterruptedException {
        for (int i=0;i<filesPage.listOfIconMore.size();) {
            filesPage.listOfIconMore.get(i).click();

            if(BrowserUtils.invisibilityOf(filesPage.addToFavoritesLink)){
                continue;
            }else {
                filesPage.addToFavoritesLink.click();
                Thread.sleep(5000);
                filesPage.listOfIconMore.get(i).click();
                filesPage.detailsLink.click();
                fileName = BrowserUtils.removeExtensionFromFile(BrowserUtils.getTextDynamic(filesPage.appSidebarHeaderMainTitle));
            }
            }
        }



    @When("user choose the Add to favorites option")
    public void user_choose_the_option() {

    }

    @When("user click the Favorites sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side() {
        filesPage.favoritesLink.click();
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        List<String> listOfFavorites=BrowserUtils.listOfWebElementsToListOfString(filesPage.listOfFavoriteFiles);
        Assert.assertTrue(listOfFavorites.contains(fileName));

    }

}
