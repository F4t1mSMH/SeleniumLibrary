package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

/*
Go to https://claruswaysda.github.io/form.html
Fill the form
Login the app
Celebrate the login
*/
public class T22_FormLogin extends TestBase {
    @Test
    void test() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/form.html");
        driver.findElement(By.name("ssn")).sendKeys("123-45-6789");
        driver.findElement(By.name("first-name")).sendKeys("Leon");
        driver.findElement(By.name("last-name")).sendKeys("Kennedy");
        driver.findElement(By.name("address")).sendKeys("Raccoon City");
        driver.findElement(By.name("phone")).sendKeys("555-123-4567");
        driver.findElement(By.name("username")).sendKeys("leonkennedy");
        driver.findElement(By.name("email")).sendKeys("leonkennedy@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Resident123");
        driver.findElement(By.name("confirm-password")).sendKeys("Resident123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //click login button
        driver.findElement(By.xpath("//*[@class='login-button']")).click();
//        //login the app
        driver.findElement(By.id("username")).sendKeys("leonkennedy");
        driver.findElement(By.id("password")).sendKeys("Resident123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

//Celebrate the login
        driver.findElement(By.id("clickMeButton")).click();


    }
}


