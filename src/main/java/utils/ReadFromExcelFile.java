package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadFromExcelFile {
    private static String testData = System.getProperty("user.dir")+"/src/main/resources/testdata/TestData.xlsx";

    public static DataFormatter dataFormatter = new DataFormatter();

    static FileInputStream fs;

    static {
        try {
            fs = new FileInputStream(testData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static XSSFSheet sheet = workbook.getSheet("login");

    public static String email = sheet.getRow(1).getCell(0).getStringCellValue();

    public static String password = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));

}
