package SeleniumGoogle.steps;

import SeleniumGoogle.utils.DriverFactory;
import SeleniumGoogle.utils.TestState;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static SeleniumGoogle.utils.DriverFactory.getDriver;

public class ExecutionHooks {
    private static final ThreadLocal<TestState> testStateThreadLocal = new ThreadLocal<>();
    private DriverFactory driverFactory = new DriverFactory();

    @Before
    public void driverSetUp() {
        driverFactory.driverSetUp();
        setTestState(new TestState());
    }

    @After
    public void tearDown(Scenario scenario) {
        scenario.write("Scenario was run using browser: " + driverFactory.getBrowserName());
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        driverFactory.cleanUpBrowserAfterScenario();
    }

    private void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        try {
            scenario.embed(screenshot, "image/png");
        } catch (Exception e) {
            scenario.write("Screenshot failed");
        } finally {
            scenario.write("URL at test failure: " + getDriver().getCurrentUrl());
        }
    }

    public static TestState getTestState() {
        return testStateThreadLocal.get();
    }

    private void setTestState(TestState testState) {
        testStateThreadLocal.set(testState);
    }

    private void deleteTestState() {
        testStateThreadLocal.remove();
    }
}