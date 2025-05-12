package class5;
import java.util.Random;
import java.util.Arrays;

public class Question2 {

    public static long sumOfArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            // System.out.println("Array is null or empty for sumOfArray.");
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

        System.out.println("--- Question 2: Sum of Array (Auto-sizing) ---");
        
        // Similar sizes to Q1, as it's O(N)
        int[] arraySizes = {10, 1000, 100000, 1000000, 5000000, 10000000, 20000000}; 
        // Max 20M to keep execution times reasonable for O(N) sum. 
        // 20,000,000 ints is ~80MB.
        // Values in array are kept small (1-100) to avoid long overflow with large sums.

        System.out.println("\nTable for Question 2:");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Length of Array  | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int size : arraySizes) {
            // Array Initialization (time not included in method's measurement)
            int[] arr = random.ints(size, 1, 101).toArray(); // Values from 1 to 100

            // Optional warm-up (more beneficial for the first run or more complex JIT optimizations)
            // if (size == arraySizes[0]) { // Warm-up before the first timed run for this question
            //     int[] warmUpArr = random.ints(size, 1, 101).toArray();
            //     sumOfArray(warmUpArr);
            // }

            long startTime = System.currentTimeMillis();
            long sumResult = sumOfArray(arr);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // To avoid issues with unused `sumResult` being optimized away in some scenarios
            // System.out.print(""); // or use if(sumResult == System.currentTimeMillis()) {}

            System.out.printf("| %-16d | %-20d |\n", size, duration);
        }
        System.out.println("+------------------+----------------------+");

        System.out.println("\n--- Big O Analysis for Question 2 ---");
        System.out.println("The Big O of sumOfArray is O(N) (Linear Time).");
    }
}
