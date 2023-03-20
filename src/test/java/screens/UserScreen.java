package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class UserScreen extends BaseMobileScreen{
    public UserScreen(AndroidDriver driver) {
        super(driver);
    }

    private final By seeWatchlistBy = By.xpath("//android.widget.TextView[@content-desc=\"See all Watchlist\"]");

    public WatchlistScreen enterWatchlist() {
        mapToElement(seeWatchlistBy).click();
        return new WatchlistScreen(driver);
    }


}
