package class7;

public class Q3 {

    public static int funExam(int x, int y, int z) { // 
        if (y == 0) { // 
            return z; // 
        } else {
            int m = funExam(x, y - 1, z + 1); // 
            m = m + z; // 
            return m; // 
        }
    }

    public static void main(String[] args) {
        // This main is for individual testing of Q3.
        int result = funExam(5, 3, 1); // 
        System.out.println("Q3 Result: " + result);
    }

    // Method for App.java to call
    public static int getResult() {
        return funExam(5, 3, 1);
    }

}
