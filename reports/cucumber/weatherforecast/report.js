$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SeleniumGoogle/features/weatherForecast.feature");
formatter.feature({
  "line": 1,
  "name": "Weather forecast",
  "description": "Tests the weather forecast functionality",
  "id": "weather-forecast",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1616796004,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Searching for the weather in MK should return the required information",
  "description": "",
  "id": "weather-forecast;searching-for-the-weather-in-mk-should-return-the-required-information",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Forecast_Test"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am on the Google homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I enter the term \"Weather Milton Keynes\" and search",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the weather forecast for my location should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.navigateToHomePage()"
});
formatter.result({
  "duration": 30804119279,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Weather Milton Keynes",
      "offset": 18
    }
  ],
  "location": "CommonSteps.searchForWeather(String)"
});
formatter.result({
  "duration": 218844652,
  "status": "passed"
});
formatter.match({
  "location": "SearchResultSteps.weatherForLocationShouldAppear()"
});
formatter.result({
  "duration": 14052631,
  "error_message": "org.openqa.selenium.NoSuchElementException: No such element (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027DESKTOP-V48SCO0\u0027, ip: \u0027192.168.0.25\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711\u0027\nDriver info: org.openqa.selenium.edge.EdgeDriver\nCapabilities {InPrivate: false, acceptSslCerts: true, applicationCacheEnabled: true, browserName: MicrosoftEdge, browserVersion: 42.17134.1.0, javascriptEnabled: true, locationContextEnabled: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, platformVersion: 10, takesElementScreenshot: true, takesScreenshot: true, webStorageEnabled: true}\nSession ID: 4ABE06BD-7A11-4130-AAB0-B5F6E0B178ED\n*** Element info: {Using\u003did, value\u003dwob_dcp}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:319)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:365)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:311)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy21.getText(Unknown Source)\r\n\tat SeleniumGoogle.pages.searchResults.Weather.assertWeatherForecast(Weather.java:36)\r\n\tat SeleniumGoogle.pages.searchResults.Weather.assertWeather(Weather.java:29)\r\n\tat SeleniumGoogle.steps.SearchResultSteps.weatherForLocationShouldAppear(SearchResultSteps.java:21)\r\n\tat ✽.Then the weather forecast for my location should appear(SeleniumGoogle/features/weatherForecast.feature:8)\r\n",
  "status": "failed"
});
formatter.write("Scenario was run using browser: edge");
formatter.embedding("image/png", "embedded0.png");
formatter.write("URL at test failure: https://www.google.com/search?source\u003dhp\u0026ei\u003d-BBJXIzCLqS_lwSKi6yIDg\u0026q\u003dWeather+Milton+Keynes\u0026btnK\u003dGoogle+Search\u0026oq\u003dWeather+Milton+Keynes\u0026gs_l\u003dpsy-ab.3...29877.29904..29916...0.0..0.0.0.......0....1..gws-wiz.....0.");
formatter.after({
  "duration": 1029828624,
  "status": "passed"
});
});