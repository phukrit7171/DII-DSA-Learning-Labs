package class5;

import java.util.Random;
import java.util.Arrays;

public class Question1 {

    public static int multiplyByLastElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            // System.out.println("Array is null or empty for multiplyByLastElement.");
            return -1;
        }
        return 2 * arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--- Question 1: Multiply by Last Element (Auto-sizing) ---");
        System.out.println("Note: For O(1) operations, timings might show 0ms due to low resolution of System.currentTimeMillis() or very fast execution.");
        
        // Sizes suggested in PDF were 10, 1000, 100000, 100000000.
        // Using a range that demonstrates the O(1) nature.
        // Extremely large arrays (e.g., 100,000,000 ints approx 400MB) are used mainly to show
        // that initialization time changes, but the core operation time remains constant.
        // We'll focus on timing the core operation.
        int[] arraySizes = {10, 1000, 100000, 1000000, 10000000, 50000000}; 
        // Using 50M instead of 100M to be friendlier on typical memory, 
        // 50,000,000 ints is ~200MB.

        System.out.println("\nTable for Question 1:");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Length of Array  | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int size : arraySizes) {
            // Array Initialization
            // This part is NOT timed as part of the method's efficiency
            int[] arr = new int[size]; // Basic initialization
            if (size > 0) {
                 // Minimal population to ensure the array exists and has a last element.
                 // For Q1, only the last element's value matters, but it needs to be populated.
                 // The `random.ints()` approach from PDF is for general random values.
                 // To purely test `multiplyByLastElement`, array setup should be separate.
                arr[size-1] = random.nextInt(100000 - 10 + 1) + 10;
            }


            // Warm-up (optional, more relevant for complex methods or very precise benchmarking)
            // For an O(1) operation this simple, JIT effects might be minimal on the operation itself.
            // multiplyByLastElement(arr); // One warm-up call

            long startTime = System.currentTimeMillis();
            int result = multiplyByLastElement(arr);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.printf("| %-16d | %-20d |\n", size, duration);
        }
        System.out.println("+------------------+----------------------+");

        System.out.println("\nReminder: The method itself is O(1). Variations in timing for such a fast operation");
        System.out.println("can be due to system load, timer resolution, and Java's runtime environment.");
        System.out.println("The array initialization time is separate and would be O(N).");

        // Explanation of 'long' (already provided in previous version, kept for completeness if run standalone)
        System.out.println("\n--- Explanation of 'long' Data Type ---");
        System.out.println("'long' is a 64-bit signed integer. Used for numbers larger than 'int' (32-bit) can hold.");
        System.out.println("Essential for System.currentTimeMillis() which returns a long.");

        System.out.println("\n--- Big O Analysis for Question 1 ---");
        System.out.println("The Big O of multiplyByLastElement is O(1) (Constant Time).");
    }
}