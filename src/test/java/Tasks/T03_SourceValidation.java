package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03_SourceValidation {
    /*
    Task 2: Page Source Validation
    Setup:
    Use @BeforeEach to open Chrome and maximize.
    Test 1:
    Navigate to https://www.selenium.dev/.
    Verify that the page source contains the word "WebDriver".
    Test 2:
    Navigate to https://www.python.org/.
    Assert the page source contains "Python".
    Teardown:
    Close the browser with @AfterEach.
         */
    static WebDriver driver;

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    void goToLink() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        if (pageSource.contains("WebDriver")) {
            System.out.println("Page source contains WebDriver");
        } else {
            System.out.println("Page source does not contain WebDriver");
        }
    }
    @Test
    void goToPython () throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.python.org/");
        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        if (pageSource.contains("Python")) {
            System.out.println("Page source contains Python");
        } else {
            System.out.println("Page source does not contain Python");
        }

    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}