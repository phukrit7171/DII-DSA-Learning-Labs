import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {

    private Node<Integer> root;

    Tree() {
        this.root = null;
    }

    void insert(Node<Integer> node, Integer data) {
        if (node == null) {
            node = new Node<>(data); // Create a new node if the current node is null
            this.root = node;
        } else {
            if (data < node.getData()) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node<>(data)); // Insert new node as left child
                } else {
                    insert(node.getLeft(), data); // Recur to the left subtree
                }
            } else if (data > node.getData()) {
                if (node.getRight() == null) {
                    node.setRight(new Node<>(data)); // Insert new node as right child
                } else {
                    insert(node.getRight(), data); // Recur to the right subtree
                }
            } else {
                System.out.println("Value already exists in the tree: " + data); // Handle duplicate values
            }
        }
    }

    Node<Integer> getRoot() {
        return root; // Getter for the root node
    }

    void breadthFirstSearch(Node<Integer> node) {
        if (node == null) return;
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            System.out.print(current.getData() + " "); // Print the current node's data
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    void depthFirstSearch(Node<Integer> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        depthFirstSearch(node.getLeft());
        depthFirstSearch(node.getRight());
    }

    public static void main(String[] args) {
        Tree<Integer> tree1 = new Tree<>();
        tree1.insert(tree1.getRoot(), 1);
        tree1.insert(tree1.getRoot(), 2);
        tree1.insert(tree1.getRoot(), 3);
        tree1.insert(tree1.getRoot(), 4);
        tree1.insert(tree1.getRoot(), 5);

        tree1.breadthFirstSearch(tree1.getRoot()); // Perform breadth-first search starting from the root
        System.out.println(); // Print a new line after the search output
        tree1.depthFirstSearch(tree1.getRoot()); // Perform depth-first search starting from the root
        System.out.println(); // Print a new line after the search output
    }
}

class Node<T> {
    private final T data; // Data stored in the node
    private Node<T> left; // Pointer to the left child node
    private Node<T> right; // Pointer to the right child node
    // Constructor to initialize the node with data

    public Node(T data) {
        this.data = data; // Set the data of the node
        this.left = null; // Initialize the left child pointer to null
        this.right = null; // Initialize the right child pointer to null
    }

    // Constructor to initialize the node with data, left child, and right child
    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data; // Set the data of the node
        this.left = left; // Set the left child pointer to the provided node
        this.right = right; // Set the right child pointer to the provided node
    }

    public T getData() {
        return data; // Getter for the data of the node
    }

    public Node<T> getLeft() {
        return left; // Getter for the left child node
    }

    public Node<T> getRight() {
        return right; // Getter for the right child node
    }

    public void setLeft(Node<T> left) {
        this.left = left; // Setter for the left child node
    }

    public void setRight(Node<T> right) {
        this.right = right; // Setter for the right child node
    }

}