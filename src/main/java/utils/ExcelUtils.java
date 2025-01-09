package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    public static XSSFWorkbook wb;
    public static FileInputStream file;

    /**
     * <open sheet xlsx format>
     * @param filePath       file path to read
     * @param sheetIndex      sheet name to interrogate
     * @return XSSFSheet
     **/
    public static XSSFSheet openSheetInTheWorkBook(String filePath, int sheetIndex) {
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = wb.getSheetAt(sheetIndex);
        return sheet;
    }

    /**
     * <open sheet xlsx format>
     * @param filePath       file path to read
     * @param sheetIndex      sheet name to interrogate
     * @param rowNumber      number of row
     * @return array list of string
     **/
    public static ArrayList<String> readSpecificRow(String filePath, int sheetIndex, int rowNumber) {
        XSSFSheet sheet = openSheetInTheWorkBook(filePath, sheetIndex);
        XSSFRow row = sheet.getRow(rowNumber);
        ArrayList<String> array = new ArrayList<>();
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            switch (row.getCell(i).getCellType()) {
                case STRING:
                    array.add(row.getCell(i).getStringCellValue());
                    break;
                case NUMERIC:
                    if (row.getCell(i).getCellType() == CellType.NUMERIC) {
                        // If cell type is numeric, we need to check if data is of Date type
                        if (DateUtil.isCellDateFormatted(row.getCell(i))) {
                            // Need to use DataFormatter to get data in given style otherwise it will come as time stamp
                            DataFormatter df = new DataFormatter();
                            String v1 = df.formatCellValue(row.getCell(i));
                            array.add(v1);
                        } else {
                            double v1 = row.getCell(i).getNumericCellValue();
                            array.add(String.valueOf(v1));
                        }
                    }
                    break;
                case BOOLEAN:
                    array.add(String.valueOf(row.getCell(i).getBooleanCellValue()));
                    break;
            }
        }
        System.out.print("Row Number => ");
        System.out.println(rowNumber + 1);
        return array;
    }

    /**
     * <open sheet xlsx format>
     * @param filePath       file path to read
     * @param sheetIndex      sheet name to interrogate
     * @param rowNumber      number of row
     * @param cellNumber     number of cell
     * @return cell value
     **/
    public static String readSpecificCell(String filePath, int sheetIndex, int rowNumber, int cellNumber) {
        XSSFSheet sheet = openSheetInTheWorkBook(filePath, sheetIndex);
        XSSFRow row = sheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);
        String cellVal = null;
        switch (cell.getCellType()) {
            case STRING:
                cellVal = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (cell.getCellType() == CellType.NUMERIC) {
                    // If cell type is numeric, we need to check if data is of Date type
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // Need to use DataFormatter to get data in given style otherwise it will come as time stamp
                        DataFormatter df = new DataFormatter();
                        cellVal = df.formatCellValue(cell);
                    } else {
                        cellVal = String.valueOf(cell.getNumericCellValue());
                    }
                }
                break;
            case BOOLEAN:
                cell.getBooleanCellValue();
                break;
        }
        return cellVal;
    }


    /**
     * <open sheet xlsx format>
     * @param filePath       file path to read
     * @param sheetIndex      sheet name to interrogate
     * @return array list of string
     **/
    public static ArrayList<String> readAllDataSheet(String filePath, int sheetIndex) {
        XSSFSheet sheet = openSheetInTheWorkBook(filePath, sheetIndex);
        ArrayList<String> array = new ArrayList<>();
        for (Row row : sheet) {    //iteration over row using for each loop
            for (Cell cell : row) {   //iteration over cell using for each loop
                switch (cell.getCellType()) {
                    case STRING:
                        array.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        if (cell.getCellType() == CellType.NUMERIC) {
                            // If cell type is numeric, we need to check if data is of Date type
                            if (DateUtil.isCellDateFormatted(cell)) {
//                                 Need to use DataFormatter to get data in given style otherwise it will come as time stamp
                                array.add(String.valueOf(cell));
                            } else {
                                array.add((String.valueOf(cell.getNumericCellValue())));
                            }
                        }
                        break;
                    case BOOLEAN:
                        array.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                }
            }
            System.out.println();
        }
        return array;
    }

    /**
     * <open sheet xlsx format>
     * @param filePath            file path to read
     * @param sheetIndex           sheet name to interrogate
     * @param rowNumber          number of the existing row
     * @param newCellNumber      number of the new cell to add
     * @param value              the new value of the cell
     **/

    public static void writeAnewCellInExistingRow(String filePath, int sheetIndex, int rowNumber, int newCellNumber, String value) {
        XSSFSheet sheet = openSheetInTheWorkBook(filePath, sheetIndex);
        XSSFRow getRow = sheet.getRow(rowNumber);
        XSSFCell addNewCell = getRow.createCell(newCellNumber);
        addNewCell.setCellValue(value);
    }

    /**
     * <open sheet xlsx format>
     * @param filePath       file path to read
     * @param sheetIndex      sheet name to interrogate
     * @param rowNumber      number of the new  row
     * @return new row
     **/
    public static XSSFRow createNewRow(String filePath, int sheetIndex, int rowNumber) {
        XSSFSheet sheet = openSheetInTheWorkBook(filePath, sheetIndex);
        XSSFRow row = sheet.createRow(rowNumber);
        return row;

    }

    /**
     * <open sheet xlsx format>
     * @param newRow            you have to call this method createNewRow() to return the new row and put it as param
     * @param newCellNumber     the number of the new cell
     * @param value             the value of the new cell
     **/

    public static void writeAnewCellInNewRow(XSSFRow newRow, int newCellNumber, String value) {
        XSSFCell addNewCell = newRow.createCell(newCellNumber);
        addNewCell.setCellValue(value);
    }

    /**
     * <close sheet xlsx format>
     * @param filePath     file path to close
     **/
    public static void closeTheWB(String filePath) {
        // Save the changes
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            wb.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
