package class4;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExpressionConverterEvaluator {

    // Helper function to check if a token is a supported operator
    private static boolean isOperator(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }
    
    // Helper function to check if a token is numeric (for postfix evaluation)
    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str); // Or Double.parseDouble(str) if supporting floating point
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // OPTIMIZED Method to convert Prefix to Postfix expression
    public static String prefixToPostfix(String prefixExpression) {
        if (prefixExpression == null || prefixExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("Prefix expression cannot be null or empty.");
        }
        
        String[] tokens = prefixExpression.trim().split("\\s+");
        List<String> tokenList = Arrays.asList(tokens);
        Collections.reverse(tokenList); // Process from right to left

        // Use Stack<StringBuilder> for optimization
        Stack<StringBuilder> stack = new Stack<>();

        for (String token : tokenList) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix expression: Not enough operands for operator " + token);
                }
                StringBuilder operand1 = stack.pop();
                StringBuilder operand2 = stack.pop();
                
                // Efficiently build the new expression part
                StringBuilder newExpression = new StringBuilder();
                newExpression.append(operand1).append(" ").append(operand2).append(" ").append(token);
                stack.push(newExpression);
            } else {
                // Push operand as a StringBuilder
                stack.push(new StringBuilder(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression format.");
        }
        return stack.pop().toString();
    }

    // Method to evaluate Postfix expression (already efficient)
    public static int evaluatePostfix(String postfixExpression) {
        if (postfixExpression == null || postfixExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("Postfix expression cannot be null or empty for evaluation.");
        }

        String[] tokens = postfixExpression.trim().split("\\s+");
        Stack<Integer> operandStack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                operandStack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression for evaluation: Not enough operands for operator " + token);
                }
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero during postfix evaluation.");
                        }
                        result = operand1 / operand2; // Integer division
                        break;
                    case "%":
                         if (operand2 == 0) {
                            throw new ArithmeticException("Modulo by zero during postfix evaluation.");
                        }
                        result = operand1 % operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator during postfix evaluation: " + token);
                }
                operandStack.push(result);
            } else {
                 if (!token.trim().isEmpty()) { // Ignore empty tokens if any from multiple spaces
                     throw new IllegalArgumentException("Invalid token during postfix evaluation: " + token);
                 }
            }
        }

        if (operandStack.size() == 1) {
            return operandStack.pop();
        } else {
            throw new IllegalArgumentException("Invalid postfix expression: Malformed or too many operands left after evaluation.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the prefix expression (tokens separated by spaces):");
        // Example 1: + + 4 2 * 3 - 15 1  (Result: 48)
        // Example 2: / - % + 1 2 3 6 + 2 3 (Result: -1)
        String prefixExpr = scanner.nextLine();

        System.out.println("\nInput Prefix Expression: " + prefixExpr);

        try {
            String postfixExpr = prefixToPostfix(prefixExpr);
            System.out.println("Derived Postfix Expression: " + postfixExpr);

            int result = evaluatePostfix(postfixExpr);
            System.out.println("Result: " + result);

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) { // Catch any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // For debugging purposes
        }

        scanner.close();
    }
}