import interfaces.FilesPath;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.util.ArrayList;

public class Excel {

    @Test
    public void openSheetInTheWorkBook() {
        XSSFSheet name = ExcelUtils.openSheetInTheWorkBook(FilesPath.excelFilePath + "Data.xlsx", 0);
        System.out.println(name.getSheetName());
    }


    @Test
    public void readSpecificRow() {
        ArrayList<String> array = ExcelUtils.readSpecificRow(FilesPath.excelFilePath + "Data.xlsx", 0, 7);
        for (String arr : array) {
            System.out.println("*** " + arr + " ***");
        }
    }

    @Test
    public void readSpecificCell() {
        String cell = ExcelUtils.readSpecificCell(FilesPath.excelFilePath + "Data.xlsx", 0, 7, 5);
        System.out.println(cell);
    }

    @Test
    public void readAllDataSheet() {
        ArrayList<String> cell ;
        cell = ExcelUtils.readAllDataSheet(FilesPath.excelFilePath + "Data.xlsx", 0);
        for (String arr : cell) {
            System.out.println("*** " + arr + " ***");
        }
    }

    @Test
    public void writeAnewCellInNewRow()  {
       XSSFRow newRow =  ExcelUtils.createNewRow(FilesPath.excelFilePath + "Data.xlsx",0,52);
        ExcelUtils.writeAnewCellInNewRow(newRow,1,"farah");
        ExcelUtils.writeAnewCellInNewRow(newRow,2,"dana");
        ExcelUtils.closeTheWB(FilesPath.excelFilePath+"Data.xlsx");
    }

    @Test
    public void writeAnewCellInExistingRow(){
        ExcelUtils.writeAnewCellInExistingRow(FilesPath.excelFilePath+"Data.xlsx",0,51,3,"tesssst");
        ExcelUtils.closeTheWB(FilesPath.excelFilePath+"Data.xlsx");
    }
}
