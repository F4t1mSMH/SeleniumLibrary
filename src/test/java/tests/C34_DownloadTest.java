package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C34_DownloadTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on download
    Verify that 'QAProgram.png' file is downloaded
    */

    @Test
    void downloadTest() throws InterruptedException, IOException {
        //        Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

//        Click on download
        Files.deleteIfExists(Path.of(System.getProperty("user.home") + "/Downloads/QAProgram.png"));
        driver.findElement(By.linkText("Download")).click();

//        Verify that 'QAProgram.png' file is downloaded
        Thread.sleep(1000);
        assert Files.exists(Path.of(System.getProperty("user.home") + "/Downloads/QAProgram.png"));
    }


    }

