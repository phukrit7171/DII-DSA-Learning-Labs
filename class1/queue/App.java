public class App {
    public static void main(String[] args) {
        AdvQueue queue = new AdvQueue(2);
        queue.enQueue(1);
        queue.enQueue(2);
        
        System.out.println("Front element: " + queue.getFront()); // Should print 1
        System.out.println("Rear element: " + queue.getRear()); // Should print 2
        System.out.println("Queue size: " + queue.getSize()); // Should print 2
        System.out.println("Is queue empty? " + queue.isEmpty()); // Should print false
        System.out.println("Is queue full? " + queue.isFull()); // Should print false
        System.out.println("Searching for 1: " + queue.search(1)); // Should print true
        System.out.println("Searching for 3: " + queue.search(3)); // Should print false

        int first = queue.deQueue();
        System.out.println("Dequeueing: " + first);
        if (first == 1 && queue.deQueue() == 2 && queue.isEmpty()) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
