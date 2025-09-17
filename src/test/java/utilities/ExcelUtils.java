package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcelUtils {

    private final Workbook workbook;

    public ExcelUtils(String contentRoot) {
        try {
            workbook = WorkbookFactory.create(new FileInputStream(contentRoot));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Cell getCell(String sheet, int row, int cell) {
        return workbook.getSheet(sheet).getRow(row).getCell(cell);
    }


    public Workbook getWorkbook() {
        return workbook;
    }
    public static void addRecord(WebDriver driver, String name, String age, String city) {

        // Fill in the form fields
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age);
        driver.findElement(By.id("countrySelect")).sendKeys(city);

        // Click the Submit button
        driver.findElement(By.xpath("/html/body/div/button")).click();
    }

    public static void editRecord(WebDriver driver, int recordNumber, String name, String age, String city) {
        // 1. Locate the edit button for the specific record row using the correct XPath
        WebElement editButton = driver.findElement(By.xpath(recordNumber +"'edit-button"));
        editButton.click();

        // 2. Clear and fill the form fields.
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(age);

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);

        // 3. Click the submit button to save changes.
        driver.findElement(By.id("submit")).click();
    }

    //Deletes a specific record from the table.
    public static void deleteRecord(WebDriver driver, int recordNumber) {
        // Locate the Delete button for the specified record and click it
        WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[" + recordNumber + "]//button[@class='delete-button']"));
        deleteButton.click();
    }
    //task 36 ranking system methods
    public static class EarningsRanking {

        public void rankEarnings(String filePath) throws IOException {
            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0);

                List<Double> earningsList = new ArrayList<>();
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Cell earningsCell = row.getCell(1);
                        if (earningsCell != null && earningsCell.getCellType() == CellType.NUMERIC) {
                            earningsList.add(earningsCell.getNumericCellValue());
                        }
                    }
                }

                List<Double> sortedEarnings = new ArrayList<>(earningsList);
                Collections.sort(sortedEarnings);

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Cell earningsCell = row.getCell(1);
                        if (earningsCell != null && earningsCell.getCellType() == CellType.NUMERIC) {
                            double earnings = earningsCell.getNumericCellValue();
                            int rank = sortedEarnings.indexOf(earnings) + 1;

                            Cell rankCell = row.getCell(2);
                            if (rankCell == null) {
                                rankCell = row.createCell(2);
                            }
                            rankCell.setCellValue(rank);
                        }
                    }
                }

                try (FileOutputStream fos = new FileOutputStream(filePath)) {
                    workbook.write(fos);
                }
            }
        }
    }
}



