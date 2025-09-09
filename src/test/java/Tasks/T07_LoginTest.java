package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//  Navigate to Heroku login
//  Enter test email
//  Enter test password
//  Click login button
// Check for error message
//  Print appropriate success/failure message

public class T07_LoginTest {
    @Test
    public void testInvalidLogin() {
        driver.get("https://id.heroku.com/login");

        // Enter credentials
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.name("commit")).click();

        // Check for error message

         WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'There was a problem')]"));
            if(errorMessage.isDisplayed()) {
                System.out.println("Registration Failed");
            }
         else {
            System.out.println("Registered");

         }
    }
WebDriver driver;
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
