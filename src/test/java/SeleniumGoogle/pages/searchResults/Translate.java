package SeleniumGoogle.pages.searchResults;

import SeleniumGoogle.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Translate extends Base {

    @FindBy(id = "tw-source-text-ta")
    private WebElement originalTerm;

    @FindBy(id = "tw-target-text")
    private WebElement translatedTerm;

    public void enterTextIntoToTranslate(String text) {
        originalTerm.sendKeys(text);
    }

    public void assertTranslation(String expectedTranslation) {
        webDriverWaitForElementToHaveText("tw-target-text", expectedTranslation);
    }
}
