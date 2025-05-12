package class5.PerformanceAnalysis;

import java.util.Random;

public class Q2 {
    public static void main(String[] args) {
        // Call the method to be measured
        int[] x = {10, 1000, 100000, 100000000};

        for (int n : x) {
            long startTime = System.currentTimeMillis();
            summation(n);
            // Measure the end time
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime; // Calculate the duration in milliseconds
            System.out.println("Execution time: " + duration + " milliseconds");
        }
    }
    //Write a method to calculate the summation of all the values in an array 
    public static int summation(int size) {
        Random random = new Random();
        int[] myArr = random.ints(size, 10, 100000).toArray();
        int sum = 0;
        for (int j : myArr) {
            sum += j;
        }
        return sum;
    }


}
