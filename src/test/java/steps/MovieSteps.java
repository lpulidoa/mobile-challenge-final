package steps;

import driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import screens.GlobalNavigationScreen;
import screens.MovieScreen;
import screens.RatingScreen;
import screens.SearchResultsScreen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class MovieSteps {
    private DriverManager driverManager;
    private String title;
    private String starsRating;
    public MovieSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

    }

    @And("the user adds a result to their watchlist")
    public void theUserAddsAResultToTheirWatchlist() {
        MovieScreen searchResult = new SearchResultsScreen(driverManager.getDriver()).clickAnyResult();
        searchResult.addToWatchlist();
        driverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        title = searchResult.getTitle();
    }

    @Then("the user must see the movie in their watchlist")
    public void theUserMustSeeTheMovieInTheirWatchlist() {
        List<String> inWatchlist = new GlobalNavigationScreen(driverManager.getDriver())
                .goToUserPage()
                .enterWatchlist()
                .getNames();
        assertThat("The movie is not in the user's watchlist",inWatchlist,hasItem(title));
    }

    @And("the user rates the first result {int} stars")
    public void theUserRatesTheFirstResultStars(int stars) {
        starsRating = Integer.toString(stars);
        new SearchResultsScreen( driverManager.getDriver())
                .clickFirstResult()
                .rateMovie()
                .selectStarRating(stars)
                .confirmRating();
    }

    @Then("the user should see the correct rating displayed in the movie page")
    public void theUserShouldSeeTheCorrectRatingDisplayedInTheMoviePage() {
        String userRating = new MovieScreen(driverManager.getDriver())
                .getUserRating();
        assertThat("The user rating is not correct",userRating,equalTo(starsRating));
    }

    @Then("the user should see a saved rating message")
    public void theUserShouldSeeASavedRatingMessage() {
        String message = new RatingScreen(driverManager.getDriver()).getSavedMessage();
        System.out.println("The saved message is:" + message);
    }


}
