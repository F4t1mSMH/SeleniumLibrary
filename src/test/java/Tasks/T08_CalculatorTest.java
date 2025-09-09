package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T08_CalculatorTest {

    @Test
    public void testCalculator() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Navigate to calculator
        driver.findElement(By.linkText("Simple Calculator")).click();

        // Enter numbers
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");

        // Calculate
        driver.findElement(By.id("calculate")).click();

        // Get result
        WebElement result = driver.findElement(By.id("answer"));
        System.out.println("Result: " + result.getAttribute("value"));
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
