package stepdefinitions;

import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class Hooks {

    private static ExtentReports extent = ExtentManager.getInstance();

    @Before
    public void setUp(Scenario scenario) {
        if (TestBase.getDriver() == null) {
            TestBase.setUp();
        }
        // create an extent test for this scenario
        ExtentTest test = extent.createTest(scenario.getName());
        ExtentTestManager.setTest(test);
    }

    @After
    public void tearDown(Scenario scenario) {
        ExtentTest test = ExtentTestManager.getTest();
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            String screenshotPath = new TestBase().captureScreenshot(scenarioName);
            if (screenshotPath != null && !screenshotPath.isEmpty()) {
                try {
                    test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } catch (Exception e) {
                    test.fail("Test Failed - screenshot attach failed: " + e.getMessage());
                }
            } else {
                test.fail("Test Failed - no screenshot available");
            }
        } else {
            if (test != null) test.log(Status.PASS, "Scenario passed");
        }

        extent.flush();
        ExtentTestManager.removeTest();

        TestBase.tearDown();
    }
}
