package utilities;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterEach
//    void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }

    public void takeFullPageScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmssSSSSS").format(new Date());
        try {
            FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "\\test_outputs\\screenshots\\pages_screenshot" + now + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeElementsScreenshot(WebElement element) {
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmssSSSSS").format(new Date());
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\test_outputs\\screenshots\\elements_screenshot" + now + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}