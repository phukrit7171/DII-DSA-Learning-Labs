package class2.LlinkedList;

public class BasicLinkedList {
    protected MyNode head;

    public BasicLinkedList() {
        this.head = null;
    }

    public void addFirst(int x){
        MyNode newNode = new MyNode(x);
        newNode.setNextNode(head);
        head = newNode;
    }

    public void removeFirst(){
        if (head != null) {
            head = head.getNextNode();
        } else {
            System.out.println("List is empty, nothing to remove.");
        }
    }

    public int getFirst(){
        if (head != null) {
            return head.getElement();
        } else {
            System.out.println("List is empty, no first element.");
            return -1; // or throw an exception
        }
    }

    public void printAll(){
        MyNode current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    public int getSize(){
        int size = 0;
        MyNode current = head;
        while (current != null) {
            size++;
            current = current.getNextNode();
        }
        return size;
    }
}