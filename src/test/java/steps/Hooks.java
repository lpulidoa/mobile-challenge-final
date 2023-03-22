package steps;

import helpers.ConfigCapabilities;
import driverfactory.DriverManager;
import helpers.DevicesAvailable;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {

    private DesiredCapabilities capabilities = ConfigCapabilities.getCapabilities(DevicesAvailable.PIXEL2_ANDROID13);
    private AndroidDriver<AndroidElement> driver;
    private DriverManager driverManager;
    public Hooks(DriverManager driverManager) {

        this.driverManager = driverManager;

    }

    @Before
    public void setUp(){
        driverManager.createDriver(capabilities);
        driver = driverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot screenshotTaking = (TakesScreenshot) driver;
            byte[] screenshot = screenshotTaking.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of failed test case");
        }
        driver.quit();
    }


}
