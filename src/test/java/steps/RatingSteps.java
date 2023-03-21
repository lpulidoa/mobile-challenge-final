package steps;

import driverfactory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import screens.MovieScreen;
import screens.RatingScreen;
import screens.SearchResultsScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RatingSteps {
    private DriverManager driverManager;

    private String starsRating;
    public RatingSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

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
