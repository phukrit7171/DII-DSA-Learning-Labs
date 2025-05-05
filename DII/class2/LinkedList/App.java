package class2.LinkedList;

public class App {
    public static void main(String[] args) {
        // Testing all types of linked lists
        BasicLinkedList basicList = new BasicLinkedList();
        basicList.addFirst(10);
        basicList.addFirst(20);
        basicList.addFirst(30);
        System.out.println("Basic Linked List:");
        basicList.printAll();
        System.out.println("Size: " + basicList.getSize());

        EnhancedLinkedList enhancedList = new EnhancedLinkedList();
        enhancedList.addFirst(5);
        enhancedList.addFirst(15);
        enhancedList.addFirst(25);
        System.out.println("\nEnhanced Linked List:");
        enhancedList.printAll();
        System.out.println("Size: " + enhancedList.getSize());

        LinkedListWithThird thirdList = new LinkedListWithThird();
        thirdList.addFirst(100);
        thirdList.addFirst(200);
        thirdList.addFirst(300);
        System.out.println("\nLinked List with Third Element Access:");
        thirdList.printAll();
        System.out.println("Third element: " + thirdList.getThird());
    }
}
