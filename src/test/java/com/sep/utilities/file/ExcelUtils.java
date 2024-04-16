package com.sep.utilities.file;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A utility class for working with Excel files.
 */
public class ExcelUtils {

    private Sheet workSheet;
    private Workbook workBook;
    private String path;

    /**
     * Creates an ExcelUtils object for the specified Excel file and worksheet.
     *
     * @param path    the path to the Excel file
     * @param sheetName    the name of the worksheet
     */
    public ExcelUtils(String path, String sheetName) {
        this.path = path;
        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the data from a specific cell in the Excel worksheet.
     *
     * @param rowNum    the row number of the cell
     * @param colNum    the column number of the cell
     * @return    the data from the specified cell
     */
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the data from all cells in the Excel worksheet as a 2D array. The first row of the array contains the column
     * headers.
     *
     * @return    the data from all cells in the worksheet as a 2D array
     */
    public String[][] getDataArray() {

        String[][] data = new String[rowCount()][columnCount()];

        for (int i = 0; i <rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;

    }


    /**
     * Returns the data from all cells in the Excel worksheet except the first row as a 2D array. The first row of the
     * array contains the column headers.
     *
     * @return    the data from all cells in the worksheet except the first row as a 2D array
     */
    public String[][] getDataArrayWithoutFirstRow() {

        String[][] data = new String[rowCount()-1][columnCount()];

        for (int i = 1; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i-1][j] = value;
            }
        }
        return data;

    }

    /**
     * Returns the data from all cells in the Excel worksheet as a list of maps, where each map represents a single row
     * of data. The keys of the maps are the column headers.
     *
     * @return    the data from all cells in the worksheet as a list of maps
     */
    public List<Map<String, String>> getDataList() {
        List<String> columns = getColumnsNames();
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i < rowCount(); i++) {
            Row row = workSheet.getRow(i);
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }

            data.add(rowMap);
        }

        return data;
    }

    /**
     * Returns the names of all columns in the Excel worksheet.
     *
     * @return    the names of all columns in the worksheet
     */
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();

        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    /**
     * Sets the data in a specific cell in the Excel worksheet.
     *
     * @param value    the data to set
     * @param rowNum    the row number of the cell
     * @param colNum    the column number of the cell
     */
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;

        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);

            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workBook.write(fileOut);

            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the data in a specific cell in the Excel worksheet.
     *
     * @param value    the data to set
     * @param columnName    the name of the column of the cell
     * @param row    the row number of the cell
     */
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

    /**
     * Returns the number of columns in the Excel worksheet.
     *
     * @return    the number of columns in the worksheet
     */
    public int columnCount() {
        return workSheet.getRow(0).getLastCellNum();
    }

    /**
     * Returns the number of rows in the Excel worksheet.
     *
     * @return    the number of rows in the worksheet
     */
    public int rowCount() {
        return workSheet.getLastRowNum()+1;
    }

}