package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T09_XPathComparisonTest {
    WebDriver driver;

    @Test
    public void testXPathComparison() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Absolute XPath examples (brittle)
        String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input";
        String absolutePasswordXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input";

        // Relative XPath examples (robust)
        String relativeUsernameXPath = "//input[@name='username']";
        String relativePasswordXPath = "//input[@name='password']";
        String relativeLoginXPath = "//button[@type='submit']";

        // Test both approaches
        WebElement usernameAbsolute = driver.findElement(By.xpath(absoluteUsernameXPath));
        WebElement usernameRelative = driver.findElement(By.xpath(relativeUsernameXPath));

        Assertions.assertTrue(usernameAbsolute.isDisplayed());
        Assertions.assertTrue(usernameRelative.isDisplayed());

        driver.quit();
    }

}
