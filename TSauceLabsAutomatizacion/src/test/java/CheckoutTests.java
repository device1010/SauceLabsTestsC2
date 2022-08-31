import Pages.*;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;

public class CheckoutTests extends BaseTest{
    //3
    @Test
    public void checkoutWithoutFirstName(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        cartPage.clickCheckoutButton();

        Checkout checkout = new Checkout(DriverManager.getDriver());
        checkout.setLastnameTextBox("ApellidoGenerico");
        checkout.setPostalCodeTextBox("A200");
        checkout.clickButtonContinue();

        Assert.assertEquals("Error: First Name is required", checkout.getContinueError());
    }
    //4
    @Test
    public void buttonContinueWorks(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        cartPage.clickCheckoutButton();

        Checkout checkout = new Checkout(DriverManager.getDriver());
        checkout.setFirstnameTextBox("NombreGenerico");
        checkout.setLastnameTextBox("ApellidoGenerico");
        checkout.setPostalCodeTextBox("A200");
        checkout.clickButtonContinue();

        Overview overview = new Overview(DriverManager.getDriver());
        Assert.assertEquals("CHECKOUT: OVERVIEW", overview.getTitleText());
    }
    //5
    @Test
    public void checkoutWithoutLastName(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        cartPage.clickCheckoutButton();

        Checkout checkout = new Checkout(DriverManager.getDriver());
        checkout.setFirstnameTextBox("NombreGenerico");
        checkout.setPostalCodeTextBox("A200");
        checkout.clickButtonContinue();

        Assert.assertEquals("Error: Last Name is required", checkout.getContinueError());
    }
}
