package class2.LlinkedList;

public class LinkedListWithThird extends BasicLinkedList {
    public int getThird() {
        if (head == null || head.getNextNode() == null) {
            System.out.println("List has less than two elements, no third element.");
            return -1; // or throw an exception
        }
        MyNode current = head.getNextNode().getNextNode();
        return current.getElement();
    }
    public void addThird(int x) {
        MyNode newNode = new MyNode(x);
        if (head == null || head.getNextNode() == null) {
            System.out.println("List has less than two elements, cannot add third element.");
            return; // or throw an exception
        }
        MyNode current = head.getNextNode().getNextNode();
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
    }

    public void removeThird() {
        if (head == null || head.getNextNode() == null) {
            System.out.println("List has less than two elements, nothing to remove.");
            return; // or throw an exception
        }
        MyNode current = head.getNextNode().getNextNode();
        if (current.getNextNode() != null) {
            current.setNextNode(current.getNextNode().getNextNode());
        } else {
            System.out.println("No third element to remove.");
        }
    }
}