import Pages.CartPage;
import Pages.Checkout;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartTests extends BaseTest{
    @Test
    public void verifyProductOnCartPage(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.SauceLabsBackPackOnCartIsDisplayed());
    }
    @Test
    public void verifyProductsOnCartAfterGoBack() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnBurguerButton();
        homePage.clickOnLogoutLink();


        LoginPage loginPage2 = new LoginPage(DriverManager.getDriver());
        loginPage2.setUsernameTextBox("standard_user");
        loginPage2.setPasswordTextBox("secret_sauce");
        loginPage2.clickOnLoginButton();

        HomePage homePage2 = new HomePage(DriverManager.getDriver());
        homePage2.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.SauceLabsBackPackOnCartIsDisplayed());
    }
    //1
    @Test
    public void noCheckoutWithoutProducts(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnCartIcon();
        CartPage cartPage = new CartPage(DriverManager.getDriver());
        cartPage.clickCheckoutButton();
        Assert.assertEquals("YOUR CART",cartPage.getTitleText());
    }
    //2
    @Test
    public void buttonCheckoutWorks(){
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
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION",checkout.getTitleText());
    }
}
