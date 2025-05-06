package Mikelopster_applied_from_C_plus_plus_to_Java.LinkedList.SinglyLinkedList;
public class SinglyLinkedList<T> {
    private Node<T> head; // Head of the linked list
    private Node<T> tail; // Tail of the linked list
    private int size; // Size of the linked list

    // Constructor to initialize an empty linked list
    public SinglyLinkedList() {
        this.head = null; // Initialize head to null
        this.tail = null; // Initialize tail to null
        this.size = 0; // Initialize size to 0
    }
    
    // Method to add a new node at the end of the linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data); // Create a new node with the provided data
        if (head == null) { // If the list is empty
            head = newNode; // Set head to the new node
            tail = newNode; // Set tail to the new node
        } else { // If the list is not empty
            tail.setNext(newNode); // Set the next pointer of the current tail to the new node
            tail = newNode; // Update tail to the new node
        }
        size++; // Increment size of the list
    }

    // Method to remove a node from the linked list
    public void remove(T data) {
        if (head == null) return; // If the list is empty, do nothing

        if (head.getData().equals(data)) { // If the head node contains the data to be removed
            head = head.getNext(); // Update head to the next node
            if (head == null) { // If the list becomes empty
                tail = null; // Update tail to null
            }
            size--; // Decrement size of the list
            return; // Exit the method
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                // Found the node to remove
                if (current.getNext() == tail) {
                    // If removing the tail
                    tail = current;
                    tail.setNext(null);
                } else {
                    // If removing from middle
                    current.setNext(current.getNext().getNext());
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }
}