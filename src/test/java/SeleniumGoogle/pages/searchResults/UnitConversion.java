package SeleniumGoogle.pages.searchResults;

import SeleniumGoogle.pages.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;

public class UnitConversion extends Base {
    @FindBy(css = "#rso > div:nth-child(1) > div > div > div > div.CR33Se > div > div.sc5Lhd > select")
    private WebElement typeOfConversionDropDown;

    @FindBy(id = "ssSucf")
    private WebElement typeSelector;

    @FindBy(css = "#NotFQb > select")
    private WebElement convertedTypeSelector;

    @FindBy(css = "#HG5Seb > input")
    private WebElement unitToConvertField;

    @FindBy(css = "#NotFQb > input")
    private WebElement convertedUnitField;


    public void selectConversionTypeFromDropDown(String selection) {
        new Select(typeOfConversionDropDown).selectByValue(selection);
    }

    public void selectLengthUnitFromDropDown(String lengthUnit) {
        new Select(typeSelector).selectByVisibleText(lengthUnit);
    }

    public void selectConvertedLengthUnitFromDropDown(String lengthUnit) {
        new Select(convertedTypeSelector).selectByVisibleText(lengthUnit);
    }

    public void enterUnitValueToConvert(String unitValue) {
        unitToConvertField.clear();
        unitToConvertField.sendKeys(unitValue);
    }

    public void assertConvertedUnitValue(String unitValue) {
        Assert.assertThat(convertedUnitField.getAttribute("value"), is(unitValue));
    }
}
