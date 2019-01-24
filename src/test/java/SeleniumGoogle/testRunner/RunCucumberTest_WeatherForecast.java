package SeleniumGoogle.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        , glue = {"SeleniumGoogle/steps"}
        , format = {"pretty", "html:reports/cucumber/weatherforecast"}
        , monochrome = true
        , tags = {"@Forecast_Test"})
public class RunCucumberTest_WeatherForecast {}
