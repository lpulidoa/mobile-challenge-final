package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SearchResultsScreen extends BaseMobileScreen {
    private static final Logger log = getLogger(SearchResultsScreen.class.getName());
    public SearchResultsScreen(AndroidDriver driver) {
        super(driver);
    }
    private final String searchBarId = "com.imdb.mobile:id/search_src_text";
    private final String searchResultsId = "com.imdb.mobile:id/suggestion";

    public SearchResultsScreen searchMovie(String movieName) {
        locateElementUiSelector(searchBarId).sendKeys(movieName);
        return new SearchResultsScreen(driver);
    }

    public MovieScreen clickFirstResult() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForElementClickable(searchResultsId);

        log.info("Clicking first result");
        locateElementsUiSelector(searchResultsId).get(0).click();

        return new MovieScreen(driver);
    }

    public MovieScreen clickAnyResult() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForElementClickable(searchResultsId);

        log.info("Clicking any result");
        List<WebElement> searchResults = locateElementsUiSelector(searchResultsId);
        int index = (int) (Math.random() * (searchResults.size()));
        log.info("Selected index " + index);
        searchResults.get(index).click();

        return new MovieScreen(driver);
    }
}
