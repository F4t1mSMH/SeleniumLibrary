package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Go to https://claruswaysda.github.io/Dropdowns.html
In 1. Traditional Dropdown select 'Ford'
In 2. Multi-Select Dropdown select 'Mercedes'
In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
*/
public class T31_DropdownHandling extends utilities.TestBase {
    @Test
        void dropdownTest() {
        driver.get("https://claruswaysda.github.io/Dropdowns.html");
        Select Trad = new Select(driver.findElement(By.id("carSelect")));
        Trad.selectByVisibleText("Ford");
        Select Multi = new Select(driver.findElement(By.id("multiCarSelect")));
        Multi.selectByValue("Mercedes");

        WebElement custom = driver.findElement(By.id("customDropdown"));
        custom.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bmwLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'customDropdown')]//a[text()='BMW']")));
        bmwLink.click();



        WebElement Tesla = driver.findElement(By.id("staticInput"));
        Tesla.sendKeys("Tesla Model 3");
        Tesla.click();

        WebElement Toyota = driver.findElement(By.id("dynamicInput"));
        Toyota.sendKeys("Toyota");
        Toyota.click();

        }
}
