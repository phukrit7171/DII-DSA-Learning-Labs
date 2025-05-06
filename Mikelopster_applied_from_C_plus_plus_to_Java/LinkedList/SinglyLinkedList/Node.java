package Mikelopster_applied_from_C_plus_plus_to_Java.LinkedList.SinglyLinkedList;
public class Node<T> {
    private T data; // Data of the node
    private Node<T> next; // Pointer to the next node

    // Constructor to initialize the node with data and next pointer
    public Node(T data) {
        this.data = data; // Set the data of the node
        this.next = null; // Initialize the next pointer to null
    }
    // Constructor to initialize the node with data and next pointer
    public Node(T data, Node<T> next) {
        this.data = data; // Set the data of the node
        this.next = next; // Set the next pointer to the provided node
    }
    // Method to get the data of the node
    public T getData() {
        return data; // Return the data of the node
    }
    // Method to get the next node
    public Node<T> getNext() {
        return next; // Return the next node
    }
    // Method to set the next node
    public void setNext(Node<T> next) {
        this.next = next; // Set the next pointer to the provided node
    }
    // Method to set the data of the node
    public void setData(T data) {
        this.data = data; // Set the data of the node
    }
    // Method to check if the node is empty (i.e., if it has no data)
    public boolean isEmpty() {
        return data == null; // Return true if the data is null, indicating an empty node
    }
    // Method to check if the node is the last node (i.e., if it has no next node)
    public boolean isLast() {
        return next == null; // Return true if the next pointer is null, indicating the last node
    }
    // Method to check if the node is the first node (i.e., if it has no previous node)
    public boolean isFirst() {
        return next != null; // Return true if the next pointer is not null, indicating the first node
    }
    // Method to check if the node is a middle node (i.e., if it has both previous and next nodes)
    public boolean isMiddle() {
        return next != null && next.getNext() != null; // Return true if the next pointer is not null and the next node has a next node
    }
    // Method to check if the node is a tail node (i.e., if it has no next node)
    public boolean isTail() {
        return isLast(); // Return true if the node is the last node
    }
    // Method to check if the node is a head node (i.e., if it has no previous node)
    public boolean isHead() {
        return isFirst(); // Return true if the node is the first node
    }
   // Method to return the string representation of the node
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}'; // Return a string representation of the node with its data and next pointer
    }
    // Method to check if two nodes are equal (i.e., if they have the same data and next pointer)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // If the same object, return true
        if (obj == null || getClass() != obj.getClass()) return false; // If null or different class, return false
        Node<?> node = (Node<?>) obj; // Cast the object to Node
        return data.equals(node.data) && next.equals(node.next); // Check if data and next pointers are equal
    }
    // Method to return the hash code of the node (i.e., a unique identifier for the node)
    @Override
    public int hashCode() {
        int result = data.hashCode(); // Get the hash code of the data
        result = 31 * result + (next != null ? next.hashCode() : 0); // Combine with the hash code of the next pointer
        return result; // Return the final hash code
    }
}