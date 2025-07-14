
public class App {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            // Test case 1: Basic Functionality
            AdvStack stack = new AdvStack(5);
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println("Popped: " + stack.pop()); // Expected: 30
            System.out.println("Popped: " + stack.pop()); // Expected: 20
            System.out.println("Popped: " + stack.pop()); // Expected: 10
            System.out.println("Popped: " + stack.pop()); // Expected: Stack is empty. Cannot pop.
            // Test case 2: Stack Overflow
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.push(60); // Expected: Stack is full. Cannot push 60
            // Test case 3: Stack Underflow
            stack.pop(); // Expected: 50
            stack.pop(); // Expected: 40
            stack.pop(); // Expected: 30
            stack.pop(); // Expected: 20
            stack.pop(); // Expected: 10
            stack.pop(); // Expected: Stack is empty. Cannot pop.
            // Test case 4: Peek
            stack.push(100);
            stack.push(200);
            System.out.println("Peek: " + stack.peek()); // Expected: 200
            // Test case 5: Search
            System.out.println("Search 100: " + stack.search(100)); // Expected: true
            System.out.println("Search 300: " + stack.search(300)); // Expected: false
            // Test case 6: Clear
            stack.clear(); // Expected: Stack cleared.
            System.out.println("Popped after clear: " + stack.pop()); // Expected: Stack is empty. Cannot pop.
            // Test case 7: Double Push and Pop
            stack.doublePush(1, 2);
            stack.doublePush(3, 4);
            System.out.println("Double Pop: " + stack.doublePop()); // Expected: 4
            System.out.println("Double Pop: " + stack.doublePop()); // Expected: 2
            System.out.println("Double Pop: " + stack.doublePop()); // Expected: Stack is empty. Cannot double pop.
            // Test case 8: Double Push Overflow
            stack.doublePush(5, 6);
            stack.doublePush(7, 8);
            stack.doublePush(9, 10); // Expected: Stack is full. Cannot double push 9 and 10
            // Test case 9: Double Pop Underflow
            stack.pop(); // Expected: 8
            stack.pop(); // Expected: 7
            stack.pop(); // Expected: 6
            stack.pop(); // Expected: 5
            stack.pop(); // Expected: Stack is empty. Cannot pop.
            // Test case 10: Double Pop with Empty Stack
            stack.doublePop(); // Expected: Stack is empty. Cannot double pop.
            // Test case 11: Double Push with Empty Stack
            stack.doublePush(11, 12); // Expected: Stack is empty. Cannot double push 11 and 12
            // Test case 12: Double Push with Full Stack
            stack.push(13);
            stack.push(14);
            stack.push(15);
            stack.push(16);
            stack.push(17);
            stack.push(18);
            stack.doublePush(19, 20); // Expected: Stack is full. Cannot double push 19 and 20
            // Test case 13: Double Pop with Full Stack
            stack.doublePop(); // Expected: 18
            stack.doublePop(); // Expected: 16
            stack.doublePop(); // Expected: 14
            stack.doublePop(); // Expected: 12
            stack.doublePop(); // Expected: 10
            stack.doublePop(); // Expected: Stack is empty. Cannot double pop.

            // Test case 14: Clear
            stack.clear(); // Expected: Stack cleared.
        }


        // --------------- Teacher Test ------------------
        System.out.println("---AdvStack---");
        AdvStack AdvStack1 = new AdvStack(4);
        AdvStack1.pop();
        AdvStack1.push(1);
        AdvStack1.push(2);
        System.out.println(AdvStack1.pop());
        System.out.println(AdvStack1.peek());
    }

}