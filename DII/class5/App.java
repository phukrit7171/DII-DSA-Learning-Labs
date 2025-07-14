package class5;
public class App {

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("Starting Algorithm Efficiency Lab Tests");
        System.out.println("Current Date and Time: " + java.time.LocalDateTime.now());
        System.out.println("======================================================");
        System.out.println();

        // --- Run Question 1 ---
        System.out.println("------------------------------------------------------");
        System.out.println("Executing Question 1 Tests...");
        System.out.println("------------------------------------------------------");
        Question1.main(null); // Pass null or new String[]{} for args
        System.out.println();
        System.out.println("Question 1 Tests Completed.");
        System.out.println("------------------------------------------------------");
        System.out.println();

        // --- Run Question 2 ---
        System.out.println("------------------------------------------------------");
        System.out.println("Executing Question 2 Tests...");
        System.out.println("------------------------------------------------------");
        Question2.main(null);
        System.out.println();
        System.out.println("Question 2 Tests Completed.");
        System.out.println("------------------------------------------------------");
        System.out.println();

        // --- Run Question 3 ---
        System.out.println("------------------------------------------------------");
        System.out.println("Executing Question 3 Tests...");
        System.out.println("------------------------------------------------------");
        Question3.main(null);
        System.out.println();
        System.out.println("Question 3 Tests Completed.");
        System.out.println("------------------------------------------------------");
        System.out.println();

        // --- Run Question 4 ---
        System.out.println("------------------------------------------------------");
        System.out.println("Executing Question 4 Tests...");
        System.out.println("------------------------------------------------------");
        Question4.main(null);
        System.out.println();
        System.out.println("Question 4 Tests Completed.");
        System.out.println("------------------------------------------------------");
        System.out.println();

        System.out.println("======================================================");
        System.out.println("All Algorithm Efficiency Lab Tests Finished.");
        System.out.println("======================================================");
    }
}
