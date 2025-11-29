package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public static void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public static void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
                wait = null;
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public String captureScreenshot(String scenarioName) {
        if (driver == null) {
            System.err.println("Cannot capture screenshot: driver is null");
            return "";
        }

        try {
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = scenarioName + "-" + timestamp + ".png";

            Path screenshotsDir = Paths.get("target", "screenshots");
            if (!Files.exists(screenshotsDir)) {
                Files.createDirectories(screenshotsDir);
            }

            Path out = screenshotsDir.resolve(fileName);
            Files.write(out, bytes);

            String abs = out.toAbsolutePath().toString();
            System.out.println("Screenshot saved: " + abs);
            return abs;
        } catch (IOException e) {
            System.err.println("Failed to write screenshot file: " + e.getMessage());
            return "";
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }
}

