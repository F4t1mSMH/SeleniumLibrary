package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/*
Go to URL: http://demo.automationtesting.in/Alerts.html
1. Click "Alert with OK" and click 'click the button to display an alert box'
2. Accept Alert and print alert text on console
3. Click "Alert with OK & Cancel" and click 'click the button to display a confirmation box'
4. Cancel Alert
5. Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
6. SendKeys "Bootcamp" to the prompt
7. Print and assert the message "Hello Bootcamp How are you today"
*/
public class T24_AutomationTestingAlerts extends utilities.TestBase {
    @Test
    void autoTestAlert() {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // Click "Alert with OK" and click 'click the button to display an alert box'
        driver.findElement(By.xpath("//a[.='Alert with OK ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        // 2. Accept Alert and print alert text on console
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        // 3. Click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//a[.='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        // 4. Cancel Alert
        driver.switchTo().alert().dismiss();

        // 5. Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        // 6. SendKeys "Bootcamp" to the prompt
        driver.switchTo().alert().sendKeys("Bootcamp");
        driver.switchTo().alert().accept();

        // 7. Print and assert the message "Hello Bootcamp How are you today"
        String resultText = driver.findElement(By.id("demo1")).getText();
        System.out.println("Result text: " + resultText);
        Assertions.assertEquals("Hello Bootcamp How are you today", resultText);
    }
}
