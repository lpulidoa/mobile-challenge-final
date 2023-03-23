package helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

public class ConfigCapabilities {
    private static final Logger log = Logger.getLogger(ConfigCapabilities.class.getName());
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String JSON_FILE_PATH = "src/test/java/data/devices/capabilities.json";
    public static String device;
    private static JsonParser parser = new JsonParser();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        if(device.equalsIgnoreCase("sauceLabs")){
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:app", "storage:filename=Imdb.apk");
            capabilities.setCapability("appium:deviceName", "Google Pixel 3 GoogleAPI Emulator");
            capabilities.setCapability("appium:platformVersion", "10.0");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", "Test-build1");
            sauceOptions.setCapability("appiumVersion", "1.17.1");
            capabilities.setCapability("sauce:options", sauceOptions);
        } else {
            capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
            capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
            capabilities.setCapability("platformVersion", getJsonDataProperty(PLATFORM_VERSION));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getJsonDataProperty(PLATFORM_VERSION));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        }
    }

    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject device = (JsonObject) obj;
            JsonObject jsonObject = (JsonObject) device.get(ConfigCapabilities.device);
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return "";
    }

    public static DesiredCapabilities getCapabilities(DevicesAvailable deviceName){
        device = deviceName.getDeviceName();
        ConfigCapabilities.ApplicationSetUp(capabilities);
        return capabilities;
    }



}
