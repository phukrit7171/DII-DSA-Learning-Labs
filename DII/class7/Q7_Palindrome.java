package class7;

public class Q7_Palindrome {

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false; // Or true, based on definition for null, PDF examples are for non-null
        }
        // As per examples (mom, civic), typically case-sensitive, no special char removal mentioned
        // For robustness, one might clean the string first if requirements were different.
        // Let's stick to simple interpretation from "mom", "civic", "level" examples. 
        // If the definition allows mixed case or punctuation, a cleaning step would be:
        // String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // For this lab, assuming input is like examples.
        String currentStr = str; // Use original string based on problem statement
        
        if (currentStr.length() <= 1) {
            return true;
        }
        return isPalindromeRecursiveHelper(currentStr, 0, currentStr.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursiveHelper(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        // For individual testing
        System.out.println("Is 'mom' a palindrome? " + isPalindrome("mom"));
        System.out.println("Is 'level' a palindrome? " + isPalindrome("level"));
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome("hello"));
    }
}