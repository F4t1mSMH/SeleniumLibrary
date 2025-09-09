package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class T10_CSSPracticeTest {

    WebDriver driver;

    @Test
    public void testDynamicElements() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        createButtons(100);
        deleteButtonsAndValidate(50);

        driver.quit();
    }

    public void createButtons(int count) {
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for(int i = 0; i < count; i++) {
            addButton.click();
        }
    }

    public void deleteButtonsAndValidate(int deleteCount) {
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int initialCount = deleteButtons.size();

        for(int i = 0; i < deleteCount; i++) {
            deleteButtons.get(i).click();
        }

        // Validate remaining buttons
        List<WebElement> remainingButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assertions.assertEquals(initialCount - deleteCount, remainingButtons.size());

        System.out.println("Successfully deleted " + deleteCount + " buttons. Remaining: " + remainingButtons.size());
    }

}
