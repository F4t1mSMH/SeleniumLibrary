package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class T33_JSTest extends TestBase {
    @Test
    void jsTest() throws InterruptedException {
        // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement onBlurButton = driver.findElement(By.id("onblur"));
        js.executeScript("arguments[0].click();", onBlurButton);
        Thread.sleep(1000); // Wait for the event to fire
        assert driver.findElement(By.id("onblur_event")).isDisplayed();

        WebElement onClickButton = driver.findElement(By.id("onclick"));
        js.executeScript("arguments[0].click();", onClickButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onclick_event")).isDisplayed();

        WebElement onContextMenuButton = driver.findElement(By.id("oncontextmenu"));
        js.executeScript("arguments[0].click();", onContextMenuButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("oncontextmenu_event")).isDisplayed();

        WebElement onDoubleClickButton = driver.findElement(By.id("ondoubleclick"));
        js.executeScript("arguments[0].click();", onDoubleClickButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("ondoubleclick_event")).isDisplayed();

        WebElement onFocusButton = driver.findElement(By.id("onfocus"));
        js.executeScript("arguments[0].click();", onFocusButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onfocus_event")).isDisplayed();

        // Click the 'On Key Down' button and verify
        WebElement onKeyDownButton = driver.findElement(By.id("onkeydown"));
        js.executeScript("arguments[0].click();", onKeyDownButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onkeydown_event")).isDisplayed();

        WebElement onKeyUpButton = driver.findElement(By.id("onkeyup"));
        js.executeScript("arguments[0].click();", onKeyUpButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onkeyup_event")).isDisplayed();
        assert driver.findElement(By.id("onload_event")).isDisplayed();

        WebElement onMouseDownButton = driver.findElement(By.id("onmousedown"));
        js.executeScript("arguments[0].click();", onMouseDownButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onmousedown_event")).isDisplayed();

        WebElement onMouseEnterButton = driver.findElement(By.id("onmouseenter"));
        js.executeScript("arguments[0].click();", onMouseEnterButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onmouseenter_event")).isDisplayed();

        WebElement onMouseLeaveButton = driver.findElement(By.id("onmouseleave"));
        js.executeScript("arguments[0].click();", onMouseLeaveButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onmouseleave_event")).isDisplayed();

        WebElement onMouseMoveButton = driver.findElement(By.id("onmousemove"));
        js.executeScript("arguments[0].click();", onMouseMoveButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onmousemove_event")).isDisplayed();


        WebElement onMouseOutButton = driver.findElement(By.id("onmouseout"));
        js.executeScript("arguments[0].click();", onMouseOutButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onmouseout_event")).isDisplayed();


        WebElement onMouseOverButton = driver.findElement(By.id("onmouseover"));
        js.executeScript("arguments[0].click();", onMouseOverButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onmouseover_event")).isDisplayed();


        WebElement onPressButton = driver.findElement(By.id("onpress"));
        js.executeScript("arguments[0].click();", onPressButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onpress_event")).isDisplayed();


        WebElement onScrollButton = driver.findElement(By.id("onscroll"));
        js.executeScript("arguments[0].click();", onScrollButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onscroll_event")).isDisplayed();


        WebElement onSubmitButton = driver.findElement(By.id("onsubmit"));
        js.executeScript("arguments[0].click();", onSubmitButton);
        Thread.sleep(1000);
        assert driver.findElement(By.id("onsubmit_event")).isDisplayed();
    }
}
