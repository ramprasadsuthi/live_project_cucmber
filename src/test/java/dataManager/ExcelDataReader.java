package dataManager;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataReader {

    public List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        
        List<Map<String, String>> data = new ArrayList<>();

        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();
        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header row
            Row row = sheet.getRow(i);
            if (row != null) {
                Map<String, String> rowData = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    String key = headerRow.getCell(j).toString();
                    String value = cell != null ? cell.toString() : "";
                    rowData.put(key, value);
                }
                data.add(rowData);
            }
        }

        workbook.close();
        inputStream.close();
        return data;
    }
}

