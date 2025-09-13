package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/*
 Go to URL: https://the-internet.herokuapp.com/basic_auth
 Username: admin
 Password: admin
 Authenticate using: https://admin:admin@the-internet.herokuapp.com/basic_auth
 Verify the congratulations message
 */
public class T25_BasicAuth extends utilities.TestBase {
    @Test
    public void basicAuthTest() {
        String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        driver.get(url);
        System.out.println(driver.findElement(By.tagName("p")).getText());

    }
}
