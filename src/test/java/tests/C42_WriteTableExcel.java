package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseWithActionHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class C42_WriteTableExcel extends TestBaseWithActionHelper {

    /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    @Test
    void writeTableExcelTest(){
        
//        Go to https://claruswaysda.github.io/webTable.html
        driver.get("https://claruswaysda.github.io/webTable.html");
            WebElement table = driver.findElement(By.id("myTable"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));


            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Web Table Data");
            logger.info("Starting to write data to Excel file.");


            for (int i = 0; i < rows.size(); i++) {
                List<WebElement> cells = rows.get(i).findElements(By.tagName(i == 0 ? "th" : "td"));
                Row excelRow = sheet.createRow(i);
                for (int j = 0; j < cells.size(); j++) {
                    Cell excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(cells.get(j).getText());
                }
            }
            String filePath = "table_data.xlsx";

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
                logger.info("Successfully wrote data to " + filePath);
                System.out.println("Successfully wrote data to " + filePath);
            } catch (IOException e) {
                logger.error("Failed to write data to Excel file.", e);
                e.printStackTrace();
            } finally {
                try {
                    // Ensure the workbook is closed to free up resources
                    workbook.close();
                } catch (IOException e) {
                    logger.error("Failed to close workbook.", e);
                    e.printStackTrace();
                }
            }
    }

}


