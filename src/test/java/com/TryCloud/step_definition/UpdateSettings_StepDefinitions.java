package com.TryCloud.step_definition;

import com.TryCloud.pages.FilesPage;
import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;


import java.util.List;

public class UpdateSettings_StepDefinitions {
    FilesPage filesPage=new FilesPage();
    LoginPage loginPage=new LoginPage();


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("trycloud.url"));
        loginPage.login();

    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        filesPage.clickAModuleFromMainModules(string);

    }
    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settingsButton.click();
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {

        for (WebElement eachCheckBox: filesPage.settingsCheckboxButtons) {
            if (eachCheckBox.isDisplayed() && eachCheckBox.isEnabled()) {
                if (eachCheckBox.isSelected()) {
                    eachCheckBox.click();
                    Assert.assertFalse(eachCheckBox.isSelected());
                } else {
                    eachCheckBox.click();
                    Assert.assertTrue(eachCheckBox.isSelected());
                }
            }
        }


    }

}
