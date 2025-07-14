package org.example.algorithms;

/**
 * Question 3: Array processing with polynomial complexity
 * This implementation demonstrates O(n^3) complexity for comprehensive performance testing
 */
public class Question3Algorithm implements PerformanceTestable {
    @Override
    public void execute(int[] array, int[] newArray) {
        if (array == null || newArray == null || array.length != newArray.length) {
            if (array != null && array.length == 0) return;
            if (array == null || newArray == null) return;
        }
        if (array.length == 0) return;

        // O(n^3) complexity implementation
        for (int i = 0; i < array.length; i++) {
            newArray[i] = 0;
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k <= j; k++) {
                    // Complex calculation to demonstrate significant computation time
                    int temp = array[k];
                    for (int l = 0; l < 5; l++) {  // Small constant loop to make operations more visible
                        temp = (temp * 2 + array[j]) / 2;
                    }
                    newArray[i] += temp;
                }
            }
        }
    }
}
