package SeleniumGoogle.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        , glue = {"SeleniumGoogle/steps"}
        , monochrome = true
        , format = {"pretty", "html:reports/cucumber/unitconversion"}
        , tags = {"@Conversion_Test"})
public class RunCucumberTest_UnitConversion {}
