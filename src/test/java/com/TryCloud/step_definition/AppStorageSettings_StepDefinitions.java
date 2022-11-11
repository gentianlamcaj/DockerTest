package com.TryCloud.step_definition;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppStorageSettings_StepDefinitions {
    FilesPage filesPage=new FilesPage();
    int currentStorageUsageBeforeUpload;



    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        currentStorageUsageBeforeUpload= BrowserUtils.getTextToInt(filesPage.quota);

    }

    @When("user uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option(){
        filesPage.newButton.click();
        filesPage.uploadFile.sendKeys("C:\\Users\\Genti\\IdeaProjects\\TryCloudProjectMine\\src\\test\\file_folder\\uPLOADtEST.docx");
        BrowserUtils.waitUntilInvisibility(filesPage.uploadprogressbar);

    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();

    }

    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        int currentStorageUsageAfterUpload= BrowserUtils.getTextToInt(filesPage.quota);
       Assert.assertTrue(currentStorageUsageAfterUpload>=currentStorageUsageBeforeUpload);

    for (WebElement eachFileName: filesPage.listOfNameOnFileTable){
        String str=BrowserUtils.getTextDynamic(eachFileName);
        if(str.contains("uPLOADtEST")){
            Actions actions= new Actions(Driver.getDriver());
            actions.moveToElement(eachFileName).contextClick().perform();
            filesPage.deleteFile.click();
        }
    }

    }

}
