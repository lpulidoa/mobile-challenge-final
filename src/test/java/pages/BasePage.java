package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement mapToElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> mapToElemnts(By locator){
        return driver.findElements(locator);
    }
}
