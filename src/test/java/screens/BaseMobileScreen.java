package screens;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseMobileScreen {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BaseMobileScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement locateElementUiScroll(String resourceId) {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\"))");
    }

    public WebElement locateElementUiSelector(String resourceId) {
        return  driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\""+resourceId+"\")");
    }

    public List<WebElement> locateElementsUiSelector(String resourceId) {
        return  driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\""+resourceId+"\")");
    }

    public void waitForElementPresence(String resourceId){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(locateElementUiSelector(resourceId)));
    }

    public void waitForElementClickable(String resourceId){
        waitForElementPresence(resourceId);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locateElementUiSelector(resourceId)));
    }

    public WebElement mapToElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> mapToElements(By locator){
        return driver.findElements(locator);
    }

}


