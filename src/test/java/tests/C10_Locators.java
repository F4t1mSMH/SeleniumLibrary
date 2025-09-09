package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C10_Locators {

    @Test
    void test01() {
       driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");
        WebElement p3 = driver.findElement(By.id("p3"));
        System.out.println("p3= " + p3.getText());

        String p7 = driver.findElement(By.name("pName7")).getText();
        System.out.println("p7= " + p7);

        List<WebElement> elementsCN= driver.findElements(By.className("normal"));
        elementsCN.forEach(eachElement -> System.out.println(eachElement.getText()));


    }

    WebDriver driver;

    @BeforeEach
    void setup() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
