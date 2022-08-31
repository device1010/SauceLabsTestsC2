import Pages.*;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;

public class OverviewTests extends BaseTest{
    //6
    @Test
    public void buttonFinishWorks(){
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
        overview.clickFinishButton();

        CompleteCheckout completeCheckout = new CompleteCheckout(DriverManager.getDriver());
        Assert.assertEquals("CHECKOUT: COMPLETE!", completeCheckout.getCompleteTitleText());
    }
}
