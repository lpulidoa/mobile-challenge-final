package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewListScreen extends BaseMobileScreen{
    public NewListScreen(AndroidDriver driver) {
        super(driver);
    }

    private final By nameBarBy = By.xpath("//android.widget.EditText[@resource-id=\"com.imdb.mobile:id/list_name\"]");
    private final By descriptionBarBy = By.xpath("//android.widget.EditText[@resource-id=\"com.imdb.mobile:id/list_description\"]");
    private final By titleCheckboxTypeBy = By.xpath("//android.widget.RadioButton[@resource-id=\"com.imdb.mobile:id/title\"]");
    private final By nameCheckboxTypeBy = By.xpath("//android.widget.RadioButton[@resource-id=\"com.imdb.mobile:id/name\"]");
    private final By saveButtonBy = By.xpath("//android.widget.Button[@resource-id=\"com.imdb.mobile:id/save_list_button\"]");

    public NewListScreen typeListName(String listName) {
        WebElement element = mapToElement(nameBarBy);
        element.click();
        element.sendKeys(listName);
        return this;
    }

    public NewListScreen typeListDescription(String listDescription) {
        WebElement element = mapToElement(descriptionBarBy);
        element.click();
        element.sendKeys(listDescription);
        return this;
    }

    public NewListScreen selectTitleType() {
        mapToElement(titleCheckboxTypeBy).click();
        return this;
    }

    public NewListScreen selectNameType() {
        mapToElement(nameCheckboxTypeBy).click();
        return this;
    }

    public UserScreen saveList() {
        mapToElement(saveButtonBy).click();
        return new UserScreen(driver);
    }

}
