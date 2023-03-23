package steps;

import helpers.ConfigCapabilities;
import helpers.DriverManager;
import helpers.DevicesAvailable;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import screens.UserScreen;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Hooks {

    private DesiredCapabilities capabilities = ConfigCapabilities.getCapabilities(DevicesAvailable.SAUCE_LABS);
    private AndroidDriver<AndroidElement> driver;
    private DriverManager driverManager;
    private static final Logger log = getLogger(Hooks.class.getName());
    public Hooks(DriverManager driverManager) {

        this.driverManager = driverManager;

    }

    @Before
    public void setUp(){
        log.info("Setting up capabilities and creating driver");
        driverManager.createDriver(capabilities);
        log.info("Getting driver");
        driver = driverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        log.info("Quitting driver after scenario");
        if(scenario.isFailed()){
            TakesScreenshot screenshotTaking = (TakesScreenshot) driver;
            byte[] screenshot = screenshotTaking.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of failed test case");
        }
        driver.quit();
    }


}
