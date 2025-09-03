package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_TitleTest {
    public static void main(String[] args) throws InterruptedException {
// Launch Chrome browser
        WebDriver driver = new ChromeDriver();
// Open URL of Website
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
// Maximize Window
        driver.manage().window().maximize();
// Get Title of current Page
        String title = driver.getTitle();
        System.out.println("title: " + title);
// Validate/Compare Page Title

        if (title.equals("Contact List App")) {
            System.out.println("Test passed!");
        } else {
            System.err.println("Test failed!");
        }

// Close Browser
        Thread.sleep(3000);
        driver.quit();
    }
}
