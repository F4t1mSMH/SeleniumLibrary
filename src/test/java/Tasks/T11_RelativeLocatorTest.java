package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class T11_RelativeLocatorTest {
    WebDriver driver;

    @Test
    public void testBestBuy() {
        driver = new ChromeDriver();
        driver.get("http://www.bestbuy.com");

        // Verify title
        //Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // Use relative locator to find elements
        WebElement logo = driver.findElement(
                RelativeLocator.with(By.tagName("img")).near(By.cssSelector(".header-logo"))
        );

        WebElement canadaLink = driver.findElement(
                RelativeLocator.with(By.linkText("Canada")).above(By.cssSelector(".footer"))
        );

        Assertions.assertTrue(logo.isDisplayed());
        System.out.println("Logo test passed");

        driver.quit();
    }
}
