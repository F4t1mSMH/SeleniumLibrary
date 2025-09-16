package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.JSUtils;
import utilities.TestBase;

public class C30_JSScroll extends TestBase {

    @Test
    void scrollDownTest() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/index.html");

        Thread.sleep(3000);
        JSUtils.scrollDownByPx(driver,"500");
        Thread.sleep(3000);
        JSUtils.scrollDownByPx(driver,"1000");
    }

}
