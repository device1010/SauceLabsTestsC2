import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends BaseTest{
    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Assert.assertTrue(homePage.AppLogoIsDisplayed());
    }
    @Test
    public void loginWithInvalidCredentialsTest(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.setUsernameTextBox("standard");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getLoginErrorMessage());
    }
}
