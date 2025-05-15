package class5;

import java.util.Random;

public class Question4 {

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        if (matrixA == null || matrixB == null || matrixA.length == 0 || matrixA[0].length == 0 || matrixB.length == 0 || matrixB[0].length == 0) {
            return null;
        }
        if (matrixA[0].length != matrixB.length) {
            return null;
        }

        int m = matrixA.length;
        int n = matrixA[0].length;
        int p = matrixB[0].length;
        int[][] resultMatrix = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                resultMatrix[i][j] = sum;
            }
        }
        return resultMatrix;
    }

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--- Question 4: Matrix Multiplication (Increased Sizes) ---");
        System.out.println("Testing with square matrices: (N x N) * (N x N)");
        
        // For O(N^3) - N=600 -> 216,000,000 operations. This will take several seconds.
        // N=700 -> 343,000,000 operations.
        // Two 700x700 matrices need ~3.7MB RAM.
        int[] dimensions = {100, 200, 300, 400, 500, 600, 700}; // Max 700 for N

        System.out.println("\nTable for Question 4 (N x N) * (N x N) matrix multiplication:");
        System.out.println("WARNING: Larger dimensions can take significant time (minutes for the largest ones).");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Matrix Dim (N)   | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int n : dimensions) {
            System.out.printf("Processing Q4 for matrix dimension N = %,d ... ", n);
            // Matrix Initialization
            int[][] matrixA = new int[n][n];
            int[][] matrixB = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrixA[i][j] = random.nextInt(10); 
                    matrixB[i][j] = random.nextInt(10);
                }
            }

            long startTime = System.currentTimeMillis();
            int[][] result = multiplyMatrices(matrixA, matrixB);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // Hint to prevent result from being optimized away
            if (result != null && result.length > 0 && result[0][0] == System.nanoTime()) System.out.println("This won't happen");

            System.out.printf("Completed. Time: %d ms\n", duration);
            System.out.printf("| %-16s | %-20d |\n", String.format("%,d", n), duration);
        }
        System.out.println("+------------------+----------------------+");
        System.out.println("If you encounter OutOfMemoryError, try running with more heap: java -Xmx2g Question4 (or higher)");

        System.out.println("\n--- Big O Analysis for Question 4 ---");
        System.out.println("The Big O of multiplyMatrices for (M x N) * (N x P) is O(M*N*P).");
        System.out.println("For the (N x N) * (N x N) case tested, it's O(N^3) (Cubic Time).");
    }
}