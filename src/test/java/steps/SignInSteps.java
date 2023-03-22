package steps;

import driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import screens.SignInScreen;

public class SignInSteps {

    private DriverManager driverManager;
    public SignInSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

    }
    @Given("the user wants to make a search skipping login")
    public void theUserWantsToMakeASearchSkippingLogin() {
        SignInScreen signInScreen = new SignInScreen(driverManager.getDriver());
        signInScreen.skipSignIn().goToSearch();
    }

    @Given("the user logs in")
    public void theUserLogsIn() {
        new SignInScreen(driverManager.getDriver())
                .loginWithIMDb()
                .clickShowPassword()
                .typeEmail(System.getenv("EMAIL"))
                .typePassword(System.getenv("PASSWORD_IMDB"))
                .clickConfirmLogin();
    }

}
