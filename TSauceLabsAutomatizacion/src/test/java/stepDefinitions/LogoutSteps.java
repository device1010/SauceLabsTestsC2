package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutSteps {
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
    @Then("I click on hamburguer button of Home Page")
    public void homePagehamburguerButton(){
        homePage.clickOnBurguerButton();
    }
    @And("I click on logout link")
    public void clickonlogoutlink(){
        homePage.clickOnLogoutLink();
    }
    @Then("The loginPage should be displayed")
    public void loginIsDisplayed(){
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
