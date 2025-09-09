package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C16_ChromeOptions {

    @Test
    void chromeOptionsTest() {
        //    https://www.example.com" and verify the title contains "Example".
        driver.get("https://www.example.com");
        assert  driver.getTitle().contains("Example");

    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize window on startup
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--incognito"); // Run in incognito mode
        options.addArguments("disable-infobars"); // Disable info-bars

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html" );
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
