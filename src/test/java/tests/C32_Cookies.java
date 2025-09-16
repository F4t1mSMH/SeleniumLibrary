package tests;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C32_Cookies extends TestBase {
    @Test
    void cookiesTest(){
// Go to https://claruswaysda.github.io/CookiesWait.html
        driver.get("https://claruswaysda.github.io/CookiesWait.html");
// Accept the alert if it is present
        try {
            driver.switchTo().alert().accept();
            System.out.println("found an alert!");
        }catch (Exception ignored){
            System.out.println("did not find an alert!");
        }
// Print the cookies
        System.out.println(driver.manage().getCookies());
// Delete all cookies and assert
        driver.manage().deleteAllCookies();
        System.out.println( driver.manage().getCookies());
        assertEquals(0, driver.manage().getCookies().size());
    }
}
