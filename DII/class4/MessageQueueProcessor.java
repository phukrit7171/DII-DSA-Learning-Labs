package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MessageQueueProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Character> charQueue = new LinkedList<>();

        System.out.println("Enter the message string:");
        String message = scanner.nextLine();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                charQueue.offer(c); // Enqueue the letter
            } else if (c == '*') {
                if (!charQueue.isEmpty()) {
                    charQueue.poll(); // Dequeue if asterisk and queue is not empty
                }
            }
            // Other characters (like spaces in "LASTIN FIRST OUT") are ignored as per the
            // problem's focus on letters and asterisks.
            // If spaces or other symbols should be enqueued, the condition
            // `Character.isLetter(c)` would need adjustment.
            // Based on "EASYQUE", it seems only letters are enqueued.
        }

        if (charQueue.isEmpty()) {
            System.out.println("Nothing");
        } else {
            // To display the remaining letters as a single string:
            String remaining = charQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            System.out.println(remaining);
        }

        scanner.close();
    }
}