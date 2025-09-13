package Tasks;
/*
 Go to URL: http://demo.guru99.com/test/delete_customer.php
 Delete customer ID: 123
 Handle 2 alerts that appear
 */

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class T23_CustomerDeletionAlerts extends utilities.TestBase {
@Test
        void deletionAlertTest() throws InterruptedException {
    driver.get("http://demo.guru99.com/test/delete_customer.php");
    driver.findElement(By.name("cusid")).sendKeys("123");
    driver.findElement(By.name("submit")).click();
    Thread.sleep(2000);
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().accept();
    Thread.sleep(2000);
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().accept();
}
}
