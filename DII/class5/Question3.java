package class5;

import java.util.Random;
import java.util.Arrays;

public class Question3 {

    public static long[] sumOfEachRow(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        long[] rowSums = new long[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                rowSums[i] = 0; 
                continue;
            }
            long sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            rowSums[i] = sum;
        }
        return rowSums;
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--- Question 3: Sum of Each Row in a Square Matrix (Increased Sizes) ---");
        
        // For O(N^2) - square matrix of dimension N x N
        // N=10000 -> 100,000,000 operations. Matrix size: ~381 MB RAM.
        int[] matrixDimensions = {1000, 2000, 4000, 6000, 8000, 10000}; 

        System.out.println("\nTable for Question 3 (N x N matrix):");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Matrix Dim (N)   | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int n : matrixDimensions) {
            System.out.printf("Processing Q3 for matrix dimension N = %,d ... ", n);
            // Matrix Initialization (N x N)
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(100); // Values 0-99
                }
            }

            long startTime = System.currentTimeMillis();
            long[] sums = sumOfEachRow(matrix);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // Hint to prevent sums from being optimized away
            if (sums != null && sums.length > 0 && sums[0] == System.nanoTime()) System.out.println("This won't happen");

            System.out.printf("Completed. Time: %d ms\n", duration);
            System.out.printf("| %-16s | %-20d |\n", String.format("%,d", n), duration);
        }
        System.out.println("+------------------+----------------------+");
        System.out.println("If you encounter OutOfMemoryError, try running with more heap: java -Xmx2g Question3 (or higher)");


        System.out.println("\n--- Big O Analysis for Question 3 ---");
        System.out.println("The Big O of sumOfEachRow for an N x N square matrix is O(N^2) (Quadratic Time).");
    }
}