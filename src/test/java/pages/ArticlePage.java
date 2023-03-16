package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage{
    public ArticlePage(WebDriver driver){
        super(driver);
    }
    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    public String getTitle(){
        return pageTitle.getText();
    }

}
