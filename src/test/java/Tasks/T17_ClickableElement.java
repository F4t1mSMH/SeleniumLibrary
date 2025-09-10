package Tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

//Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
//Click "click me" button
//Verify "Event Triggered" appears

public class T17_ClickableElement {
    @Test
    void testClickableElement() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        WebElement clickMeButton = driver.findElement(By.xpath("//*[@class='styled-click-button showgrow grown']"));
        clickMeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement eventTriggered = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='styled-click-button-triggered']")));
        WebElement eventTriggered = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("growbuttonstatus")));
        Assertions.assertTrue(eventTriggered.getText().contains("Event Triggered"));


    }


    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();}
}
