package class4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class MessageProcessor  {
    public static void main(String[] args) {
        Queue<Character> charQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a message:");
        String message = scanner.nextLine();

        for (char c : message.toCharArray()) {
            if (c == '*') {
                // Dequeue if the queue is not empty
                if (!charQueue.isEmpty()) {
                    charQueue.remove(); // remove() will throw exception if empty, poll() returns null
                }
            } else {
                // Enqueue any other character
                charQueue.add(c); // add() will throw exception if failed, offer() returns false
            }
        }

        System.out.println("\nRemaining characters in the Queue:");
        if (charQueue.isEmpty()) {
            System.out.println("Nothing");
        } else {
            // Print remaining characters in the order they are in the queue
            while (!charQueue.isEmpty()) {
                System.out.print(charQueue.remove());
            }
            System.out.println(); // Add a newline at the end
        }

        scanner.close();
    }
}
