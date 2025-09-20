package Tasks;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBaseWithActionHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T38_SwagLab extends TestBaseWithActionHelper {

    @Test
    void swagLabTest() throws InterruptedException, IOException {
        String url = "https://www.saucedemo.com/v1/index.html";
        driver.get(url);
        logger.info("Navigated to URL");
        assertEquals(url, driver.getCurrentUrl());
        test.log(Status.PASS, "URL navigated successfully.");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce", Keys.ENTER);
        logger.info("Logged in as standard user.");
        test.log(Status.INFO, "Entered credentials and clicked login.");

        WebElement productPageTitle = driver.findElement(By.xpath("//div[@class='product_label']"));
        assertTrue(productPageTitle.isDisplayed(), "Login failed. Product page title is not displayed.");
        logger.info("Login successful. Verified presence of product page title.");
        test.log(Status.PASS, "Login successful.");

        WebElement dropDown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (low to high)");
        logger.info("Sorted products by price from low to high.");
        test.log(Status.INFO, "Sorted products by price from low to high.");
        Thread.sleep(1000);

        List<WebElement> productItems = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        WebElement lowest = productItems.get(0);
        takeScreenshotOfElement(driver, lowest);
        test.log(Status.INFO, "Lowest-priced product screenshot captured.");

        select.selectByVisibleText("Price (high to low)");
        Thread.sleep(1000);
        productItems = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        WebElement highest = productItems.get(0);
        takeScreenshotOfElement(driver, highest);
        test.log(Status.INFO, "Highest-priced product screenshot captured.");
        logger.info("Captured screenshots of lowest and highest priced products.");

        driver.findElement(By.className("bm-burger-button")).click();
        Thread.sleep(500);
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();
        logger.info("Logged out of the application.");
        test.log(Status.INFO, "Logged out successfully.");

        WebElement usernameFieldAfterLogout = driver.findElement(By.id("user-name"));
        assertTrue(usernameFieldAfterLogout.isDisplayed(), "Logout failed. Username field is not displayed.");
        logger.info("Logout successful. Verified return to login page.");
        test.log(Status.PASS, "Logout successful. Application returned to the login page.");
    }
    }

