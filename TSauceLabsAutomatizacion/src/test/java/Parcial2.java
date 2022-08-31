import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;

public class Parcial2 extends BaseTest{
    @Test
    public void verifyProductOnCartPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.clickOnAddBackpackToCartButton();
        homePage.clickOnAddBikeLight();
        homePage.clickOnCartIcon();

        CartPage cartPage = new CartPage(DriverManager.getDriver());
        Assert.assertTrue(cartPage.SauceLabsBackPackOnCartIsDisplayed());
        Assert.assertTrue(cartPage.SauceLabsBikeLightOnCartIsDisplayed());
        Assert.assertEquals("$29.99", cartPage.getBackpacklPriceText());
        Assert.assertEquals("$9.99", cartPage.getBikeLightPriceText());
        Assert.assertEquals("2", cartPage.getCartIconText());

        cartPage.clickRemovebackpackButton();
        cartPage.clickRemovebikelightButton();

        Assert.assertEquals("QTYDESCRIPTION", cartPage.getCartListText());
        Assert.assertEquals("", cartPage.getCartIconText());
    }
}
