package Tasks;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T14_FakerData {
//    Question: Go to "https://demoqa.com/text-box". Use Java Faker to:
//    Generate and enter a fake full name
//    Generate and enter a fake email address
//    Generate and enter a fake current address
//    Generate and enter a fake permanent address
//    Submit the form and verify the output contains the entered data
    @Test
        void fakerDataTest() {
        Faker faker = new Faker();
        //driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("userEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("permanentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("submit")).click();
    }

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
