package class5;

import java.util.Random;
import java.util.Arrays;

public class Question3 {

    public static long[] sumOfEachRow(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            // System.out.println("Matrix is null or empty for sumOfEachRow.");
            return null;
        }
        long[] rowSums = new long[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                rowSums[i] = 0; 
                continue;
            }
            long sum = 0;
            for (int j = 0; j < matrix[i].length; j++) { // Assumes matrix[i] is not null
                sum += matrix[i][j];
            }
            rowSums[i] = sum;
        }
        return rowSums;
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--- Question 3: Sum of Each Row in a Square Matrix (Auto-sizing) ---");
        
        // For O(N^2) - square matrix of dimension N x N
        // N*N elements. N=4000 -> 16,000,000 elements. Summation is N*N operations.
        int[] matrixDimensions = {10, 100, 500, 1000, 2000, 3000, 4000}; 
        // 4000x4000 might take a few seconds. 3000x3000 is ~9M operations for sum.

        System.out.println("\nTable for Question 3 (N x N matrix):");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Matrix Dim (N)   | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int n : matrixDimensions) {
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
            
            // To avoid issues with unused `sums` being optimized away
            // if(sums != null && sums.length > 0 && sums[0] == System.currentTimeMillis()) {}

            System.out.printf("| %-16d | %-20d |\n", n, duration);
        }
        System.out.println("+------------------+----------------------+");

        System.out.println("\n--- Big O Analysis for Question 3 ---");
        System.out.println("The Big O of sumOfEachRow for an N x N square matrix is O(N^2) (Quadratic Time).");
    }
}