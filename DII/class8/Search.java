public class Search {
    public static void ForLoopSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                System.out.println("The number " + x + " is found at index " + i);
                return;
            }
        }
        System.out.println("The number " + x + " is not in the array");
    }

    public static void BinarySearch(int[] a, int x) {
        BinarySearch_recur(a, x, 0, a.length - 1);
    }

    private static void BinarySearch_recur(int[] a, int x, int left, int right) {
        if (left > right) {
            System.out.println("The number " + x + " is not in the array");
            return;
        }

        // Find the middle index
        int mid = left + (right - left) / 2;

        // Check if the middle element is the target
        if (a[mid] == x) {
            System.out.println("The number " + x + " is found at index " + mid);
            return;
        }

        // If target is smaller, search the left half
        if (x < a[mid]) {
            BinarySearch_recur(a, x, left, mid - 1);
        }
        // If target is larger, search the right half
        else {
            BinarySearch_recur(a, x, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        // Q1
        System.out.println("Q1: For Loop Search");
        int[] a = { 6, 1, 2, 3, 4, 5, 0, 7, 8, 9 };
        for (int i = 0; i <= 10; i++) {
            int x = i;
            System.out.print("Searching for " + x + ": ");
            ForLoopSearch(a, x);
        }


        //Q2
        System.out.println("\nQ2: Binary Search");
        int[] a_sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 9; i >= 0; i--) {
            int x = i;
            System.out.print("Searching for " + x + ": ");
            BinarySearch(a_sorted, x);
        }

    }
}