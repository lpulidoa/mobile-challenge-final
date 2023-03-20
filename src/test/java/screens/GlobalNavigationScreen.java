package screens;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class GlobalNavigationScreen extends BaseMobileScreen {

    public GlobalNavigationScreen(AndroidDriver driver){super(driver);}

    private final String searchButtonId = "com.imdb.mobile:id/navigation_search_browse";
    private final String youPageButtonId = "com.imdb.mobile:id/navigation_you";

    public SearchScreen goToSearch(){
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitForElementClickable(searchButtonId);
        locateElementUiSelector(searchButtonId).click();
        return new SearchScreen(driver);
    }

    public UserScreen goToUserPage() {
        locateElementUiSelector(youPageButtonId).click();
        return new UserScreen(driver);
    }

}
