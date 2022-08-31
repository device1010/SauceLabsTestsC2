package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement CheckoutTitle;
    @FindBy(xpath = "//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3")
    WebElement ContinueError;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "first-name")
    WebElement firstnameTextBox;
    @FindBy(id = "last-name")
    WebElement lastnameTextBox;
    @FindBy(id = "postal-code")
    WebElement postalCodeTextBox;
    public Checkout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setFirstnameTextBox(String firstname){
        firstnameTextBox.sendKeys(firstname);
    }
    public void setLastnameTextBox(String lastname){
        lastnameTextBox.sendKeys(lastname);
    }
    public void setPostalCodeTextBox(String postalCode){
        postalCodeTextBox.sendKeys(postalCode);
    }
    public String getTitleText(){
        String titleText = CheckoutTitle.getText();
        return titleText;
    }
    public String getContinueError(){
        String errorText = ContinueError.getText();
        return errorText;
    }
    public void clickButtonContinue(){
        continueButton.click();
    }
}
