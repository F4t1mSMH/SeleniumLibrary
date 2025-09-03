package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04_PageSizePosition {
    /*
Task 3: Browser Size and Position
Setup:
Open Chrome in @BeforeEach.
Test 1:
Navigate to https://www.bbc.com/.
Set browser size to 800x600 and assert the window size.
Test 2:
Move the window to position (100, 100) and assert its position.
Teardown:
Close the browser.
     */
    static WebDriver driver;
    @BeforeEach
     void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    void goToLink() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
        Thread.sleep(3000);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        System.out.println("Window size: " + size);
        if (size.getWidth() == 800 && size.getHeight() == 600) {
            System.out.println("Window size is correct");
        } else {
            System.out.println("Window size is incorrect");
        }
    }
    @Test
    void moveWindow() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
        Thread.sleep(3000);
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        org.openqa.selenium.Point position = driver.manage().window().getPosition();
        System.out.println("Window position: " + position);
        if (position.getX() == 100 && position.getY() == 100) {
            System.out.println("Window position is correct");
        } else {
            System.out.println("Window position is incorrect");
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
