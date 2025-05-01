package class3;
public class App {
    public static void main(String[] args) {
        // Create a sorted linked list
        SortedLinkedList sortedList = new SortedLinkedList();
        
        // Add elements to the list
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(8);
        sortedList.add(1);
        
        // Print all elements in the list
        System.out.println("Sorted Linked List: ");
        sortedList.printAll();
        
        // Print odd indexed elements
        System.out.println("Odd Indexed Elements: ");
        sortedList.printOdd();
        
        // Print even indexed elements
        System.out.println("Even Indexed Elements: ");
        sortedList.printEven();
        
        // Get the size of the list
        System.out.println("Size of the list: " + sortedList.getSize());
        
        // Check if the list is empty
        System.out.println("Is the list empty? " + sortedList.isEmpty());
        
        // Get the index of an element
        int elementToFind = 3;
        int index = sortedList.indexOfElement(elementToFind);
        if (index != -1) {
            System.out.println("Element " + elementToFind + " found at index: " + index);
        } else {
            System.out.println("Element " + elementToFind + " not found in the list.");
        }
    }
}