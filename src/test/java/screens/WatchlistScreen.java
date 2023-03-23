package screens;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class WatchlistScreen extends BaseMobileScreen{
    private static final Logger log = getLogger(SignInScreen.class.getName());
    public WatchlistScreen(AndroidDriver driver) {
        super(driver);
    }

    private final String itemNamesId = "com.imdb.mobile:id/primaryText";

    public List<String> getNames() {
        log.info("Checking name of elements currently in watchlist");
        List<String> names = new ArrayList<>();
        List<WebElement> nameElements = locateElementsUiSelector(itemNamesId);

        for(int i=0; i<nameElements.size(); i++){
            names.add(nameElements.get(i).getText());
        }
        return names;
    }


}
