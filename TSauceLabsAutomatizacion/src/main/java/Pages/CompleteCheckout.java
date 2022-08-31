package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteCheckout {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement CompleteTitle;
    public CompleteCheckout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getCompleteTitleText(){
        String completeTitleText = CompleteTitle.getText();
        return completeTitleText;
    }
}
