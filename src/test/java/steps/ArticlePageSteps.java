package steps;

import helpers.DriverManager;
import io.cucumber.java.en.Then;
import pages.ArticlePage;
import pages.LandingPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;



public class ArticlePageSteps{

    private DriverManager driverManager;
    public ArticlePageSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

    }

    @Then("the user should get the correct article page in the first result")
    public void theUserShouldGetTheCorrectArticlePageInTheFirstResult() {

        ArticlePage articlePage = new LandingPage(driverManager.getDriver()).clickFirstResult();

        assertThat("The title was not correct",
                articlePage.getTitle(), equalTo("Endava"));
    }

}
