package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
Go to URL: http://demo.guru99.com/test/guru99home/
1. Find the number of iframes on the page
2. Switch to the third iframe (JMeter Made Easy)
3. Click the link (https://www.guru99.com/live-selenium-project.html)
4. Exit the iframe and return to the main page
*/
public class T28_MultiFrames extends utilities.TestBase {
    @Test
        void multiFrameTest() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        int numOfFrames = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("Number of iframes on the page: " + numOfFrames);
        driver.switchTo().frame("a077aa5e");
        driver.switchTo().defaultContent();
        System.out.println("Returned to the main page.");

    }
}
