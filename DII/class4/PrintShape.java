package class4;
import java.util.Scanner;
public class PrintShape {

    public static void printCharacter(char ch, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive odd integer n: ");
        int n = scanner.nextInt();

        if (n <= 0 || n % 2 == 0) {
            System.out.println("Input must be a positive odd integer.");
            scanner.close();
            return;
        }

        // Top half (including the middle row)
        for (int currentPluses = 1; currentPluses <= n; currentPluses += 2) {
            int spaces = (n - currentPluses) / 2;
            printCharacter(' ', spaces); // Print leading spaces
            printCharacter('+', currentPluses); // Print '+' characters
            System.out.println(); // Move to the next line
        }

        // Bottom half
        for (int currentPluses = n - 2; currentPluses >= 1; currentPluses -= 2) {
            int spaces = (n - currentPluses) / 2;
            printCharacter(' ', spaces); // Print leading spaces
            printCharacter('+', currentPluses); // Print '+' characters
            System.out.println(); // Move to the next line
        }

        scanner.close();
    }
}