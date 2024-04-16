package com.sep.utilities.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * A utility class for reading and writing CSV files.
 */
public class CSVUtils {

    private List<List<String>> data;
    private String path;

    /**
     * Creates a new CSVUtils instance.
     *
     * @param path the path of the CSV file
     * @throws IOException if there is an error reading the CSV file
     */
    public CSVUtils(String path) throws IOException {
        this.path = path;
        this.data = readAll();
    }

    /**
     * Reads all the data from the CSV file.
     *
     * @return a list of lists containing the data from each row
     * @throws IOException if there is an error reading the CSV file
     */
    private List<List<String>> readAll() throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    /**
     * Returns the data from a specific cell in the CSV file.
     *
     * @param rowNum the row number (zero-based)
     * @param colNum the column number (zero-based)
     * @return the data from the specified cell
     */
    public String getCellData(int rowNum, int colNum) {
        return data.get(rowNum).get(colNum);
    }

    /**
     * Returns the data from the CSV file as a two-dimensional array.
     * The first dimension represents the rows, and the second dimension represents the columns.
     *
     * @return the data from the CSV file as a two-dimensional array
     */
    public String[][] getDataArray() {
        String[][] dataArray = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            List<String> row = data.get(i);
            dataArray[i] = row.toArray(new String[0]);
        }
        return dataArray;
    }

    /**
     * Returns the data from the CSV file as a two-dimensional array, without the first row.
     * The first dimension represents the rows, and the second dimension represents the columns.
     *
     * @return the data from the CSV file as a two-dimensional array, without the first row
     */
    public String[][] getDataArrayWithoutFirstRow() {
        String[][] dataArray = new String[data.size() - 1][];
        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            dataArray[i - 1] = row.toArray(new String[0]);
        }
        return dataArray;
    }

    /**
     * Returns the data from the CSV file as a list of maps, where each map represents a row of data.
     * The keys of the map are the column names, and the values are the data in each column.
     *
     * @return the data from the CSV file as a list of maps
     */
    public List<Map<String, String>> getDataList() {
        List<Map<String, String>> dataList = new ArrayList<>();
        List<String> columns = getColumnsNames();

        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            Map<String, String> rowMap = new HashMap<>();
            for (int j = 0; j < row.size(); j++) {
                rowMap.put(columns.get(j), row.get(j));
            }
            dataList.add(rowMap);
        }
        return dataList;
    }

    /**
     * Returns the column names of the CSV file.
     *
     * @return the column names of the CSV file
     */
    public List<String> getColumnsNames() {
        return new ArrayList<>(data.get(0));
    }

    /**
     * Sets the data in a specific cell in the CSV file.
     *
     * @param value  the new data for the cell
     * @param rowNum the row number (zero-based)
     * @param colNum the column number (zero-based)
     * @throws IOException if there is an error writing to the CSV file
     */
    public void setCellData(String value, int rowNum, int colNum) throws IOException {
        data.get(rowNum).set(colNum, value);
        writeAll(data);
    }

    /**
     * Sets the data in a specific cell in the CSV file, based on the column name.
     *
     * @param value    the new data for the cell
     * @param columnName the name of the column
     * @param row      the row number (zero-based)
     * @throws IOException if there is an error writing to the CSV file
     */
    public void setCellData(String value, String columnName, int row) throws IOException {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

    /**
     * Writes the data to the CSV file.
     *
     * @param rows the data to write to the CSV file
     * @throws IOException if there is an error writing to the CSV file
     */
    private void writeAll(List<List<String>> rows) throws IOException {
        try (FileWriter fw = new FileWriter(this.path)) {
            for (List<String> rowData : rows) {
                fw.append(String.join(",", rowData));
                fw.append("\n");
            }
        }
    }

    /**
     * Returns the number of columns in the CSV file.
     *
     * @return the number of columns in the CSV file
     */
    public int columnCount() {
        return data.get(0).size();
    }

    /**
     * Returns the number of rows in the CSV file.
     *
     * @return the number of rows in the CSV file
     */
    public int rowCount() {
        return data.size();
    }
}
