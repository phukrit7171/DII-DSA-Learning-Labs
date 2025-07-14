package class7;

public class Q6_Fibonacci {

    // a. Using loop
    public static long fibonacciLoop(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n <= 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        long fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // b. Using recursion (naive)
    public static long fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        // For individual testing
        int n = 10;
        System.out.println("Fibonacci of " + n + " (Loop): " + fibonacciLoop(n));
        System.out.println("Fibonacci of " + n + " (Recursive): " + fibonacciRecursive(n));

        // Timing comparison for moderate n (recursive is slow for large n)
        int testN = 30;
        long startLoop = System.nanoTime();
        long loopResult = fibonacciLoop(testN);
        long endLoop = System.nanoTime();
        System.out.println("Loop result for n=" + testN + ": " + loopResult + ", Time (ns): " + (endLoop - startLoop));

        long startRec = System.nanoTime();
        long recResult = fibonacciRecursive(testN);
        long endRec = System.nanoTime();
        System.out.println("Recursive result for n=" + testN + ": " + recResult + ", Time (ns): " + (endRec - startRec));
    }
    
    public static String getPerformanceConsiderations() {
        return "Performance Discussion (Q5 & Q6):\n" +
               "Question 5 (Find Smallest):\n" +
               "  - Loop version is generally faster. Both are O(n), but recursion has function call overhead.\n" +
               "  - Deep recursion can cause StackOverflowError for very large arrays.\n" +
               "Question 6 (Fibonacci - Naive Recursive):\n" +
               "  - Loop version is significantly faster (O(n)).\n" +
               "  - Naive recursive version is very slow (O(2^n)) due to recalculating the same values multiple times.\n" +
               "In general, for these specific problems, iterative solutions offer better performance and avoid recursion depth limits.";
    }
}