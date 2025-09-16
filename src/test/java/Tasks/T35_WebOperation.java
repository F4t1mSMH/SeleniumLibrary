package Tasks;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

import static utilities.ExcelUtils.*;

public class T35_WebOperation extends TestBase {
    @Test
    void wepOp(){
// Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
// Add 3 records
        addRecord(driver, "cho", "25", "Canada");
        addRecord(driver, "Jane", "30", "UK");
        addRecord(driver, "Mike", "35", "Germany");
// Edit the 5th record
        editRecord(driver, 5, "Red John", "35", "USA");
// Delete the 1st record
        deleteRecord(driver, 1);

    }
}
