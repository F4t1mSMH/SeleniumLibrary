package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

//Go to https://the-internet.herokuapp.com/dropdown
//Create selectByIndexTest method - Select Option 1 using index
//Create selectByValueTest method - Select Option 2 by value
//Create selectByVisibleTextTest method - Select Option 1 by visible text
//Create printAllTest method - Print all dropdown values
//Verify dropdown has Option 2 text
//Create printFirstSelectedOptionTest - Print first selected option
//Verify dropdown size equals 3 elements

public class T18_BasicDropDown {
    @Test
    void testBasicDropDown() {
        Select seIndex = new Select(driver.findElement(By.xpath("//*[@id='dropdown']" )));
        seIndex.selectByIndex(1);
        Select seValue = new Select(driver.findElement(By.xpath("//*[@id='dropdown']" )));
        seValue.selectByValue("2" );
        Select seText = new Select(driver.findElement(By.xpath("//*[@id='dropdown']" )));
        seText.selectByVisibleText("Option 1" );
        Select seAll = new Select(driver.findElement(By.xpath("//*[@id='dropdown']" )));
        seAll.getOptions().forEach(t -> System.out.println(t.getText()));
        Select seFirst = new Select(driver.findElement(By.xpath("//*[@id='dropdown']" )));
        System.out.println(seFirst.getFirstSelectedOption().getText());
        int size = seFirst.getOptions().size();
        if (size == 3) {
            System.out.println("Dropdown size equals 3 elements. Test Passed." );
        } else {
            System.out.println("Dropdown size does not equal 3 elements. Test Failed." );
        }
    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown" );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}