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
}
