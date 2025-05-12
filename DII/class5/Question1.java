package class5;
import java.util.Random;

public class Question1 {

    public static int multiplyByLastElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return 2 * arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--- Question 1: Multiply by Last Element (Increased Repetitions) ---");
        System.out.println("Note: The O(1) 'multiplyByLastElement' operation is timed by running it many times in a loop.");
        
        // Array sizes for initialization (the method itself is O(1) regardless of this)
        int[] arraySizesForContext = {1000000, 10000000, 50000000}; 
        int repetitions = 100_000_000; // Run the core operation this many times to get a measurable duration.

        System.out.println("\nTable for Question 1:");
        System.out.println("Timed operation: multiplyByLastElement(arr) repeated " + String.format("%,d", repetitions) + " times.");
        System.out.println("+---------------------+----------------------+-------------------------+");
        System.out.println("| Array Size (Context)| Exec. Time (ms)      | Approx. Time / Op (ns)  |");
        System.out.println("+---------------------+----------------------+-------------------------+");

        for (int size : arraySizesForContext) {
            // Array Initialization - this part's time is not the primary focus for O(1) analysis
            // but is done to have an array to operate on.
            int[] arr = new int[size];
            if (size > 0) {
                arr[size-1] = random.nextInt(100000 - 10 + 1) + 10; // Populate last element
            } else {
                // Handle empty or zero-size array case if it can occur based on sizes
                arr = new int[]{random.nextInt(100)}; // Default small array if size is 0
            }

            long startTime = System.currentTimeMillis();
            // Loop the O(1) operation many times
            for (int i = 0; i < repetitions; i++) {
                multiplyByLastElement(arr); // The actual method call
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            double timePerOpNano = (duration / (double)repetitions) * 1_000_000.0; // Convert ms per rep to ns per rep

            System.out.printf("| %-19s | %-20d | %-23.4f |\n", String.format("%,d", size), duration, timePerOpNano);
        }
        System.out.println("+---------------------+----------------------+-------------------------+");
        System.out.println("The 'Array Size (Context)' primarily affects initialization time, not the O(1) method's core logic time.");
        System.out.println("The 'Approx. Time / Op (ns)' gives a better idea of the raw speed of the O(1) operation.");


        System.out.println("\n--- Explanation of 'long' Data Type ---");
        System.out.println("'long' is a 64-bit signed integer. Used for numbers larger than 'int' (32-bit) can hold.");

        System.out.println("\n--- Big O Analysis for Question 1 ---");
        System.out.println("The Big O of multiplyByLastElement is O(1) (Constant Time).");
    }
}