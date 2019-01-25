package SeleniumGoogle.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private final String USERNAME = getPropertyFile().getProperty("BROWSERSTACK_USERNAME");
    private final String AUTOMATE_KEY = getPropertyFile().getProperty("BROWSERSTACK_ACCESS_KEY");
    private final String URL = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, AUTOMATE_KEY);

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public void driverSetUp() throws MalformedURLException {
        WebDriver driver = null;
        if (getBrowserName().equalsIgnoreCase("local chrome")) {
            System.setProperty("webdriver.chrome.driver", getPropertyFile().getProperty("CHROME_DRIVER_INSTALL_LOCATION"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            driver = new ChromeDriver(chromeOptions);
        } else {
            DesiredCapabilities caps = getGlobalDesiredCapabilities();
            caps.setCapability("browser", getPropertyFile(getBrowserName()).getProperty("BROWSER"));
            caps.setCapability("os", getPropertyFile(getBrowserName()).getProperty("OS"));
            caps.setCapability("os_version", getPropertyFile(getBrowserName()).getProperty("OS_VERSION"));
            driver = new RemoteWebDriver(new URL(URL), caps);
        }
        setDriver(driver);
    }

    private DesiredCapabilities getGlobalDesiredCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("name", "Google Search tests");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("acceptSslCerts", true);
        caps.setCapability("browserstack.geoLocation", "GB");
        return caps;
    }

    public String getBrowserName() {
        return System.getProperty("browser", "local chrome");
    }

    private Properties getPropertyFile(String browserConfig) {
        Properties properties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(String.format("src/test/resources/SeleniumGoogle/configFiles/%s.properties", browserConfig));
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private Properties getPropertyFile() {
        return getPropertyFile("Config");
    }

    public void cleanUpBrowserAfterScenario() {
        getDriver().close();
        getDriver().quit();
        deleteDriver();
    }

    private void deleteDriver() {
        driverThreadLocal.remove();
    }
}
