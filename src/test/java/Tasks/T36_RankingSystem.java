package Tasks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import utilities.ExcelUtils;
import utilities.TestBase;

    public class T36_RankingSystem extends TestBase {

        @Test
        public void testEarningsRanking() {
            String filePath = "src/test/resources/EarningList.xlsx";
            try {
                ExcelUtils.EarningsRanking earningsRanker = new ExcelUtils.EarningsRanking();
                earningsRanker.rankEarnings(filePath);
                System.out.println("Ranking completed successfully!");
            } catch (Exception e) {
                System.err.println("An error occurred during the test: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


