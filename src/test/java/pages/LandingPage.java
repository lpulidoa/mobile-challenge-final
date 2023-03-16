package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class LandingPage extends BasePage{

    private static final Logger log = getLogger(LandingPage.class.getName());
    public LandingPage(WebDriver driver){
        super(driver);
    }

    private final By inputTextBy = By.xpath("//input[@id='searchInput']");
    private final By searchResultsBy = By.xpath("//a[@class='suggestion-link']");

    public LandingPage searchQuery(String query){
        mapToElement(inputTextBy).sendKeys(query);
        log.info("Searching for " + query);
        return this;
    }

    public LandingPage waitForSearchResults(){
        log.info("Waiting for search results");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchResultsBy,1));
        return this;
    }
    public ArticlePage clickFirstResult(){
        mapToElemnts(searchResultsBy).get(0).click();
        return new ArticlePage(driver);
    }
}
