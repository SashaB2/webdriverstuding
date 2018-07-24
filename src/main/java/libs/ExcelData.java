package libs;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExcelData {

    private static String excelFile = "./src/main/java/data/testData.xls";

    /**
     * with file location param
     * @param fileLocation
     * @param sheetName
     * @return
     */
    public static HashMap<String, String> getData(String fileLocation, String sheetName){

        HashMap<String, String> valuesOfSheet = new HashMap<String, String>();

        File src = new File(fileLocation);

        FileInputStream inputStream = null;

        HSSFWorkbook workbook;

        HSSFSheet sheet;

        int rows;

        HSSFCell firstColumnValue;

        HSSFCell secondColumnValue;

        try{
            inputStream = new FileInputStream(src);
            workbook = new HSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);

            //get number filled rows
            rows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) {
                firstColumnValue = sheet.getRow(i).getCell(0);
                secondColumnValue = sheet.getRow(i).getCell(1);
                firstColumnValue.setCellType(HSSFCell.CELL_TYPE_STRING);
                secondColumnValue.setCellType(HSSFCell.CELL_TYPE_STRING);
                valuesOfSheet.put(firstColumnValue.getStringCellValue(), secondColumnValue.getStringCellValue());
            }
        }
        catch (FileNotFoundException e){
            Assert.fail("Excel file not found");
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return valuesOfSheet;

    }

    /**
     * without file location param
     * @param sheetName
     * @return
     */
    public static HashMap<String, String> getData(String sheetName){
        return getData(excelFile, sheetName);
    }



}
