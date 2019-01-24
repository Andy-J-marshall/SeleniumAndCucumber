package SeleniumGoogle.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public void driverSetUp() {
        WebDriver driver = null;
        switch (getBrowserName()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getPropertyFile().getProperty("CHROME_DRIVER_INSTALL_LOCATION"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getPropertyFile().getProperty("FIREFOX_DRIVER_INSTALL_LOCATION"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", getPropertyFile().getProperty("MICROSOFT_DRIVER_INSTALL_LOCATION"));
                driver = new EdgeDriver();
                break;
            default:
                Assert.fail("Browser not supported");
        }
        setDriver(driver);
    }

    public String getBrowserName() {
        return System.getProperty("browser", "chrome").toLowerCase();
    }

    private Properties getPropertyFile() {
        Properties properties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream("src/test/resources/SeleniumGoogle/LocalEnvConfig.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void cleanUpBrowserAfterScenario() {
        getDriver().close();
        getDriver().quit();
        deleteDriver();
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    private void deleteDriver() {
        driverThreadLocal.remove();
    }
}
