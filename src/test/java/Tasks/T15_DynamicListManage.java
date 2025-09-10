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
import java.util.List;

public class T15_DynamicListManage {
//    Question: Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
//    Uses Faker to generate 5 random task names
//    Adds all tasks to the todo list
//    Marks every other task as completed (strikethrough)
//    Deletes all completed tasks
//    Verifies only incomplete tasks remain

    @Test
    void dynamicListManageTest() {
    Faker faker = new Faker();
    WebElement addNewTask = driver.findElement(By.xpath("//input[@type='text']"));
    for (int i = 0; i < 5; i++) {
        String task = faker.lorem().sentence(4);
        addNewTask.sendKeys(task);
        driver.findElement(By.xpath("//i[@id='plus-icon']")).click();
    }

    // Mark every other task as completed (strikethrough)
    List<WebElement> tasks = driver.findElements(By.cssSelector("ul li"));
    for (int i = 0; i < tasks.size(); i += 2) {
        tasks.get(i).click();
    }

    }

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
