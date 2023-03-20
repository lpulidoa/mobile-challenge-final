package screens;

import io.appium.java_client.android.AndroidDriver;

public class SearchScreen extends BaseMobileScreen {
    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }

    private final String searchBarId = "com.imdb.mobile:id/search_src_text";

    public SearchResultsScreen searchBarClick() {
        waitForElementClickable(searchBarId);
        locateElementUiSelector(searchBarId).click();
        return new SearchResultsScreen(driver);
    }


}
