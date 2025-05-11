package class4;
// DecimalToBinary.java
import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> binaryStack = new Stack<>();

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else if (number == 0) {
            System.out.println("Binary representation: 0");
        } else {
            int tempNumber = number; // Use a temporary variable for calculations
            while (tempNumber > 0) {
                int remainder = tempNumber % 2; // Get the remainder (0 or 1)
                binaryStack.push(remainder);    // Push the binary digit onto the stack
                tempNumber = tempNumber / 2;    // Update the number
            }

            // Build the binary string by popping from the stack
            StringBuilder binaryString = new StringBuilder();
            while (!binaryStack.isEmpty()) {
                binaryString.append(binaryStack.pop());
            }
            System.out.println("Binary representation: " + binaryString.toString());
        }
        scanner.close();
    }
}