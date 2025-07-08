import java.util.Arrays;
public class Q1 {
    public static void main(String[] args) {
        int[] b = {24,13,26,1,2,27,38};
        System.out.println(Arrays.toString(b));
        q2_1(b);
    }

    public static void q2_1(int[] b) {
        if (b.length <= 1) {
            return;
        }
        int mid = (b.length%2==0)?b.length/2:b.length/2+1;
        int[] left = Arrays.copyOfRange(b, 0, mid);
        System.out.println(Arrays.toString(left));
        q2_1(left);
        int[] right = Arrays.copyOfRange(b, mid, b.length);
        System.out.println(Arrays.toString(right));
        q2_1(right);
  
    }
}