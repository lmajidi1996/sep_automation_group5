package com.sep.step_definition;

import com.sep.utilities.ConfigurationReader;
import com.sep.utilities.web.BrowserUtils;
import com.sep.utilities.web.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {

    /**
     * This method is executed before each scenario. It sets the implicit wait time and opens the application URL.
     */
    @Before
    public void setup(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(p -> p.startsWith("@api"))) {
            baseURI = ConfigurationReader.getConfigProperty("baseUrl");
            return;
        }
        DriverUtils.getDriver();
        DriverUtils.getDriver().manage().window().maximize();
        DriverUtils.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverUtils.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    /**
     * This method is executed after each scenario. It takes a screenshot if the scenario failed, closes the browser, and
     * sleeps for 2 seconds.
     *
     * @param scenario the current scenario
     */
    @After
    public void teardown(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(p -> p.startsWith("@api"))) {
            reset();
            return;
        }
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverUtils.closeDriver();

    }

}
