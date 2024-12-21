package runner;

import com.Utilities.MyListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(MyListener.class)
@CucumberOptions
        (
                features = "src/test/resources/feature_files/",
                glue = {"step_definitions", "hooks"},
                tags = "@TutorialsNinjaLogin or @TutorialsNinjaAddToCart or @TutorialsNinjaLogout or @TutorialsNinjaRegister or @TutorialsNinjaSearchProduct",
                monochrome = true,
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty", "html:target/site/cucumber-report.html", "json:target/cucumber1.json"}
        )

public class Runner_TestNG extends AbstractTestNGCucumberTests {
}
