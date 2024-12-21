package hooks;

import com.Utilities.ConfigReader;
import com.Utilities.Util;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

public class MyHooks {

    public WebDriver driver;

    @Before
    public void setup() throws Exception {

        Properties prop = ConfigReader.initializePropertiesFile();

        DriverFactory.initializeBrowser(prop.getProperty("browser"));

        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
        driver.get(prop.getProperty("url"));
    }

    @After(order = 1)
    public void screenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName().replace(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", scenarioName);
        }
    }


    @After(order = 0)
    public void tearDown() {
        driver.quit();
    }


}
