package steps;

import helpers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    //public static WebDriver driver;
    private WebDriver driver;
    private DriverManager driverManager;
    public Hooks(DriverManager driverManager) {

        this.driverManager = driverManager;

    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.wikipedia.org/");
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
