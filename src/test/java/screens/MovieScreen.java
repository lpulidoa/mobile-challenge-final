package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

public class MovieScreen extends BaseMobileScreen {
    private static final Logger log = getLogger(MovieScreen.class.getName());
    public MovieScreen(AndroidDriver driver) {
        super(driver);
    }

    private final String plotOverviewId = "com.imdb.mobile:id/plot_overview";
    private final String ratingButtonId = "com.imdb.mobile:id/empty_rating_star";
    private final String userRatingsSectionId = "com.imdb.mobile:id/yellow_rating_star";
    private final String userRatingsId = "com.imdb.mobile:id/rating_text";
    private final String addToWatchlistButtonId = "com.imdb.mobile:id/text_off";
    private final String movieTitleId = "com.imdb.mobile:id/title";



    public String getTitle() {
        log.info("Checking movie title");
        waitForElementPresence(movieTitleId);
        String title = locateElementUiSelector(movieTitleId).getText();
        log.info("The title title of the selected movie is: "+ title);
        return title;
    }

    public String getPlotOverview() {
        log.info("Checking movie plot overview");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return locateElementUiSelector(plotOverviewId).getText();
    }

    public MovieScreen addToWatchlist(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitForElementClickable(addToWatchlistButtonId);
        locateElementUiSelector(addToWatchlistButtonId).click();

        log.info("Element added to watchlist");
        return this;
    }

    public RatingScreen rateMovie() {
        WebElement ratingButton = locateElementUiScroll(ratingButtonId);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ratingButton.click();
        return new RatingScreen(driver);
    }

    public String getUserRating() {
        log.info("Scrolling to user rating");
        locateElementUiScroll(userRatingsSectionId);
        waitForElementPresence(userRatingsId);
        return locateElementsUiSelector(userRatingsId).get(1).getText();
    }

}
