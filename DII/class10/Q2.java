import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[]a = {30,28,5,3,1};
        int[]b = {29,27,5};
        int[]c = q2_2(a,b);
        System.out.println(Arrays.toString(c));

    }

    public static int[] q2_2(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] c = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                c[k++] = left[i++];
            } else {
                c[k++] = right[j++];
            }
        }
        return c;
    }
}


