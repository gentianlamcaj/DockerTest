package com.TryCloud.step_definition;

import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginWithInvalidCredentiales {

    LoginPage loginPage=new LoginPage();

    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }
    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String expectedMessage) {
        String actualMessage= BrowserUtils.getTextDynamic(loginPage.warningWrongPasswordMsg);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
