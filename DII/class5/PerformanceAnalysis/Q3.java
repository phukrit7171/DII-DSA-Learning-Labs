package class5.PerformanceAnalysis;

public class Q3 {
    public static void main(String[] args) {
        
    }

    // Write a method to receive a table (i.e., square two-dimension array) and calculate the summation of each row. 
    public static int[] summation(int[][] arr) {
        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum[i] += arr[i][j];
            }
        }
        return sum;
    }
}
