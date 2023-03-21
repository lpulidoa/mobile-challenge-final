package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class UserScreen extends BaseMobileScreen{
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return mapToElements(existingListsQtyBy).get(1).getText();
    }

    public NewListScreen createList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mapToElement(createListButtonBy).click();
        return new NewListScreen(driver);
    }

}
