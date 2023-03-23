package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class RatingScreen extends BaseMobileScreen{
    private static final Logger log = getLogger(RatingScreen.class.getName());
    public RatingScreen(AndroidDriver driver) {
        super(driver);
    }
    protected WebDriverWait wait;
    private final By starsBy = By.xpath("//android.widget.ImageView[contains(@resource-id, \"star\")]");
    private final By confirmRatingButtonBy = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.imdb.mobile:id/rate_title_button\"]");
    private final By ratingSavedMessageBy = By.xpath("//*[contains(text() , 'Rating saved')]");

    public RatingScreen selectStarRating(int rating){
        log.info("Rating movie");
        List<WebElement> stars = mapToElements(starsBy);
        stars.get(rating-1).click();
        return this;
    }
    public RatingScreen confirmRating() {
        mapToElement(confirmRatingButtonBy).click();
        return this;
    }
    public String getSavedMessage() {
        log.info("Locating saved rating message");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(mapToElement(By.xpath("//*[contains(text() , 'Rating saved')]"))));
        return mapToElement(By.xpath("//android.widget.TextView[contains(text() , 'Rating saved')]")).getText(); //driver.findElement(ratingSavedMessageBy).getText();
    }

    public Boolean isSavedMessageDisplayed() {
        log.info("Locating saved rating message is possible?");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(mapToElement(ratingSavedMessageBy)));
        return mapToElement(ratingSavedMessageBy).isDisplayed();
    }
}
