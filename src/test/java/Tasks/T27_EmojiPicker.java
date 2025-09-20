package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

/*
 Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
 1. Maximize the website
 2. Click on the second emoji
 3. Click on all second emoji items
 4. Return to the parent iframe
 5. Fill out the form and press the apply button
 */
public class T27_EmojiPicker extends TestBase {
    @Test
    void emojiTest() {
        // Step 1: Maximize the website and navigate
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.manage().window().maximize();

        // Switch to the iframe by its name or ID
        driver.switchTo().frame("emoji-iframe");

        // Step 2: Click on the second emoji category
        WebElement secondEmojiCategory = driver.findElement(By.xpath("(//div[@class='emoji-icon-container'])[2]"));
        secondEmojiCategory.click();

        // Step 3: Click on all emojis within the second category
        List<WebElement> allEmojis = driver.findElements(By.xpath("//div[@id='emoojis']//div[@class='emoji-icon-container']"));
        for (WebElement emoji : allEmojis) {
            emoji.click();
        }

        // Step 4: Return to the parent frame
        driver.switchTo().defaultContent();
        // Step 5: Fill out the form and press the apply button
        List<WebElement> inputFields = driver.findElements(By.xpath("//input[@class='form-control']"));
        String[] textToEnter = {"This is the first text", "This is the second text", "This is the third text", "This is the fourth text", "This is the fifth text", "This is the sixth text", "This is the seventh text", "This is the eighth text", "This is the ninth text", "This is the tenth text"};

        for (int i = 0; i < inputFields.size(); i++) {
            inputFields.get(i).sendKeys(textToEnter[i]);
        }

        WebElement applyButton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        applyButton.click();
    }
}