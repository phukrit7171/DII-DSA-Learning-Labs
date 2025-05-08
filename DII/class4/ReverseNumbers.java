package class4;
import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter integers separated by spaces (or 'q' to quit): ");
            String inputStr = scanner.nextLine();
            if (inputStr.equalsIgnoreCase("q")) {
                break;
            }
            try {
                String[] numbers = inputStr.split(" ");
                for (String numStr : numbers) {
                    myStack.push(Integer.parseInt(numStr));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers separated by spaces or 'q'.");
            }
        }

        System.out.println("\nNumbers in reverse order:");
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }

        scanner.close();
    }
}