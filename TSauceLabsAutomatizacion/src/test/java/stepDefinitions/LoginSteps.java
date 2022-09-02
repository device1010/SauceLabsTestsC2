package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    HomePage homePage = new HomePage(DriverManager.getDriver());
    @Given("I set the user name field with {string}")
    public void setUserName(String userName){
        loginPage.setUsernameTextBox(userName);
    }
    @And("I set the password field with {string}")
    public void setUserPassword(String password){
        loginPage.setPasswordTextBox(password);
    }
    @When("I click on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @Then("The home page should be displayed")
    public void homePageIsDisplayed(){
        Assert.assertTrue(homePage.AppLogoIsDisplayed());
    }
    @Then("An error message that says {string} is displayed")
    public void verifyLoginErrorMessage(String message){
        Assert.assertEquals(message, loginPage.getLoginErrorMessage());
    }
}
