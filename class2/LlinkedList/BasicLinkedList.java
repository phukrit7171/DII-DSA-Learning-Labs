package class2.LlinkedList;

public class BasicLinkedList {
    private MyNode head;

    public BasicLinkedList() {
    }

    public void addFirst(int x){
        MyNode newNode = new MyNode(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNextNode(head);
            head = newNode;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNextNode();
        }
    }

    public int getFirst() {
        if (head != null) {
            return head.getElement();
        } else {
            throw new IllegalStateException("List is empty");
        }
    }

    public void printAll() {
        MyNode current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    public int getSize() {
        int size = 0;
        MyNode current = head;
        while (current != null) {
            size++;
            current = current.getNextNode();
        }
        return size;
    }
}