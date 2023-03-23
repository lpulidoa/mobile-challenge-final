package helpers;


import helpers.ConfigCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private AndroidDriver<AndroidElement> driver;
    private URL url;

    public void createDriver(DesiredCapabilities capabilities){
        if(ConfigCapabilities.device.equalsIgnoreCase("sauceLabs")){
            try {
                String username = System.getenv("SAUCE_USERNAME");
                String accesskey = System.getenv("SAUCE_ACCESS_KEY");
                url = new URL("https://"+ username +":"+accesskey+"@ondemand.us-west-1.saucelabs.com:443/wd/hub");
                driver = new AndroidDriver<>(url, capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
}

