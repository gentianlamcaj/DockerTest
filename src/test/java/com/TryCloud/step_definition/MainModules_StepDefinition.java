package com.TryCloud.step_definition;

import com.TryCloud.pages.BasePage;
import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class MainModules_StepDefinition {
    BasePage basePage=new BasePage();
    LoginPage loginPage=new LoginPage();

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.login();
    }


    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {
        List <String> actualModules= BrowserUtils.listOfWebElementsToListOfString(basePage.appMenu);
        Assert.assertTrue(actualModules.containsAll(expectedModules));

    }
}
