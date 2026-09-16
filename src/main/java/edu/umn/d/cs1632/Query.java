package edu.umn.d.cs1632;

import java.util.Scanner;

public class Query {
    public static void userInput(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Query? ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("Q")){
                break;
            } else {
                System.out.println("Please enter a valid Query: V, H, or M followed by three integers or Q to quit.");
            }
        }
    }
}
