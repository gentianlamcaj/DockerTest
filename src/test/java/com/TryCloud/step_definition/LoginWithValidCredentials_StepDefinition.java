package com.TryCloud.step_definition;

import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithValidCredentials_StepDefinition {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("trycloud.url"));
    }
    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        //wait.until(ExpectedConditions.visibilityOfAllElements());
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

}
