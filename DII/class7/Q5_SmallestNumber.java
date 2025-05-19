package class7;

public class Q5_SmallestNumber {

    // a. Using loop
    public static int findSmallestLoop(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    // b. Using recursion
    public static int findSmallestRecursive(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        return findSmallestRecursiveHelper(arr, 0, arr[0]);
    }

    private static int findSmallestRecursiveHelper(int[] arr, int index, int currentSmallest) {
        if (index == arr.length) {
            return currentSmallest;
        }
        int newSmallest = currentSmallest;
        if (arr[index] < currentSmallest) {
            newSmallest = arr[index];
        }
        return findSmallestRecursiveHelper(arr, index + 1, newSmallest);
    }

    public static void main(String[] args) {
        // For individual testing
        int[] exampleArray = {5, 3, 9, 1, 7, 2, 8};
        System.out.println("Smallest (Loop): " + findSmallestLoop(exampleArray));
        System.out.println("Smallest (Recursive): " + findSmallestRecursive(exampleArray));

        // Timing comparison
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 100000);
        }

        long startLoop = System.nanoTime();
        int loopResult = findSmallestLoop(largeArray);
        long endLoop = System.nanoTime();
        System.out.println("Loop result: " + loopResult + ", Time (ns): " + (endLoop - startLoop));

        long startRec = System.nanoTime();
        int recResult = findSmallestRecursive(largeArray);
        long endRec = System.nanoTime();
        System.out.println("Recursive result: " + recResult + ", Time (ns): " + (endRec - startRec));
    }
}