public class AdvQueue extends MyQueue {
    public AdvQueue() {
        super();
    }

    public AdvQueue(int capacity) {
        super(capacity);
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            if (queue[index] == value) {
                return true;
            }
        }
        return false;
    }
    
    public void clear(){
        front = 0;
        rear = -1;
        size = 0;
        queue = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }

    public int getFront() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot get front element.");
            return -1; // or throw an exception
        }
        return queue[front];
    }
    public int getRear() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot get rear element.");
            return -1; // or throw an exception
        }
        return queue[rear];
    }
    
}
