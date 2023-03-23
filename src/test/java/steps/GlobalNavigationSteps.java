package steps;

import helpers.DriverManager;
import io.cucumber.java.en.And;
import screens.GlobalNavigationScreen;

public class GlobalNavigationSteps {
    private DriverManager driverManager;
    public GlobalNavigationSteps(DriverManager driverManager) {

        this.driverManager = driverManager;

    }
    @And("the user wants to make a search")
    public void theUserWantsToMakeASearch() {
        new GlobalNavigationScreen(driverManager.getDriver()).goToSearch();
    }
}
