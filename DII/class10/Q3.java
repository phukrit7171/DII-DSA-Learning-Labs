import java.util.Arrays;
import java.util.Random;

public class Q3 {
    public static void main(String[] args) {
        q3_1();
    }
    static void q3_1() {
        for (int i = 0; i < 100; i++) {
            int[] arr = nodup_array(10000);
            float start = System.nanoTime()* 1e-6f; //convert to milliseconds
            mergesort(arr);
            float end = System.nanoTime()* 1e-6f; //convert to milliseconds
            System.out.println((i+1) + ") Elapsed time: " + (end - start)+" ms");
        }
    }

    // Generate a random array of size n with values 1 to n, no duplicates
    static int[] nodup_array(int n) {
        int[] arr = new int[n];
        java.util.Set<Integer> used = new java.util.HashSet<>();
        Random rand = new Random();
        int i = 0;
        while (i < n) {
            int temp = rand.nextInt(n) + 1;
            if (used.add(temp)) {  // add returns true if the element was not already in the set
                arr[i++] = temp;
            }
        }
        return arr;
    }

    // Standard merge sort implementation
    static void mergesort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergesort(left);
        mergesort(right);
        merge(arr, left, right);
    }

    static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
