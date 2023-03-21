package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

public class LoginScreen extends BaseMobileScreen{
    private static final Logger log = getLogger(LoginScreen.class.getName());
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
        log.info("Typing email");
        WebElement element = mapToElement(emailBarBy);
        element.click();
        element.sendKeys(email);
        return this;
    }

    public LoginScreen typePassword(String password) {
        log.info("Typing password");
        WebElement element = mapToElement(passwordBarBy);
        element.click();
        element.sendKeys(password);
        return this;
    }

    public UserScreen clickConfirmLogin() {
        log.info("Confirming login");
        mapToElement(signInButtonBy).click();
        return new UserScreen(driver);
    }

}
