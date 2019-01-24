package SeleniumGoogle.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static SeleniumGoogle.steps.ExecutionHooks.getTestState;
import static SeleniumGoogle.utils.DriverFactory.getDriver;

public class Search extends Base {

    @FindBy(css = "#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    private WebDriver driver = getDriver();

    public void navigateToPage() {
        driver.get("https://www.google.com/");
        webDriverWaitForTitle("Google");
    }

    public void enterTextIntoSearch(String searchTerm) {
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);
        webDriverWaitForTitle(searchTerm + " - Google Search");
        getTestState().searchTerm = searchTerm;
    }
}
