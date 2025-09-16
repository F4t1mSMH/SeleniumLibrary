package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

/*
 Go to URL: https://the-internet.herokuapp.com/iframe
 1. Verify the bolded text contains "Editor"
 2. Locate the text box
 3. Delete the text in the text box
 4. Type "Hi everyone"
 5. Verify the text "Elemental Selenium" is displayed on the page
 */
public class T26_iFrameTextEditor extends TestBase {
    @Test
     void iFrameTest() {
        // Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Verify the bolded text contains "Editor"
        WebElement boldText = driver.findElement(By.xpath("//h3[contains(text(), 'Editor')]"));
        if (boldText.getText().contains("Editor")) {
            System.out.println("PASSED, the text is bold!");
        } else {
            System.out.println("FAILED, the text isn't bold!");
        }
        //Locate the text box
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        //Delete the text in the text box
        textBox.clear();
        //Type "Hi everyone"
        textBox.sendKeys("Hi everyone");
        //Verify the text "Elemental Selenium" is displayed on the page
        WebElement textVerify = driver.findElement(By.linkText("Elemental Selenium"));
        if (textVerify.isDisplayed()) {
            System.out.println("PASSED Elemental Selenium is displayed!");
        } else {
            System.out.println("FAILED Elemental Selenium isn't displayed!");
        }

    }
}
