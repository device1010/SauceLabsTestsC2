package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import com.google.common.collect.Ordering;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class HomeSteps {
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
    @And("I add a product to the cart")
    public void clickAddBackpackToCartButton(){
        homePage.clickOnAddBackpackToCartButton();
    }
    @Then("The number of items in the cart increase")
    public void NumberOfProductIncrease(){
        Assert.assertEquals("1", homePage.getCartIconText());
    }
    @And("I click on the filter to change low to high")
    public void clickOnfilterLowToHigh(){
        homePage.selectProductFilter("Price (low to high)");
    }
    @Then("I verify the order of the prices")
    public void VerifyTheOrderOfPrices(){
        List<Double> prices = homePage.getAllItemPrices();
        Assert.assertTrue(Ordering.natural().isOrdered(prices));
    }

}
