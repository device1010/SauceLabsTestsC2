package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "app_logo")
    WebElement appLogo;
    @FindBy(className = "shopping_cart_link")
    WebElement carticon;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addCartButton;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeCartButton;
    @FindBy(id = "react-burger-menu-btn")
    WebElement burguerButton;
    @FindBy(id = "logout_sidebar_link")
    WebElement logOutButton;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLightCartButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean AppLogoIsDisplayed(){
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }
    public String getCartIconText(){
        String cartText = carticon.getText();
        return cartText;
    }
    public void clickOnAddBackpackToCartButton(){
        addCartButton.click();
    }
    public void clickOnRemoveBackpackFromCartButton(){
        removeCartButton.click();
    }
    public void clickOnCartIcon(){
        carticon.click();
    }
    public void clickOnBurguerButton(){
        burguerButton.click();
    }
    public void clickOnAddBikeLight(){
        addBikeLightCartButton.click();
    }
    public void clickOnLogoutLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
    }
}
