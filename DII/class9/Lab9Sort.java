import java.util.*;

public class Lab9Sort {
    // Q1: Generate array with no duplicates from 1 to n
    public static int[] nodup_array(int n) {
        int[] a = new int[n];
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int idx = 0; idx < n; idx++) {
            int removeIndex = random.nextInt(list.size());
            a[idx] = list.remove(removeIndex);
        }
        return a;
    }

    // Q2: Create spiral pattern 2D array
    public static int[][] q1_1(int n) {
        int size = (int) Math.ceil(Math.sqrt(n));
        int[][] a = new int[size][size];
        int num = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (num <= n) {
                    a[i][j] = num++;
                } else {
                    a[i][j] = -1; 
                }
                System.out.printf("%d", a[i][j]);
            }
            System.out.println();
        }
        return a;
    }
    

    // Q3: Iterative bubble sort with early exit
    public static int[] bubble(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }

    // Q4: Recursive bubble sort
    public static void bubbleSortRecursive(int[] arr, int n) {
        if (n == 1) return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSortRecursive(arr, n - 1);
    }

    // MAIN METHOD
    public static void main(String[] args) {
        // Q1 Test
        int[] randomArr = nodup_array(10);
        System.out.println("Q1 - Random array (no duplicates):");
        System.out.println(Arrays.toString(randomArr));

        // Q2 Test
        int n = 16;
        int[][] spiral = q1_1(n);
        System.out.println("\nQ2 - Spiral pattern of size √" + n + ":");
        for (int[] row : spiral) {
            for (int val : row) System.out.printf("%4d", val);
            System.out.println();
        }

        // Q3 Test (Timing)
        System.out.println("\nQ3 - Iterative Bubble Sort Time (ns):");
        for (int i = 0; i < 5; i++) {
            int[] arr = nodup_array(10000);
            long start = System.nanoTime();
            bubble(arr);
            long end = System.nanoTime();
            System.out.println("Run " + (i + 1) + ": " + (end - start));
        }

        // Q4 Test (Recursive Bubble Sort)
        int[] arrRec = {64, 34, 25, 12, 22, 11, 90};
        bubbleSortRecursive(arrRec, arrRec.length);
        System.out.println("\nQ4 - Recursive Bubble Sort Result:");
        System.out.println(Arrays.toString(arrRec));
    }
}
