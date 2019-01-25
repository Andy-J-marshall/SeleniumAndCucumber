package SeleniumGoogle.steps;

import SeleniumGoogle.pages.searchResults.Translate;
import SeleniumGoogle.pages.searchResults.UnitConversion;
import SeleniumGoogle.pages.searchResults.Weather;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static SeleniumGoogle.utils.DriverFactory.getDriver;

public class SearchResultSteps {
    private WebDriver driver = getDriver();
    private Weather weather = PageFactory.initElements(driver, Weather.class);
    private Translate translate = PageFactory.initElements(driver, Translate.class);
    private UnitConversion unitConversion = PageFactory.initElements(driver, UnitConversion.class);

    @Then("^the weather forecast for my location should appear$")
    public void weatherForLocationShouldAppear() {
        weather.assertWeather();
    }

    @When("^I enter the term \"([^\"]*)\" into the translation$")
    public void enterTermToTranslate(String textToTranslate) {
        translate.enterTextIntoToTranslate(textToTranslate);
    }

    @Then("^The term \"([^\"]*)\" appears as the translated term")
    public void assertExpectedTranslation(String expectedTerm) {
        translate.assertTranslation(expectedTerm);
    }

    @When("^I convert \"([^\"]*)\" feet to miles$")
    public void convertFeetToMiles(String numberOfFeet) {
        unitConversion.selectConversionTypeFromDropDown("Length");
        unitConversion.selectLengthUnitFromDropDown("Foot");
        unitConversion.selectConvertedLengthUnitFromDropDown("Mile");
        unitConversion.enterUnitValueToConvert(numberOfFeet);
    }

    @When("^I convert \"([^\"]*)\" pounds to kilograms")
    public void convertPoundToKilogram(String numberofKilograms) {
        unitConversion.selectConversionTypeFromDropDown("Mass");
        unitConversion.selectLengthUnitFromDropDown("Pound");
        unitConversion.selectConvertedLengthUnitFromDropDown("Kilogram");
        unitConversion.enterUnitValueToConvert(numberofKilograms);
    }

    @Then("^The value \"([^\"]*)\" should appear in the conversion$")
    public void assertConvertedValue(String expectedValue) {
        unitConversion.assertConvertedUnitValue(expectedValue);
    }
}
