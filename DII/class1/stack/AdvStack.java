public class AdvStack extends MyStack {
    private int[] stack;

    public AdvStack(int size) {
        super(size);  // Call parent constructor
        stack = new int[size];
        top = -1;
    }

    public void doublePush(int value1, int value2) {
        if (top >= maxSize - 2) {
            System.out.println("Stack is full. Cannot double push " + value1 + " and " + value2);
            return;
        }
        push(value1);
        push(value2);
    }

    public int doublePop() {
        if (top < 1) {
            System.out.println("Stack is empty. Cannot double pop.");
            return -1;
        }
        int value = super.pop();
        super.pop();
        return value;
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stack[top];
    }

    public boolean search(int value) {
        for (int i = 0; i <= top; i++) {
            if (stack[i] == value) return true;
        }
        return false;
    }

    public void clear() {
        top = -1;
        System.out.println("Stack cleared.");
    }
}