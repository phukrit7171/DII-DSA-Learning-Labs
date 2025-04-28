package class2.LinkedList;

public class MyNode {
    private int element;
    private MyNode next;
    
    MyNode(int x) {
        this.element = x;
        this.next = null;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public MyNode getNextNode() {
        return next;
    }

    public void setNextNode(MyNode next) {
        this.next = next;
    }    
}
