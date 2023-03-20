package driverfactory;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private AndroidDriver<AndroidElement> driver;

    public void createDriver(DesiredCapabilities capabilities){
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
}

//public abstract class DriverManager {
//    protected AppiumDriver driver;
//
//    public abstract void createDriver(DesiredCapabilities capabilities);
//
//    public AppiumDriver getDriver() {
//        return driver;
//    }
//}
