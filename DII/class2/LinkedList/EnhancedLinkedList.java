package class2.LinkedList;

public class EnhancedLinkedList extends BasicLinkedList {
    public int getLast() {
        if (head == null) {
            System.out.println("List is empty, no last element.");
            return -1; // or throw an exception
        }
        MyNode current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        return current.getElement();
    }

    public void addLast(int x) {
        MyNode newNode = new MyNode(x);
        if (head == null) {
            head = newNode;
        } else {
            MyNode current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        if (head.getNextNode() == null) {
            head = null;
            return;
        }
        MyNode current = head;
        while (current.getNextNode().getNextNode() != null) {
            current = current.getNextNode();
        }
        current.setNextNode(null);
    }

    public boolean search(int x) {
        MyNode current = head;
        while (current != null) {
            if (current.getElement() == x) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    public void remove(int x) {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        if (head.getElement() == x) {
            head = head.getNextNode();
            return;
        }
        MyNode current = head;
        while (current.getNextNode() != null && current.getNextNode().getElement() != x) {
            current = current.getNextNode();
        }
        if (current.getNextNode() != null) {
            current.setNextNode(current.getNextNode().getNextNode());
        } else {
            System.out.println("Element not found in the list.");
        }
    }
}
