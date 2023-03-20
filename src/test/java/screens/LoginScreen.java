package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginScreen extends BaseMobileScreen{
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    private final By emailBarBy = By.xpath("//android.widget.EditText[@resource-id=\"ap_email\"]");
    private final By passwordBarBy = By.xpath("//android.widget.EditText[@resource-id=\"ap_password\"]");
    private final By signInButtonBy = By.xpath("//android.widget.Button[@resource-id=\"signInSubmit\"]");
    private final By showPasswordCheckboxBy = By.xpath("//android.widget.CheckBox[@resource-id=\"auth-show-password-checkbox\"]");

    public LoginScreen clickShowPassword() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mapToElement(showPasswordCheckboxBy).click();
        return this;
    }

    public LoginScreen typeEmail(String email) {
        WebElement element = mapToElement(emailBarBy);
        element.click();
        element.sendKeys(email);
        return this;
    }

    public LoginScreen typePassword(String password) {
        WebElement element = mapToElement(passwordBarBy);
        element.click();
        element.sendKeys(password);
        return this;
    }

    public UserScreen clickConfirmLogin() {
        mapToElement(signInButtonBy).click();
        return new UserScreen(driver);
    }

}
