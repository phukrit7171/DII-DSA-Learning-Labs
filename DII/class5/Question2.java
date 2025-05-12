package class5;
import java.util.Random;
import java.util.Arrays;

public class Question2 {

    public static long sumOfArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--- Question 2: Sum of Array (Increased Sizes) ---");
        
        // Increased array sizes for O(N)
        // Max 150M ints: ~572 MB RAM. The PDF mentioned 100M.
        int[] arraySizes = {1_000_000, 10_000_000, 50_000_000, 100_000_000, 150_000_000}; 

        System.out.println("\nTable for Question 2:");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Length of Array  | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int size : arraySizes) {
            System.out.printf("Processing Q2 for array size: %,d ... ", size);
            // Array Initialization
            int[] arr = random.ints(size, 1, 101).toArray(); // Values from 1 to 100

            long startTime = System.currentTimeMillis();
            long sumResult = sumOfArray(arr);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // Hint to prevent sumResult from being optimized away if it's unused.
            if (sumResult == System.nanoTime()) System.out.println("This will not happen");


            System.out.printf("Completed. Time: %d ms\n", duration);
            System.out.printf("| %-16s | %-20d |\n", String.format("%,d", size), duration);
        }
        System.out.println("+------------------+----------------------+");
        System.out.println("If you encounter OutOfMemoryError, try running with more heap: java -Xmx2g Question2 (or higher like 4g)");


        System.out.println("\n--- Big O Analysis for Question 2 ---");
        System.out.println("The Big O of sumOfArray is O(N) (Linear Time).");
    }
}