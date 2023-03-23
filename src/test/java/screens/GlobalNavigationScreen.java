package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class GlobalNavigationScreen extends BaseMobileScreen {
    private static final Logger log = getLogger(GlobalNavigationScreen.class.getName());

    public GlobalNavigationScreen(AndroidDriver driver){super(driver);}

    private final String searchButtonId = "com.imdb.mobile:id/navigation_search_browse";
    private final String youPageButtonId = "com.imdb.mobile:id/navigation_you";

    public SearchScreen goToSearch(){
        log.info("Going to search page");
        waitForElementClickable(searchButtonId);
        locateElementUiSelector(searchButtonId).click();
        return new SearchScreen(driver);
    }

    public UserScreen goToUserPage() {
        log.info("Going to user page");
        locateElementUiSelector(youPageButtonId).click();
        return new UserScreen(driver);
    }

}
