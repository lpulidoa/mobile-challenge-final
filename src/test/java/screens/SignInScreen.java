package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SignInScreen extends BaseMobileScreen {
    private static final Logger log = getLogger(SignInScreen.class.getName());
    public SignInScreen(AndroidDriver driver) {
        super(driver);
    }

    private final String skipSignInButtonId = "com.imdb.mobile:id/splash_not_now";
    private final String signInButtonId = "com.imdb.mobile:id/imdb_auth_portal";

    public GlobalNavigationScreen skipSignIn(){
        log.info("Skipping login");
        locateElementUiSelector(skipSignInButtonId).click();
        return new GlobalNavigationScreen(driver);
    }

    public LoginScreen loginWithIMDb() {
        log.info("Login with IMDb account");
        locateElementUiSelector(signInButtonId).click();
        return new LoginScreen(driver);
    }


}
