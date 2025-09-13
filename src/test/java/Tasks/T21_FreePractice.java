package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Practice on https://demo.guru99.com/test/newtours/register.php
//Apply dropdown and form handling techniques
public class T21_FreePractice {
    @Test
        void freePracticeTest() {
        driver.findElement(By.name("firstName")).sendKeys("Leon");
        driver.findElement(By.name("lastName")).sendKeys("Kennedy");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("userName")).sendKeys("leon123");
        driver.findElement(By.name("address1")).sendKeys("123 Main St");
        driver.findElement(By.name("city")).sendKeys("Raccoon City");
        driver.findElement(By.name("state")).sendKeys("State");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        Select select = new Select(driver.findElement(By.name("country")));
        select.selectByVisibleText("UNITED STATES");
        driver.findElement(By.name("email")).sendKeys("leonKennedy@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.name("confirmPassword")).sendKeys("Password123");

        //Handling alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cb-close']")));
        popup.click();
        System.out.println("Pop-up modal closed successfully.");
        driver.findElement(By.name("submit")).click();

        System.out.println("Registration Successful! 🎉🎉🎉");

    }

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
       driver.quit();
    }
}
