package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C15_JavaFaker {

    @Test
       void javaFakerTest() {
        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password(12,13,true,true,true));
        System.out.println(faker.music());
        System.out.println(faker.phoneNumber().phoneNumber());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.ancient().god());
        System.out.println(faker.book().publisher());

        driver.findElement(By.name("username")).sendKeys(faker.name().username());
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());


    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html" );
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
