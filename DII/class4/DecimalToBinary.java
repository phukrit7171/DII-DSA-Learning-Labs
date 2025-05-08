package class4;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> binaryStack = new Stack<>();

        System.out.println("Please enter a positive integer:");
        int decimalNumber;

        while (true) {
            try {
                decimalNumber = scanner.nextInt();
                if (decimalNumber >= 0) {
                    break; // Exit loop if positive integer is entered
                } else {
                    System.out.println("Please enter a positive integer only:");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer:");
                scanner.next(); // consume the invalid input
            }
        }

        if (decimalNumber == 0) {
            System.out.println("Binary representation is: 0");
        } else {
            int tempNumber = decimalNumber;
            while (tempNumber > 0) {
                int remainder = tempNumber % 2;
                binaryStack.push(remainder);
                tempNumber = tempNumber / 2;
            }

            System.out.print("Binary representation of " + decimalNumber + " is: ");
            while (!binaryStack.isEmpty()) {
                System.out.print(binaryStack.pop());
            }
            System.out.println(); // Newline at the end
        }

        scanner.close();
    }
}
