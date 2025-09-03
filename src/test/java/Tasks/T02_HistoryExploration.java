package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T02_HistoryExploration {
    /*
Task 1: Browser History Exploration
Setup:
Use @BeforeEach to launch Chrome and maximize.
Test 1:
Navigate to https://www.wikipedia.org/.
Navigate to https://www.google.com/.
Navigate back and forward multiple times, asserting the correct title at each step.
Test 2:
Use driver.navigate().refresh() on Google and assert the title still contains "Google".
Teardown:
Use @AfterEach to close the browser.
     */

        static WebDriver driver;
        @BeforeEach
        void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        void goToLink() throws InterruptedException {
            driver.get("https://www.wikipedia.org/");
            Thread.sleep(3000);
            String wikipedia = driver.getTitle();
            assertEquals("Wikipedia", wikipedia, "Title match!");
        }

        @Test
        void navigateGoogle() throws InterruptedException {
            driver.get("https://www.google.com/");
            Thread.sleep(3000);
            String google = driver.getTitle();
            assertEquals("Google", google, "Title match!");
        }

        @Test
        void navigateYouTube() throws InterruptedException {
            driver.get("https://www.wikipedia.org/");
            Thread.sleep(1000);
            driver.navigate().to("https://www.google.com/");
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().forward();
        }

        @Test
        void RefreshGoogle() {
            driver.get("https://www.google.com/");
            driver.navigate().refresh();
            assertTrue(driver.getTitle().contains("Google"));
        }

        @AfterEach
        void closeBrowser() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }
