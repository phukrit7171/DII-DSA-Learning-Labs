package class3;

/**
 * Represents a node in a doubly linked list.
 * This class is intended for use within the 'class3' package.
 */
class Node { // Changed from private static inner class to package-private top-level class
    int element;       // Package-private access
    Node nextNode;     // Package-private access
    Node prevNode;     // Package-private access

    /**
     * Constructor for a Node.
     * @param element The integer data stored in the node.
     */
    public Node(int element) {
        this.element = element;
        this.nextNode = null;
        this.prevNode = null;
    }

    // --- Getters (public for standard access) ---
    public int getElement() { return element; }
    public Node getNextNode() { return nextNode; }
    public Node getPrevNode() { return prevNode; }

    // --- Setters (public for standard access) ---
    public void setNextNode(Node nextNode) { this.nextNode = nextNode; }
    public void setPrevNode(Node prevNode) { this.prevNode = prevNode; }
}