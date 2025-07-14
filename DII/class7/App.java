package class7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// No Scanner needed here as App.java will use predefined examples from PDF

public class App {
    public static void main(String[] args) {
        System.out.println("===== Lab 6: Recursion - All Answers =====");
        System.out.println("My name: Phu"); // As per your persona
        System.out.println("--------------------------------------------\n");

        // --- Question 1 ---
        System.out.println("--- Question 1 ---");
        System.out.println("Calculated Q1 Result: " + Q1.getResult());
        System.out.println("--------------------------------------------\n");

        // --- Question 2 ---
        System.out.println("--- Question 2 ---");
        System.out.println("Calculated Q2 Result: " + Q2.getResult());
        System.out.println("--------------------------------------------\n");

        // --- Question 3 ---
        System.out.println("--- Question 3 ---");
        System.out.println("Calculated Q3 Result: " + Q3.getResult());
        System.out.println("--------------------------------------------\n");

        // --- Question 4 ---
        System.out.println("--- Question 4 ---");
        List<String> q4TraceOutput = new ArrayList<>();
        int q4Result = Q4.getResultAndTrace(q4TraceOutput);
        System.out.println("Execution Output:");
        for (String line : q4TraceOutput) {
            System.out.println(line);
        }
        System.out.println("Calculated Q4 Result (final return value): " + q4Result);
        System.out.println("--------------------------------------------\n");

        // --- Question 5: Find Smallest Number ---
        System.out.println("--- Question 5: Find Smallest Number ---");
        int[] q5Array = {5, 3, 9, 1, 7, 2, 8};
        System.out.println("Input Array: " + Arrays.toString(q5Array));
        System.out.println("Smallest (Loop): " + Q5_SmallestNumber.findSmallestLoop(q5Array));
        System.out.println("Smallest (Recursive): " + Q5_SmallestNumber.findSmallestRecursive(q5Array));
        System.out.println("--------------------------------------------\n");

        // Timing comparison for large array
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 100000);
        }
        long startLoop = System.nanoTime();
        int loopResult = Q5_SmallestNumber.findSmallestLoop(largeArray);
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;
        long startRec = System.nanoTime();
        int recResult = Q5_SmallestNumber.findSmallestRecursive(largeArray);
        long endRec = System.nanoTime();
        long recTime = endRec - startRec;
        System.out.println("Timing comparison for large array:");
        System.out.println("Loop result: " + loopResult + ", Time (ns): " + loopTime);
        System.out.println("Recursive result: " + recResult + ", Time (ns): " + recTime);
        System.out.println("");

        // --- Question 6: Fibonacci Sequence ---
        System.out.println("--- Question 6: Fibonacci Sequence ---");
        int nFib = 10;
        System.out.println("Calculating Fibonacci for n = " + nFib);
        System.out.println("Fibonacci (Loop): " + Q6_Fibonacci.fibonacciLoop(nFib));
        System.out.println("Fibonacci (Recursive): " + Q6_Fibonacci.fibonacciRecursive(nFib));

        // Timing comparison for moderate n
        int testN = 30;
        long startLoopFib = System.nanoTime();
        long loopResultFib = Q6_Fibonacci.fibonacciLoop(testN);
        long endLoopFib = System.nanoTime();
        long loopTimeFib = endLoopFib - startLoopFib;

        long startRecFib = System.nanoTime();
        long recResultFib = Q6_Fibonacci.fibonacciRecursive(testN);
        long endRecFib = System.nanoTime();
        long recTimeFib = endRecFib - startRecFib;

        System.out.println("\nTiming comparison for n = " + testN + ":");
        System.out.println("Loop result: " + loopResultFib + ", Time (ns): " + loopTimeFib);
        System.out.println("Recursive result: " + recResultFib + ", Time (ns): " + recTimeFib);

        System.out.println("\n" + Q6_Fibonacci.getPerformanceConsiderations());
        System.out.println("--------------------------------------------\n");

        // --- Question 7: Palindrome Checker ---
        System.out.println("--- Question 7: Palindrome Checker ---");
        String[] q7TestCases = {"mom", "civic", "level", "racecar", "hello", "", "a"}; // for first 3
        for (String testStr : q7TestCases) {
            System.out.println("Is '" + (testStr.isEmpty() ? "<empty string>" : testStr) + 
                               "' a palindrome? " + Q7_Palindrome.isPalindrome(testStr));
        }
        System.out.println("--------------------------------------------\n");

        // --- Question 8: Output Pairs ---
        System.out.println("--- Question 8: Output Pairs ---"); // 
        System.out.println("Example 1 (Input: {3, 2, 1}):"); // 
        int[] q8Input1 = {3, 2, 1};
        System.out.println("Output: " + String.join(" ", Q8_OutputPairs.getAllPairs(q8Input1)));

        System.out.println("\nExample 2 (Input: {1, 4, 5, 2}):"); // 
        int[] q8Input2 = {1, 4, 5, 2};
        System.out.println("Output: " + String.join(" ", Q8_OutputPairs.getAllPairs(q8Input2)));
        
        System.out.println("\nExample 3 (Input: {8, 4, 3, 1, 6}):"); // 
        int[] q8Input3 = {8, 4, 3, 1, 6};
        System.out.println("Output: " + String.join(" ", Q8_OutputPairs.getAllPairs(q8Input3)));
        System.out.println("--------------------------------------------\n");

        System.out.println("===== End of Lab 6 Answers =====");
    }
}
