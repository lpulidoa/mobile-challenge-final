package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WatchlistScreen extends BaseMobileScreen{
    public WatchlistScreen(AndroidDriver driver) {
        super(driver);
    }

    private final String itemNamesId = "com.imdb.mobile:id/primaryText";

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        List<WebElement> nameElements = locateElementsUiSelector(itemNamesId);

        for(int i=0; i<nameElements.size(); i++){
            names.add(nameElements.get(i).getText());
        }
        return names;
    }


}
