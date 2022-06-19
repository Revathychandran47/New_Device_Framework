package Runner_File;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        publish = true,
        plugin = {"pretty","html:target/site/serenity/Report.html"},
        features = "src/test/resources/features/03_Signup_positive_scenario.feature",
        glue= {"Stepdefinition"})
public class TestSuite {

}
