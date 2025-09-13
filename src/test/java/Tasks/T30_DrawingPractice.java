package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 Go to https://claruswaysda.github.io/Draw.html
 Draw a triangle
 Reset
 */
public class T30_DrawingPractice extends utilities.TestBase {
    @org.junit.jupiter.api.Test
    void drawingTest() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/Draw.html");
        //Draw a triangle
        WebElement Canva = driver.findElement(By.id("myCanvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Canva, -50, 50)
                .clickAndHold()
                .moveByOffset(180, 0)
                .moveByOffset(-90, -116)
                .moveByOffset(-90, 116)
                .release()
                .perform();
        Thread.sleep(3000);
        //Reset
        driver.findElement(By.id("resetButton")).click();
        Thread.sleep(3000);
    }
}
