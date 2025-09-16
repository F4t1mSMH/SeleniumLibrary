package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C31_RobotClass extends TestBase {
    @Test
    void robotTest() throws InterruptedException, AWTException {

// Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
// Click on 'Upload'
        driver.findElement(By.xpath("//label[@class='upload-btn'][1]")).click();
        Thread.sleep(3000);
// Close the opening page using 'Esc'
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        driver.findElement(By.xpath("//*[.='Submit']")).click();
        WebElement error = driver.findElement(By.id("alertBox"));
        assert  error.getText().contains("PDF");
    }
}
