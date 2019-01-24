package SeleniumGoogle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static SeleniumGoogle.utils.DriverFactory.getDriver;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class Base {
    private WebDriver driver = getDriver();
    private FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(5, SECONDS)
            .pollingEvery(50, MILLISECONDS);

    protected void webDriverWaitForTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
    }

    protected void webDriverWaitForElementIdentifiedById(String expectedElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(expectedElement)));
    }

    protected void webDriverWaitForElementIdentifiedByCss(String expectedElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(expectedElement)));
    }

    protected void webDriverWaitForElementNotToHaveText(String expectedElement, String text) {
        wait.until(ExpectedConditions.not(textToBe(By.id(expectedElement), text)));
    }

    protected void webDriverWaitForElementToHaveText(String expectedElement, String text) {
        wait.until(ExpectedConditions.textToBe(By.id(expectedElement), text));
    }
}
