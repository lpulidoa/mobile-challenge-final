package helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
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
    private static final String JSON_FILE_PATH = "src/test/java/data/devices/capabilities2.json";
    private static String device;
    private static JsonParser parser = new JsonParser();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
        capabilities.setCapability("platformVersion", getJsonDataProperty(PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getJsonDataProperty(PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
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

//    private static String getJsonDataProperty(String property) {
//        try {
//            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
//            JsonObject jsonObject = (JsonObject) obj;
//            return jsonObject.get(property).getAsString();
//        } catch (FileNotFoundException e) {
//            log.info(e.getMessage());
//        } catch (Exception e) {
//            log.info(e.getMessage());
//        }
//        return "";
//    }

    public static DesiredCapabilities getCapabilities(DevicesAvailable deviceName){
        device = deviceName.getDeviceName();
        ConfigCapabilities.ApplicationSetUp(capabilities);
        return capabilities;
    }



}
