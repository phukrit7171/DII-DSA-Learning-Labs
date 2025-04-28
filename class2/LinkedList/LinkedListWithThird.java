package class2.LinkedList;

public class LinkedListWithThird extends BasicLinkedList {
    public int getThird() {
        if (head == null || head.getNextNode() == null || head.getNextNode().getNextNode() == null) {
            System.out.println("List has less than three elements, no third element.");
            return -1; // or throw an exception
        }
        return head.getNextNode().getElement();
    }
    
    public void addThird(int x) {
        MyNode newNode = new MyNode(x);
        if (head == null || head.getNextNode() == null) {
            System.out.println("List has less than two elements, cannot add third element.");
            return; // or throw an exception
        }
        newNode.setNextNode(head.getNextNode().getNextNode());
        head.getNextNode().setNextNode(newNode);
    }

    public void removeThird() {
       if (head == null || head.getNextNode() == null || head.getNextNode().getNextNode() == null) {
            System.out.println("List has less than three elements, nothing to remove.");
            return;
        }
        head.getNextNode().setNextNode(head.getNextNode().getNextNode().getNextNode());
    }
}
