package helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private WebDriver driver;

    public void createDriver(){
        driver  = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
