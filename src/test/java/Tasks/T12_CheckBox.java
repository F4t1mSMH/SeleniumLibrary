package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T12_CheckBox {
//    Go to "https://the-internet.herokuapp.com/checkboxes". Write a method that:
//    Checks the current state of both checkboxes
//    Ensures both checkboxes are selected (click only if not already selected)
//    Verify both checkboxes are checked after the operations
//    Print the status of each checkbox to console

    @Test
        void checkBox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes" );
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']" ));
        for (WebElement checkBox : checkBoxList) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
            if (!checkBox.isSelected()) {
                Assertions.fail();
            }
        }
        Assertions.assertTrue(true);
        for (WebElement checkBox : checkBoxList) {
            System.out.println("Checkbox is selected: " + checkBox.isSelected());
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
