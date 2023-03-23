package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

public class UserScreen extends BaseMobileScreen{
    private static final Logger log = getLogger(UserScreen.class.getName());
    public UserScreen(AndroidDriver driver) {
        super(driver);
    }

    private final By seeWatchlistBy = By.xpath("//android.widget.TextView[@content-desc=\"See all Watchlist\"]");
    private final By existingListsQtyBy = By.xpath("//android.widget.TextView[@resource-id=\"com.imdb.mobile:id/number_votes\"]"); //Index 1
    private final By createListButtonBy = By.xpath("//android.widget.TextView[@text=\"Create a list\"]");


    public WatchlistScreen enterWatchlist() {
        mapToElement(seeWatchlistBy).click();
        return new WatchlistScreen(driver);
    }

    public String getExistingListsQty() {
        log.info("Checking number of existing lists");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return mapToElements(existingListsQtyBy).get(1).getText();
    }

    public NewListScreen createList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mapToElement(createListButtonBy).click();
        return new NewListScreen(driver);
    }

}
