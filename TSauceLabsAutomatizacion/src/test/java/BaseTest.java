import Utilities.DriverManager;
import org.junit.AfterClass;
import org.junit.Before;

public class BaseTest{
    @Before
    public void setup(){
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        DriverManager.getDriver().manage().window().maximize();
    }
    @AfterClass
    public static void cleanup(){
        DriverManager.getDriver().quit();
    }
}
