package Tasks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T05_MultipleNavigationVerification {
    /*
Task 4: Multiple Navigation and Verification
Setup:
Launch Chrome and maximize in @BeforeEach.
Test 1:
Navigate Google → YouTube → LinkedIn.
Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
Test 2:
Navigate back twice and assert the URL of Google.
Navigate forward twice and assert URL of LinkedIn.
Teardown:
Use @AfterAll to quit the browser.

  */
    static WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    void navigateAndVerify() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        String googleTitle = driver.getTitle();
        if (googleTitle.contains("Google")) {
            System.out.println("Google title verification passed");
        } else {
            System.out.println("Google title verification failed");
        }
        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);
        String youtubeTitle = driver.getTitle();
        if (youtubeTitle.contains("YouTube")) {
            System.out.println("YouTube title verification passed");
        } else {
            System.out.println("YouTube title verification failed");
        }
        driver.get("https://www.linkedin.com/");
        Thread.sleep(2000);
        String linkedinTitle = driver.getTitle();
        if (linkedinTitle.contains("LinkedIn")) {
            System.out.println("LinkedIn title verification passed");
        } else {
            System.out.println("LinkedIn title verification failed");
        }
    }
    @Test
    void navigateBackAndForward() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);
        driver.get("https://www.linkedin.com/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.google.com/")) {
            System.out.println("Back navigation to Google URL verification passed");
        } else {
            System.out.println("Back navigation to Google URL verification failed");
        }
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.linkedin.com/")) {
            System.out.println("Forward navigation to LinkedIn URL verification passed");
        } else {
            System.out.println("Forward navigation to LinkedIn URL verification failed");
        }
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
