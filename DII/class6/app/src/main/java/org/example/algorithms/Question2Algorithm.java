package org.example.algorithms;

/**
 * Question 2: Array algorithm with conditional complexity
 * Demonstrates O(n^2) complexity for small arrays and O(1) for larger arrays
 */
public class Question2Algorithm implements PerformanceTestable {
    @Override
    public void execute(int[] array, int[] newArray) {
        if (array == null || newArray == null || array.length != newArray.length) {
            if (array != null && array.length == 0) return;
            if (array == null || newArray == null) return;
        }
        if (array.length == 0) return;

        if (array.length <= 5) {
            // For small arrays: O(n^2) complexity
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] * 2;
            }
            for (int i = 0; i < array.length; i++) {
                newArray[i] = 0;
                for (int j = 0; j < array.length; j++) {
                    newArray[i] += array[i];
                    newArray[i] += array[j];
                }
            }
        } else {
            // For larger arrays: O(1) complexity
            // Just copy the first element to demonstrate constant time operation
            if (array.length > 0 && newArray.length > 0) {
                newArray[0] = array[0];
            }
        }
    }
}
