package class7;

public class Q1 {

    public static int sum(int start, int end) { // 
        if (end > start) { // 
            return end + sum(start, end - 1); // 
        } else {
            return end; // 
        }
    }

    public static void main(String[] args) {
        // This main is for individual testing of Q1.
        // App.java will call the sum method directly or this main.
        int result = sum(6, 10); // 
        System.out.println("Q1 Result: " + result);
    }

    // Method for App.java to call to get the result
    public static int getResult() {
        return sum(6, 10);
    }

}
