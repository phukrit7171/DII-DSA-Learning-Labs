public class MyQueue {
    protected int[] queue;
    protected int front;
    protected int rear;
    protected int size;
    protected int capacity;
    protected static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }
    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enQueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public int deQueue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // or throw an exception
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }


}