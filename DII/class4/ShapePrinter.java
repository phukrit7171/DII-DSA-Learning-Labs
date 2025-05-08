package class4;

import java.util.Scanner;

public class ShapePrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("Please enter a positive odd integer:");

        while (true) {
            try {
                n = scanner.nextInt();
                if (n > 0 && n % 2 != 0) {
                    break; // Exit loop if positive odd integer is entered
                } else {
                    System.out.println("Please enter a positive odd integer only:");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive odd integer:");
                scanner.next(); // consume the invalid input
            }
        }

        printShape(n);

        scanner.close();
    }

    public static void printShape(int n) {
        int midRow = n / 2; // Integer division gives the index of the middle row (0-indexed)

        for (int i = 0; i < n; i++) {
            int numberOfPluses;
            if (i <= midRow) {
                // Number of pluses increases up to the middle row
                numberOfPluses = 2 * i + 1;
            } else {
                // Number of pluses decreases after the middle row
                numberOfPluses = 2 * (n - 1 - i) + 1;
            }
            
            // Calculate leading spaces to center the shape
            int numberOfSpaces = (n - numberOfPluses) / 2;
            for (int j = 0; j < numberOfSpaces; j++) {
                System.out.print(" ");
            }
            // Print the plus signs
            for (int j = 0; j < numberOfPluses; j++) {
                System.out.print("+");
            }
            System.out.println(); // Newline after each row
        }
    }
}