package class7;

import java.util.ArrayList;
import java.util.List;

public class Q8_OutputPairs {

    // Changed to return a List<String> for easier handling in App.java
    public static List<String> getAllPairs(int[] arr) {
        List<String> pairs = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            // System.out.println("Not enough elements to form pairs."); // Original print
            pairs.add("Not enough elements to form pairs.");
            return pairs;
        }
        generatePairsRecursive(arr, 0, pairs);
        return pairs;
    }

    private static void generatePairsRecursive(int[] arr, int startIndex, List<String> pairs) {
        if (startIndex >= arr.length - 1) {
            return;
        }
        for (int i = startIndex + 1; i < arr.length; i++) {
            pairs.add("{" + arr[startIndex] + "," + arr[i] + "}");
        }
        generatePairsRecursive(arr, startIndex + 1, pairs);
    }

    public static void main(String[] args) {
        // For individual testing
        int[] input1 = {3, 2, 1};
        System.out.println("Input: {3, 2, 1}");
        System.out.println("Output: " + String.join(" ", getAllPairs(input1)));

        int[] input2 = {1, 4, 5, 2};
        System.out.println("\nInput: {1, 4, 5, 2}");
        System.out.println("Output: " + String.join(" ", getAllPairs(input2)));
    }
}