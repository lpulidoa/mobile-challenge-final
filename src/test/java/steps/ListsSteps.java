package steps;

import driverfactory.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.GlobalNavigationScreen;
import screens.NewListScreen;
import screens.UserScreen;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ListsSteps {
    private DriverManager driverManager;
    private int existingListsQty;
    public ListsSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    @When("the user creates a list with the following characteristics")
    public void theUserCreatesAListWithTheFollowingCharacteristics(Map<String, String> characteristic) {
        UserScreen userScreen = new GlobalNavigationScreen(driverManager.getDriver()).goToUserPage();
        existingListsQty = Integer.parseInt(userScreen.getExistingListsQty());

        NewListScreen newListScreen = userScreen.createList();
        newListScreen.typeListName(characteristic.get("name")).typeListDescription(characteristic.get("description"));

        if (characteristic.get("type").equalsIgnoreCase("Title"))
            newListScreen.selectTitleType();
        else
            newListScreen.selectNameType();

        newListScreen.saveList();
    }

    @Then("the user should see the number of existing lists increase")
    public void theUserShouldSeeTheNumberOfExistingListsIncrease() {
        int currentListsQty = Integer.parseInt(new UserScreen(driverManager.getDriver()).getExistingListsQty());

        assertThat("The number of existing lists is not correct", currentListsQty , equalTo(existingListsQty+1) );
    }
}
