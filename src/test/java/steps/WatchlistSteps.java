package steps;

import driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import screens.GlobalNavigationScreen;
import screens.MovieScreen;
import screens.SearchResultsScreen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class WatchlistSteps {
    private DriverManager driverManager;
    private String title;
    public WatchlistSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @And("the user adds a result to their watchlist")
    public void theUserAddsAResultToTheirWatchlist() {
        MovieScreen searchResult = new SearchResultsScreen(driverManager.getDriver()).clickAnyResult();
        driverManager.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        title = searchResult.getTitle();
        searchResult.addToWatchlist();
    }

    @Then("the user must see the movie in their watchlist")
    public void theUserMustSeeTheMovieInTheirWatchlist() {
        List<String> inWatchlist = new GlobalNavigationScreen(driverManager.getDriver())
                .goToUserPage()
                .enterWatchlist()
                .getNames();
        assertThat("The movie is not in the user's watchlist",inWatchlist,hasItem(title));
    }
}
