package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class MArray {
    ArrayList<Value> row = new ArrayList<>();
    ArrayList<ArrayList<Value>> data = new ArrayList<>();
    String type;
    private MArray() {}
    public MArray(String fileName) {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) { //row
                for (String cell : row) { //column
                    Value element;
                    try{
                        Integer.parseInt(cell);
                        element = new IntValue();
                        Integer.valueOf(cell);
                    } catch (NumberFormatException e1) {
                        try {
                            Double.parseDouble(cell);
                            element = new DoubleValue();
                            Double.valueOf(cell);
                        } catch (NumberFormatException e2) {
                            element = new StringValue();
                        }
                    }
                    System.out.print(cell + element.type() + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
