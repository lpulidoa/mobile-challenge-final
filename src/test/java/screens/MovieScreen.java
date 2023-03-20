package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MovieScreen extends BaseMobileScreen {
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
        return locateElementUiSelector(movieTitleId).getText();
    }

    public String getPlotOverview() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForElementPresence(plotOverviewId);
        return locateElementUiSelector(plotOverviewId).getText();
    }

    public MovieScreen addToWatchlist(){
        waitForElementClickable(addToWatchlistButtonId);
        locateElementUiSelector(addToWatchlistButtonId).click();
        return this;
    }

    public RatingScreen rateMovie() {
        WebElement ratingButton = locateElementUiScroll(ratingButtonId);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ratingButton.click();
        return new RatingScreen(driver);
    }

    public String getUserRating() {
        locateElementUiScroll(userRatingsSectionId);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        waitForElementPresence(userRatingsId);
        return locateElementsUiSelector(userRatingsId).get(1).getText();
    }

}
