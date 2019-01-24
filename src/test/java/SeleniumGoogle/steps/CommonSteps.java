package SeleniumGoogle.steps;

import SeleniumGoogle.pages.Search;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static SeleniumGoogle.utils.DriverFactory.getDriver;

public class CommonSteps {
    private WebDriver driver = getDriver();
    private Search search = PageFactory.initElements(driver, Search.class);

    @Given("^I am on the Google homepage$")
    public void navigateToHomePage() {
        search.navigateToPage();
    }

    @When("^I enter the term \"(.*)\" and search$")
    public void searchForWeather(String searchTerm) {
        search.enterTextIntoSearch(searchTerm);
    }
}
