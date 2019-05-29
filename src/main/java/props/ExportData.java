package props;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportData {

    static File file;
    static FileInputStream inputStream;
    static Workbook workbook;
    static Sheet sheet;
    static FileOutputStream outputStream;
    static int cellId;

    public static void writeToExcel(String cityName, Map<String, String> data) {
        try {
            file = new File("ExportedData/" + cityName + ".xls");
            inputStream = new FileInputStream(file);
            workbook = new HSSFWorkbook(inputStream);
            sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
            Row newRow = sheet.createRow(rowCount);

            /*Row row = sheet.getRow(0);



            for(int j = 0; j < 2; j++){
                Cell cell = newRow.createCell(j);
                cell.setCellValue(data.get(j));
            }*/

            cellId= 0;
            for (String attribute: data.keySet()) {
                Cell cell = newRow.createCell(cellId++);
                cell.setCellValue(data.get(attribute));

            }
            inputStream.close();

            outputStream = new FileOutputStream(file);
            ((HSSFWorkbook) workbook).write(outputStream);
            outputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        Map<String, String> data = new HashMap<String, String>();
        data.put("Location", "pune");
        data.put("Owner", "shahrukh");
        data.put("cost", "$200");

        ExportData.writeToExcel("seattle", data);
    }
}
