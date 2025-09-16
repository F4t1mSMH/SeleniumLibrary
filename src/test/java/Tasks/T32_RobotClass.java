package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T32_RobotClass extends TestBase {
    @Test
    void robotTest() throws AWTException {

//         * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
        driver.get("https://the-internet.herokuapp.com/login");
//         * Click into the username field.
//         * Type the username using sendKeys.
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
//         * Use the Robot class to:
        Robot robot = new Robot();
//         * Press Tab → go to password field.
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        WebElement pass = driver.findElement(By.id("password"));
//         * Type the password using sendKeys.
        pass.sendKeys("SuperSecretPassword!");
//         * Press Enter → submit the form.
        WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//         * Verify login success or error message.
        String resultText = driver.findElement(By.id("flash-messages")).getText();
        System.out.println("login text: " + resultText);
        Assertions.assertEquals("You logged into a secure area!", resultText);


    }
}
