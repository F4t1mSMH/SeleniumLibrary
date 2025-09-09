package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T13_RadioButton {
//    Question: Navigate to "
//    https://demoqa.com/radio-button". Create a test that:
//    #I CHANGE URL TO THE ONE IN setUp METHOD BECAUSE THE ONE IN THE QUESTION IS NOT WORKING WITH ME
//    Attempts to select each radio button (Yes, Impressive, No)
//    Prints whether each option is enabled/disabled
//    For enabled options, select them and verify selection
//    Print confirmation message for each successful selection

    @Test
    void radioButtonTest() throws InterruptedException {
        WebElement rad1 = driver.findElement(By.xpath("//input[@value='rd1']" ));
        WebElement rad2 = driver.findElement(By.xpath("//input[@value='rd2']" ));
        WebElement rad3 = driver.findElement(By.xpath("//input[@value='rd3']" ));

        System.out.println("1 Radio enabled: " + rad1.isEnabled());
        System.out.println("2 Radio enabled: " + rad2.isEnabled());
        System.out.println("3 Radio enabled: " + rad3.isEnabled());

        Thread.sleep(3000);
        rad1.click();
        assert rad1.isSelected();
        Thread.sleep(3000);
        rad2.click();
        assert rad2.isSelected();
        Thread.sleep(3000);
        rad3.click();
        assert rad3.isSelected();
//    Print confirmation message for each successful selection

    }
        WebDriver driver;

        @BeforeEach
        void setUp () {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        }

        @AfterEach
        void tearDown () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

