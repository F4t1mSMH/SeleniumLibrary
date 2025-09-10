package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

//Launch browser
//Open https://demoqa.com/select-menu
//Select Standard Multi-Select using element id
//Verify element is multi-select
//Select 'Opel' using index, then deselect using index
//Select 'Saab' using value, then deselect using value
//Deselect all options
//Close browser
public class T20_MultiSelectOP {
    @Test
    void multiSelectTest() throws InterruptedException {
        //Select Standard Multi-Select using element id
        Select seMulti = new Select(driver.findElement(By.id("cars" )));
        System.out.println(seMulti.isMultiple());
        Select seIndex = new Select(driver.findElement(By.id("cars" )));
        seIndex.selectByIndex(2);
        Thread.sleep(3000);
        seIndex.deselectByIndex(2);
        Select seValue = new Select(driver.findElement(By.id("cars" )));
        seValue.selectByValue("saab" );
        Thread.sleep(3000);
        seValue.deselectByValue("saab" );
        Thread.sleep(3000);
        seValue.deselectAll();

    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu" );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}