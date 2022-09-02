import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Login.feature",
        glue = {"stepDefinitions"},
        tags = "@loginWithValidCredentials"
)
public class TestRunner {

}
