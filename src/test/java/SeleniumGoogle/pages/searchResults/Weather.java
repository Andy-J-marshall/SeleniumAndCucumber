package SeleniumGoogle.pages.searchResults;

import SeleniumGoogle.pages.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;

import static SeleniumGoogle.steps.ExecutionHooks.getTestState;
import static org.hamcrest.CoreMatchers.*;

public class Weather extends Base {

    @FindBy(id = "wob_dcp")
    private WebElement weatherForecast;

    @FindBy(id = "wob_loc")
    private WebElement weatherLocation;

    @FindBy(id = "wob_dts")
    private WebElement weatherDate;

    @FindBy(id = "wob_tm")
    private WebElement temp;

    public void assertWeather() {
        assertWeatherForecast();
        assertWeatherDate();
        assertWeatherLocation();
        assertTemp();
    }

    private void assertWeatherForecast() {
        Assert.assertThat(weatherForecast.getText(), is(notNullValue()));
    }

    private void assertTemp() {
        Assert.assertThat(Integer.parseInt(temp.getText()), is(instanceOf(Integer.class)));
    }

    private void assertWeatherLocation() {
        String[] searchTermSplit = getTestState().searchTerm.split(" ", 2);
        String location = searchTermSplit[1];
        Assert.assertThat("Weather forecast location is not as expected", weatherLocation.getText(), containsString(location));
    }

    private void assertWeatherDate() {
        Date now = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
        System.out.println(simpleDateformat.format(now));
        Assert.assertThat("Weather forecast date is not as expected", weatherDate.getText(), containsString(simpleDateformat.format(now)));
    }
}
