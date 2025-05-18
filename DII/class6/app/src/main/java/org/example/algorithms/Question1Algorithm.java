package org.example.algorithms;

/**
 * Question 1: Array processing algorithm
 * This implementation includes both array transformation and aggregation
 */
public class Question1Algorithm implements PerformanceTestable {
    @Override
    public void execute(int[] array, int[] newArray) {
        if (array == null || newArray == null || array.length != newArray.length) {
            if (array != null && array.length == 0) return; // Handle empty array case gracefully
            if (array == null || newArray == null) return; // Cannot proceed
        }
        if (array.length == 0) return;

        // First pass: Transform the input array
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }

        // Second pass: Calculate aggregated values
        for (int i = 0; i < array.length; i++) {
            newArray[i] = 0;
            for (int j = 0; j < array.length; j++) {
                newArray[i] += array[i];
                newArray[i] += array[j];
            }
        }
    }
}
