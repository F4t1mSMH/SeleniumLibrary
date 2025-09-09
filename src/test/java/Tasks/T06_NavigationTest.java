package Tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T06_NavigationTest {

    @Test
    public void Navigation() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println("URL after going back: " + driver.getCurrentUrl());

        driver.findElement(By.linkText("WebDriver Example Page")).click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        WebElement numberInput = driver.findElement(By.id("numberin"));
        numberInput.sendKeys("20");
        numberInput.sendKeys(Keys.ENTER);

        WebElement message = driver.findElement(By.id("message"));
       Assertions.assertTrue(message.getText().contains("two, zero"));
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
