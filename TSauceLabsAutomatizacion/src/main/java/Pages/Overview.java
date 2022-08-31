package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement OverviewTitle;
    @FindBy(id = "finish")
    WebElement finishButton;
    public Overview(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTitleText(){
        String overviewText = OverviewTitle.getText();
        return overviewText;
    }
    public void clickFinishButton(){
        finishButton.click();
    }
}
