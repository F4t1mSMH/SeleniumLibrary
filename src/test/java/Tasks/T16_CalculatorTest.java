package Tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Go to https://testpages.eviltester.com/styled/calculator
//Type any number in first and second input
//Click Calculate for each operation
//Get and verify results for all operations
public class T16_CalculatorTest {
    WebDriver driver;

    @Test
    void calculatorTest() {
        Faker faker = new Faker();
        driver.findElement(By.id("number1" )).sendKeys(faker.number().numberBetween(1, 100) + "" );
        driver.findElement(By.id("number2" )).sendKeys(faker.number().numberBetween(1, 100) + "" );
        driver.findElement(By.id("calculate" )).click();
        WebElement result = driver.findElement(By.id("answer" ));
        System.out.println("Result: " + result.getAttribute("value" ));

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/calculator" );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}