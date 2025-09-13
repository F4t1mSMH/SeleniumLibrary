package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

/*
 Go to https://claruswaysda.github.io/dragAndDrop.html
 Drag the items in their right places
 Assert the success message
 */
public class T29_DragDropPractice extends utilities.TestBase {
    @Test
    void dragDropTest() {
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");
        Actions action = new Actions(driver);
        action
                .dragAndDrop(driver.findElement(By.id("piece3")), driver.findElement(By.id("slot3")))
                .dragAndDrop(driver.findElement(By.id("piece2")), driver.findElement(By.id("slot2")))
                .dragAndDrop(driver.findElement(By.id("piece1")), driver.findElement(By.id("slot1")))

                .perform();
                assert driver.findElement(By.id("celebrate")).isDisplayed();
    }
}
