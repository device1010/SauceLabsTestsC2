import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.List;

public class HomeTests extends BaseTest{
    @Test
    public void verifyCartButtonNumberIsAdded(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        Assert.assertEquals("1", homePage.getCartIconText());
        homePage.clickOnRemoveBackpackFromCartButton();
    }
    @Test
    public void verifyCartButtonNumberIsBlankWhereThereIsNotProductsInTheCart(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnRemoveBackpackFromCartButton();
        Assert.assertEquals("", homePage.getCartIconText());
    }
    @Test
    public void verifyGoToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.YourCartIsDisplayed());
    }
    @Test
    public void verifyLowToHighPriceItemsFilterTest() {
        // Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        // Filtering by price
        HomePage homepage= new HomePage(DriverManager.getDriver());
        homepage.selectProductFilter("Price (low to high)");
        List<Double> prices = homepage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }
}
