package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.io.File;

public class T34_UserRegistrationCapture extends TestBase {
    @Test
    void captureTest() throws AWTException {

// Go to https://claruswaysda.github.io/homepage.html
        driver.get("https://claruswaysda.github.io/homepage.html");
// Register a user
        WebElement userIcon = driver.findElement(By.id("userIcon"));
        userIcon.click();
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        driver.findElement(By.name("ssn")).sendKeys("123-45-6789");
        driver.findElement(By.name("first-name")).sendKeys("Leon");
        driver.findElement(By.name("last-name")).sendKeys("Kennedy");
        driver.findElement(By.name("address")).sendKeys("Raccoon City");
        driver.findElement(By.name("phone")).sendKeys("555-123-4567");
        driver.findElement(By.name("username")).sendKeys("leonkennedy");
        driver.findElement(By.name("email")).sendKeys("leonkennedy@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Resident123");
        driver.findElement(By.name("confirm-password")).sendKeys("Resident123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //click login button
        driver.findElement(By.xpath("//*[@class='login-button']")).click();
// Sign in with the registered user
        driver.findElement(By.id("username")).sendKeys("leonkennedy");
        driver.findElement(By.id("password")).sendKeys("Resident123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();


// Take all pages' screenshots
        takeFullPageScreenshot();
// Take 'Celebrate Login' button's screenshot.
        WebElement celebrateLogin = driver.findElement(By.id("clickMeButton"));
        File elementScreenshot = celebrateLogin.getScreenshotAs(OutputType.FILE);
// Capture a screenshot of the page with confetti.

        takeFullPageScreenshot();


    }
}
