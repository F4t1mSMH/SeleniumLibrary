package Tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

//Launch browser
//Open https://demoqa.com/select-menu
//Select Old Style Select Menu using element id
//Print all dropdown options
//Select 'Purple' using index
//Select 'Magenta' using visible text
//Select an option using value
//Close browser
public class T19_OldSelectMenu {
    @Test
    void oldSelectMenuTest() throws InterruptedException {
            Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
            select.getOptions().forEach(t -> System.out.println(t.getText()));
            select.selectByIndex(4);
            Thread.sleep(3000);
            select.selectByVisibleText("Magenta");
            Thread.sleep(3000);
            select.selectByValue("3");


        }
    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//        }
}
