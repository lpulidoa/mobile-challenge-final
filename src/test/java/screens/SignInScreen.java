package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInScreen extends BaseMobileScreen {
    public SignInScreen(AndroidDriver driver) {
        super(driver);
    }

    private final String skipSignInButtonId = "com.imdb.mobile:id/splash_not_now";
    private final String signInButtonId = "com.imdb.mobile:id/imdb_auth_portal";

    public GlobalNavigationScreen skipSignIn(){
        locateElementUiSelector(skipSignInButtonId).click();
        return new GlobalNavigationScreen(driver);
    }

    public LoginScreen loginWithIMDb() {
        locateElementUiSelector(signInButtonId).click();
        return new LoginScreen(driver);
    }


}
