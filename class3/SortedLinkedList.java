package class3;

import java.util.NoSuchElementException; // Import for potential exception throwing

/**
 * Implements a Sorted Doubly Linked List for integer elements using a separate Node class.
 * Elements are automatically kept in ascending order.
 * Optimized for head and tail operations.
 */
public class SortedLinkedList {

    // No Node inner class definition here anymore

    // Instance variables for the SortedLinkedList
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructor for an empty SortedLinkedList.
     */
    public SortedLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an integer element to the list in its sorted position.
     * Maintains the doubly linked structure.
     * Optimized for adding at the beginning or end (O(1)).
     *
     * @param element The integer element to add.
     */
    public void add(int element) {
        Node newNode = new Node(element); // Uses the separate Node class

        if (isEmpty()) { // Case 1: Empty list
            head = newNode;
            tail = newNode;
        } else if (element <= head.getElement()) { // Case 2: Insert at head
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            head = newNode;
        } else if (element >= tail.getElement()) { // Case 3: Insert at tail (O(1) optimization)
             newNode.setPrevNode(tail);
             tail.setNextNode(newNode);
             tail = newNode;
        } else { // Case 4: Insert in the middle
            Node current = head;
            // Find node *before* the insertion point
            while (current.getNextNode() != null && current.getNextNode().getElement() < element) {
                 current = current.getNextNode();
            }
            // Now 'current' is the node before the insertion point
            Node nodeAfter = current.getNextNode(); // Node that will be after newNode

            // Link newNode into the list
            newNode.setNextNode(nodeAfter);
            newNode.setPrevNode(current);
            current.setNextNode(newNode);
            // nodeAfter cannot be null here because we handled the tail case
            nodeAfter.setPrevNode(newNode); // Crucial link back from nodeAfter
        }
        size++;
    }

    /**
     * Removes the minimum element (head) from the list. O(1) operation.
     * Throws NoSuchElementException if the list is empty.
     */
    public void removeMin() {
        if (isEmpty()) {
             System.out.println("List is empty, nothing to remove."); // Or throw exception
             // throw new NoSuchElementException("Cannot remove min from empty list.");
             return;
        }
        head = head.getNextNode(); // Move head forward
        if (head != null) {
            head.setPrevNode(null); // New head has no previous node
        } else { // List became empty
            tail = null;
        }
        size--;
    }

    /**
     * Returns the minimum element (head's element) without removing it. O(1) operation.
     * Throws NoSuchElementException if the list is empty.
     *
     * @return The minimum integer element.
     */
    public int getMin() {
        if (isEmpty()) {
             System.out.println("List is empty, no minimum element."); // Or throw exception
             // throw new NoSuchElementException("Cannot get min from empty list.");
             return -1; // Return dummy value if not throwing exception
        }
        return head.getElement();
    }

    /**
     * Removes the maximum element (tail) from the list. O(1) operation.
     * Throws NoSuchElementException if the list is empty.
     */
    public void removeMax() {
        if (isEmpty()) {
            System.out.println("List is empty, nothing to remove."); // Or throw exception
            // throw new NoSuchElementException("Cannot remove max from empty list.");
            return;
        }
        if (head == tail) { // Case: Single element list
            head = null;
            tail = null;
        } else { // Case: Multiple elements
            // Optimized using tail and prevNode pointer
            tail = tail.getPrevNode(); // Move tail backward
            tail.setNextNode(null); // Disconnect the old tail
        }
        size--;
    }

    /**
     * Returns the maximum element (tail's element) without removing it. O(1) operation.
     * Throws NoSuchElementException if the list is empty.
     *
     * @return The maximum integer element.
     */
    public int getMax() {
        if (isEmpty()) {
             System.out.println("List is empty, no maximum element."); // Or throw exception
             // throw new NoSuchElementException("Cannot get max from empty list.");
             return -1; // Return dummy value if not throwing exception
        }
        return tail.getElement();
    }

    /**
     * Prints all elements in the list in ascending order. O(N) operation.
     */
    public void printAll() {
        System.out.print("List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    /**
     * Prints elements at odd indices (1, 3, 5, ...) in the list. O(N) operation.
     */
    public void printOdd() {
        System.out.print("Odd Indices: ");
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index % 2 != 0) { // Check for odd index
                System.out.print(current.getElement() + " ");
            }
            current = current.getNextNode();
            index++;
        }
        System.out.println();
    }

    /**
     * Prints elements at even indices (0, 2, 4, ...) in the list. O(N) operation.
     */
    public void printEven() {
        System.out.print("Even Indices: ");
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index % 2 == 0) { // Check for even index
                System.out.print(current.getElement() + " ");
            }
            current = current.getNextNode();
            index++;
        }
        System.out.println();
    }

    /**
     * Returns the number of elements in the list. O(1) operation.
     * @return The size of the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the list is empty. O(1) operation.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0; // Or head == null
    }

    /**
     * Finds the index of the first occurrence of a given element. O(N) operation.
     *
     * @param element The element to search for.
     * @return The 0-based index of the element, or -1 if not found.
     */
    public int indexOfElement(int element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getElement() == element) {
                return index;
            }
            // Optimization: Can stop early if current element is greater than target
            if (current.getElement() > element) {
                return -1; // Element cannot be further in the sorted list
            }
            current = current.getNextNode();
            index++;
        }
        return -1; // Element not found
    }

    /**
     * Removes consecutive duplicate elements from the sorted list.
     * Maintains the doubly linked structure and updates tail correctly. O(N) operation.
     */
    public void removeDuplicate() {
        if (size < 2) {
            return; // No duplicates possible
        }

        Node current = head;
        while (current != null && current.getNextNode() != null) {
            if (current.getElement() == current.getNextNode().getElement()) {
                Node nodeToRemove = current.getNextNode();
                Node nodeAfter = nodeToRemove.getNextNode();

                current.setNextNode(nodeAfter); // Bypass the duplicate node

                if (nodeAfter != null) {
                    nodeAfter.setPrevNode(current); // Link back from the node after the removed one
                } else {
                    // The removed node was the tail, so 'current' becomes the new tail
                    tail = current;
                }
                size--;
                // Do not advance 'current' here, the new 'current.getNextNode()'
                // might also be a duplicate of 'current'.
            } else {
                // Only advance if no duplicate was found at the current position
                current = current.getNextNode();
            }
        }
    }

   /**
    * Removes the first occurrence of a specific element from the list.
    * Uses optimized removeMin/removeMax for head/tail cases.
    * Maintains the doubly linked structure. O(N) in the worst case (middle removal).
    *
    * @param element The element to remove.
    */
   public void removeElement(int element) {
       if (isEmpty()) {
           System.out.println("List is empty, cannot remove element " + element);
           return;
       }

       // Case 1: Remove head
       if (head.getElement() == element) {
           removeMin();
           return;
       }

       // Case 2: Remove tail (optimization)
       // Check tail only if element could potentially be the maximum
       if (tail != null && element == tail.getElement()) {
           removeMax();
           return;
       }


       // Case 3: Remove from middle (element must be > head and < tail)
       if (element < head.getElement() || (tail != null && element > tail.getElement())) {
            System.out.println("Element " + element + " not found (outside bounds).");
            return;
       }


       Node current = head.getNextNode(); // Start searching from the second node
       while (current != null && current != tail && current.getElement() < element) {
            // Stop searching if current element is already greater than the target
            if (current.getElement() > element) {
                 System.out.println("Element " + element + " not found (passed possible position).");
                 return;
            }
           current = current.getNextNode();
       }


       // Check if we found the element and it's not the tail (already checked)
       if (current != null && current != tail && current.getElement() == element) {
           Node prevNode = current.getPrevNode();
           Node nextNode = current.getNextNode();

           // Bypass 'current' node
           prevNode.setNextNode(nextNode);
           // nextNode is guaranteed not to be null here because current != tail
           nextNode.setPrevNode(prevNode); // Link back

           size--;
       } else {
           // If loop finished or element not matched, element was not found in the middle
           System.out.println("Element " + element + " not found in the middle.");
       }
   }


    /**
     * Prints all elements in the list in reverse (descending) order.
     * Optimized to use prevNode pointers. O(N) operation.
     */
    public void printReverse() {
        if (isEmpty()) {
            System.out.println("List is empty, nothing to print in reverse.");
            return;
        }
        System.out.print("Reversed List: ");
        Node current = tail; // Start from the tail
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getPrevNode(); // Move backward using prevNode
        }
        System.out.println();
    }

    // --- Main method for simple testing (optional, remains the same) ---
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(2); // Add duplicate
        list.add(1);
        list.add(10);
        list.add(8); // Add duplicate

        System.out.println("Initial List:");
        list.printAll(); // Expected: List: 1 2 2 5 8 8 10
        System.out.println("Size: " + list.getSize()); // Expected: 7
        System.out.println("Min: " + list.getMin()); // Expected: 1
        System.out.println("Max: " + list.getMax()); // Expected: 10

        System.out.println("\nPrinting Reverse:");
        list.printReverse(); // Expected: Reversed List: 10 8 8 5 2 2 1

        System.out.println("\nRemoving Duplicates:");
        list.removeDuplicate();
        list.printAll(); // Expected: List: 1 2 5 8 10
        list.printReverse(); // Expected: Reversed List: 10 8 5 2 1
        System.out.println("Size after removing duplicates: " + list.getSize()); // Expected: 5
        System.out.println("Min: " + list.getMin()); // Expected: 1
        System.out.println("Max: " + list.getMax()); // Expected: 10 (Tail should be updated correctly)


        System.out.println("\nRemoving Min (1):");
        list.removeMin();
        list.printAll(); // Expected: List: 2 5 8 10

        System.out.println("\nRemoving Max (10):");
        list.removeMax();
        list.printAll(); // Expected: List: 2 5 8

        System.out.println("\nRemoving Element 5 (middle):");
        list.removeElement(5);
        list.printAll(); // Expected: List: 2 8

        System.out.println("\nRemoving Element 99 (not found):");
        list.removeElement(99); // Expected: Element 99 not found (outside bounds).
        list.printAll(); // Expected: List: 2 8

        System.out.println("\nRemoving Element 8 (tail):");
        list.removeElement(8);
        list.printAll(); // Expected: List: 2
        System.out.println("Size: " + list.getSize()); // Expected: 1
        System.out.println("Max: " + list.getMax()); // Expected: 2
        System.out.println("Min: " + list.getMin()); // Expected: 2


        System.out.println("\nRemoving Element 2 (head):");
        list.removeElement(2);
        list.printAll(); // Expected: List:
        System.out.println("Size: " + list.getSize()); // Expected: 0
        System.out.println("Is Empty: " + list.isEmpty()); // Expected: true

        System.out.println("\nTrying operations on empty list:");
        list.removeMin(); // Should print message
        list.removeMax(); // Should print message
        list.removeElement(5); // Should print message
        System.out.println("Min: " + list.getMin()); // Should print message and return -1
        System.out.println("Max: " + list.getMax()); // Should print message and return -1
    }
}