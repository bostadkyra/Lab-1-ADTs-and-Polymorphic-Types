package edu.umn.d.cs1632;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MArray mArray = new MArray("src/data/simple.csv");
        // Put your code for queries here
    }

    private static ArrayList<ArrayList<Value>> data;

    public static void userInput(ArrayList<ArrayList<Value>> mArray){
        data = mArray;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Query? ");
            String response = scanner.nextLine().trim(); //takes in response and removes excess white space

            String[] responseParts = response.split(" ");
            String letterCommand = responseParts[0].toUpperCase();//forces uppercase on entered letter

            try{
                switch(letterCommand){
                    case "V":
                        int col = Integer.parseInt(responseParts[1]);
                        int rowStart = Integer.parseInt(responseParts[2]);
                        int rowEnd = Integer.parseInt(responseParts[3]);
                        System.out.println(typeVertical(col, rowStart, rowEnd));
                    case "H":
                        int row = Integer.parseInt(responseParts[1]);
                        int colStart = Integer.parseInt(responseParts[2]);
                        int colEnd = Integer.parseInt(responseParts[3]);
                        System.out.println(typeHorizontal(row, colStart, colEnd));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bounds. Please check your row/column values.");
            }

            if (response.equalsIgnoreCase("Q")){
                break;
            }
        }
        scanner.close();
    }

    private static String typeVertical(int col, int rowStart, int rowEnd){
        String assumedType = null;

        for (int i = rowStart; i <= rowEnd; i++){
            String cellType = data.get(i).get(col).queryType();
            if (assumedType == null){
                assumedType = cellType;
            } else if (!assumedType.equals(cellType)) {
                return "Multi";
            }
        }
        return assumedType != null ? assumedType : "Empty"; //replaces if else block
    }

    private static String typeHorizontal(int row, int colStart, int colEnd){
        String assumedType = null;

        for (int i = colStart; i <= colEnd; i++){
            String cellType = data.get(i).get(row).queryType();
            if (assumedType == null){
                assumedType = cellType;
            } else if (!assumedType.equals(cellType)) {
                return "Multi";
            }
        }
        return assumedType != null ? assumedType : "Empty"; //replaces if else block
    }
}
