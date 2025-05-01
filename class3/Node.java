package class3;

public class Node {
    int element;
    Node nextNode;
    Node prevNode;


    public Node(int element) {
        this.element = element;
        this.nextNode = null;
        this.prevNode = null;
    }
    public int getElement() {
        return element;
    }
    public void setElement(int element) {
        this.element = element;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    public Node getPrevNode() {
        return prevNode;
    }
    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }
    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", nextNode=" + nextNode +
                ", prevNode=" + prevNode +
                '}';
    }
    public void printNode() {
        System.out.println(this.toString());
    }
}
