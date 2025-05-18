package org.example.algorithms;

/**
 * Interface for algorithms that can be performance tested
 */
@FunctionalInterface
public interface PerformanceTestable {
    /**
     * Execute the algorithm
     * @param array Input array
     * @param newArray Output array (if needed)
     */
    void execute(int[] array, int[] newArray);
}
