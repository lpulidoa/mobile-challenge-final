package steps;

import helpers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;


public class LandingPageSteps{

    private DriverManager driverManager;
    public LandingPageSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

    }

    @Given("the user wants to make a search")
    public void theUserWantsToMakeASearch() {
    }

    @When("the user searches for {string} in the page")
    public void theUserSearchesForInThePage(String query) {
        LandingPage landingPage = new LandingPage(driverManager.getDriver());
        landingPage.searchQuery(query).waitForSearchResults();
    }
}
