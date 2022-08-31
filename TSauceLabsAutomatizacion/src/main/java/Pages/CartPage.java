package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement YourCartTitle;
    @FindBy(xpath = "//*[@id='item_4_title_link']/div")
    WebElement SauceLabsBackPackTitle;
    @FindBy(xpath = "//*[@id='item_0_title_link']/div")
    WebElement SauceLabsBikeLight;
    @FindBy(id = "checkout")
    WebElement CheckoutButton;
    @FindBy(xpath = "//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement BackpackPriceText;
    @FindBy(xpath = "//*[@id='cart_contents_container']/div/div[1]/div[4]/div[2]/div[2]/div")
    WebElement BileLightPriceText;
    @FindBy(className = "shopping_cart_link")
    WebElement carticon;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removebackpackButton;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removebikelightButton;
    @FindBy(className = "cart_list")
    WebElement CartObjects;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean YourCartIsDisplayed(){
        boolean CartTitleIsDisplayed = YourCartTitle.isDisplayed();
        return CartTitleIsDisplayed;
    }
    public boolean SauceLabsBackPackOnCartIsDisplayed(){
        boolean SauceLabsBackPackTitleDisplayed = SauceLabsBackPackTitle.isDisplayed();
        return SauceLabsBackPackTitleDisplayed;
    }
    public boolean SauceLabsBikeLightOnCartIsDisplayed(){
        boolean SauceLabsBikeLightTitleDisplayed = SauceLabsBikeLight.isDisplayed();
        return SauceLabsBikeLightTitleDisplayed;
    }
    public void clickCheckoutButton(){
        CheckoutButton.click();
    }
    public String getTitleText(){
        String titleText = YourCartTitle.getText();
        return titleText;
    }
    public String getBackpacklPriceText(){
        String backpacklPriceText = BackpackPriceText.getText();
        return backpacklPriceText;
    }
    public String getBikeLightPriceText(){
        String lightPriceText = BileLightPriceText.getText();
        return lightPriceText;
    }
    public String getCartIconText(){
        String CartIconText = carticon.getText();
        return CartIconText;
    }
    public void clickRemovebackpackButton(){
        removebackpackButton.click();
    }
    public void clickRemovebikelightButton(){
        removebikelightButton.click();
    }
    public String getCartListText(){
        String CartListText = CartObjects.getText();
        return CartListText;
    }
}