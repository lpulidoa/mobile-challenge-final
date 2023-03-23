package steps;

import helpers.DriverManager;
import helpers.JSONDataReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import screens.MovieScreen;
import screens.SearchResultsScreen;
import screens.SearchScreen;
import data.entities.Movie;

public class SearchSteps {

    private DriverManager driverManager;
    private String movieDescription;
    public SearchSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

    }
    @When("the user searches for the movie {string}")
    public void theUserSearchesForTheMovie(String movieName) {
        SearchScreen search = new SearchScreen(driverManager.getDriver());
        search.searchBarClick().searchMovie(movieName);
        Movie movie = new JSONDataReader().getMovieByName(movieName);
        movieDescription = movie.getDescription();
    }

    @Then("the user should see the correct overview in the first result page")
    public void theUserShouldSeeTheCorrectOverviewInTheFirstResultPage() {
        MovieScreen searchedMovie = new SearchResultsScreen(driverManager.getDriver())
                .clickFirstResult();
        Assert.assertEquals(searchedMovie.getPlotOverview(), movieDescription);
    }
}
