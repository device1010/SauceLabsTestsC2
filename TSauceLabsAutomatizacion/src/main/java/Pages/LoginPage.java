package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id="user-name")
    WebElement usernameTextBox;
    @FindBy (id="password")
    WebElement passwordTextBox;
    @FindBy (id="login-button")
    WebElement loginButton;
    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement loginError;

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setUsernameTextBox(String userName){
        usernameTextBox.sendKeys(userName);
    }
    public void setPasswordTextBox(String password){
        passwordTextBox.sendKeys(password);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public String getLoginErrorMessage(){
        String errorMessage = loginError.getText();
        return errorMessage;
    }
}
