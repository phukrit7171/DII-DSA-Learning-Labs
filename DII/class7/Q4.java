package class7;

import java.util.ArrayList;
import java.util.List;

public class Q4 {

    // To capture the "ab = " print outputs in order for App.java
    public static List<String> sideEffectPrints = new ArrayList<>();

    public static int funny(int x, int y, int z) {
        int a, b;
        if (z == 3) {
            return y;
        } else if (z == 4) {
            return 1;
        } else {
            a = funny(x, y - 1, z + 1);
            b = funny(x, y - 1, z + 2);
            int k = a + b;
            // System.out.println("ab = " + k); // Original print
            sideEffectPrints.add("ab = " + k); // Capture for App.java
            return a + b;
        }
    }

    public static void main(String[] args) {
        // This main is for individual testing of Q4.
        // App.java will handle the output differently to show sequence.
        sideEffectPrints.clear(); // Clear for standalone run
        System.out.println("Hello"); // First output
        int result = funny(5, 5, 0);
        for (String s : sideEffectPrints) {
            System.out.println(s);
        }
        System.out.println("Q4 Result: " + result); // Final numeric result
    }

    // Method for App.java to call
    public static int getResultAndTrace(List<String> traceOutputCollector) {
        sideEffectPrints.clear(); // Clear before a new run
        traceOutputCollector.add("Hello"); // First output
        int finalResult = funny(5, 5, 0);
        traceOutputCollector.addAll(sideEffectPrints); // Add the "ab = " lines
        return finalResult;
    }
    
}
