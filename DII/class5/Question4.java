package class5;
import java.util.Random;
import java.util.Arrays;

public class Question4 {

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        if (matrixA == null || matrixB == null || matrixA.length == 0 || matrixA[0].length == 0 || matrixB.length == 0 || matrixB[0].length == 0) {
            // System.out.println("Matrices cannot be null or empty.");
            return null;
        }
        if (matrixA[0].length != matrixB.length) {
            // System.out.println("Incompatible dimensions for matrix multiplication.");
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

        System.out.println("--- Question 4: Matrix Multiplication (Auto-sizing) ---");
        System.out.println("Testing with square matrices for simplicity: (N x N) * (N x N)");
        
        // For O(N^3) - assuming M=N=P for simplicity of sizing progression
        // N=250 -> 250^3 = 15,625,000 operations.
        // N=500 -> 500^3 = 125,000,000 operations (can take significant time).
        int[] dimensions = {10, 50, 100, 150, 200, 250, 300}; // Max 300 for N (300^3 = 27M)
                                                             // 400^3 = 64M, 500^3 = 125M

        System.out.println("\nTable for Question 4 (N x N) * (N x N) matrix multiplication:");
        System.out.println("+------------------+----------------------+");
        System.out.println("| Matrix Dim (N)   | Execution Time (ms)  |");
        System.out.println("+------------------+----------------------+");

        for (int n : dimensions) {
            // Matrix Initialization (N x N) for both matrixA and matrixB
            int[][] matrixA = new int[n][n];
            int[][] matrixB = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrixA[i][j] = random.nextInt(10); // Small values 0-9
                    matrixB[i][j] = random.nextInt(10);
                }
            }

            long startTime = System.currentTimeMillis();
            int[][] result = multiplyMatrices(matrixA, matrixB);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // To avoid issues with unused `result`
            // if(result != null && result.length > 0 && result[0][0] == System.currentTimeMillis()){}

            System.out.printf("| %-16d | %-20d |\n", n, duration);
             // A small delay for very large matrix multiplications if needed to allow system to catch up or prevent aggressive optimization/caching effects if run too rapidly
            // if (n >= 200) { try { Thread.sleep(100); } catch (InterruptedException e) {} }
        }
        System.out.println("+------------------+----------------------+");

        System.out.println("\n--- Big O Analysis for Question 4 ---");
        System.out.println("The Big O of multiplyMatrices for (M x N) * (N x P) is O(M*N*P).");
        System.out.println("For the (N x N) * (N x N) case tested, it's O(N^3) (Cubic Time).");
    }
}