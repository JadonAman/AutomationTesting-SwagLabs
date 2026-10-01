package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    public static String getCellData(
            String filePath,
            String sheetName,
            int rowNum,
            int colNum) {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            Workbook workbook =
                    WorkbookFactory.create(fis);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            return sheet
                    .getRow(rowNum)
                    .getCell(colNum)
                    .toString();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return "";
    }
}