package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/");
        driver.get("https://stackoverflow.com/");


        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.close();

    }
}
