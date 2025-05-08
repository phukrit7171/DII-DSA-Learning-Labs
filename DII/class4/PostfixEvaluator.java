package class4;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a Postfix expression (space-separated tokens):");
        String postfixExpression = scanner.nextLine();

        try {
            int result = evaluatePostfix(postfixExpression);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static int evaluatePostfix(String expression) {
        // Use Stack to store integer operands
        Stack<Integer> operandStack = new Stack<>();

        // Split the expression by spaces to get tokens
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            // Skip empty tokens that might result from multiple spaces
            if (token.isEmpty()) {
                continue;
            }

            // Check if the token is an operator
            if (isOperator(token)) {
                // Need two integer operands for an operation
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid Postfix expression: Not enough operands for operator '" + token + "'");
                }
                // Pop two operands (operand2 is the top, operand1 is below)
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(operand1, operand2, token);
                operandStack.push(result); // Push the integer result back
            } else {
                // Token is likely a number, try to parse it as an integer
                try {
                    int number = Integer.parseInt(token);
                    operandStack.push(number); // Push integer onto the stack
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Postfix expression: Unrecognized token '" + token + "'");
                }
            }
        }

        // After processing all tokens, the stack should contain the final result
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid Postfix expression: Stack has more than one value left after processing");
        }

        return operandStack.pop(); // The final integer result
    }

    // Helper method to check if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    // Helper method to perform the integer arithmetic operation
    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Error: Cannot divide by zero");
                }
                return operand1 / operand2; // Integer division
            case "%":
                 if (operand2 == 0) {
                    throw new IllegalArgumentException("Error: Cannot perform modulo with zero");
                }
                return operand1 % operand2; // Integer modulo
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator); // Should not happen if isOperator check is correct
        }
    }
}