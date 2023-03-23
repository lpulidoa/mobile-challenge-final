import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"} , glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html",
                "json:target/cucumber-reports/reports.json",
                "json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter"})//, tags = "@Only")
public class Runner extends AbstractTestNGCucumberTests {

}
