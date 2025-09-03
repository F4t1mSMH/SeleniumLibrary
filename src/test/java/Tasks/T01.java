package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T01 {
        public static void main(String[] args) throws InterruptedException {
            // Invoke FireFox Driver
            WebDriver driver = new FirefoxDriver();

// Go to https://www.youtube.com/
            driver.get("https://www.youtube.com/");

// Maximize the window
            driver.manage().window().maximize();
            Thread.sleep(3000);

// Verify the page title contains the word video.
            String title = driver.getTitle();
            if (title.equals("video")) {
                System.out.println("Title contains the word 'video'. Test passed!");
            } else {
                System.err.println("Title does not contain the word 'video'. Test failed!");
            }

// Minimize the window
            driver.manage().window().minimize();
            Thread.sleep(3000);

// Verify the page title contains the word video.
            title = driver.getTitle();
            if (title.equals("video")) {
                System.out.println("Title contains the word 'video'. Test passed!");
            } else {
                System.err.println("Title does not contain the word 'video'. Test failed!");
            }

// Make the page fullscreen
            driver.manage().window().fullscreen();
            Thread.sleep(5000);

// Close the driver.
            driver.quit();
        }
    }


