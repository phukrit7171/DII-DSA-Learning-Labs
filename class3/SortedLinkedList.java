package class3;

public class SortedLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SortedLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int element) {
        Node newNode = new Node(element);
        if (head == null || head.getElement() >= element) {
            newNode.setNextNode(head);
            if (head != null) {
                head.setPrevNode(newNode);
            }
            head = newNode;
            if (tail == null) { // list was empty
                tail = newNode;
            }
        } else {
            Node current = head;
            while (current.getNextNode() != null && current.getNextNode().getElement() < element) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
            if (newNode.getNextNode() == null) {
                tail = newNode;
            }
        }
        size++;
    }

    public void removeMin() {
        if (head != null) {
            head = head.getNextNode();
            if (head == null) { // list became empty
                tail = null;
            }
            size--;
        } else {
            System.out.println("List is empty, nothing to remove.");
        }
    }

    public int getMin() {
        if (head != null) {
            return head.getElement();
        } else {
            System.out.println("List is empty, no minimum element.");
            return -1; // or throw an exception
        }
    }

    public void removeMax() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        if (head.getNextNode() == null) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.getNextNode() != tail) {
                current = current.getNextNode();
            }
            current.setNextNode(null);
            tail = current;
        }
        size--;
    }

    public int getMax() {
        if (tail == null) {
            System.out.println("List is empty, no maximum element.");
            return -1; // or throw an exception
        }
        return tail.getElement();
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }

    public void printOdd() {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index % 2 == 1) {
                System.out.print(current.getElement() + " ");
            }
            current = current.getNextNode();
            index++;
        }
        System.out.println();
    }

    public void printEven() {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index % 2 == 0) {
                System.out.print(current.getElement() + " ");
            }
            current = current.getNextNode();
            index++;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int indexOfElement(int element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getElement() == element) {
                return index;
            }
            current = current.getNextNode();
            index++;
        }
        return -1; // Element not found
    }

    public void removeDuplicate() {
        Node current = head;
        while (current != null && current.getNextNode() != null) {
            if (current.getElement() == current.getNextNode().getElement()) {
                current.setNextNode(current.getNextNode().getNextNode());
                size--;
            } else {
                current = current.getNextNode();
            }
        }
        // Update tail reference after duplicate removal.
        tail = current;
    }
    
    public void removeElement(int element) {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        if (head.getElement() == element) {
            head = head.getNextNode();
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }
        Node current = head;
        while (current.getNextNode() != null && current.getNextNode().getElement() != element) {
            current = current.getNextNode();
        }
        if (current.getNextNode() != null) {
            if (current.getNextNode() == tail) {
                tail = current;
            }
            current.setNextNode(current.getNextNode().getNextNode());
            size--;
        } else {
            System.out.println("Element not found in the list.");
        }
    }

    public void printReverse() {
        if (head == null) {
            System.out.println("List is empty, nothing to print.");
            return;
        }

        Node originalHead = head;
        Node originalTail = tail;

        // Reverse the list
        Node current = head;
        Node prev = null;
        Node next = null;
        tail = head; // Original head becomes the new tail

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(prev);
            current.setPrevNode(next);
            prev = current;
            current = next;
        }
        head = prev;

        // Print the reversed list
        System.out.println("Reversed List:");
        printAll();

        // Reverse the list again to restore the original order
        current = head;
        prev = null;
        next = null;
        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(prev);
            current.setPrevNode(next);
            prev = current;
            current = next;
        }
        head = prev;

        // Restore the original head and tail
        head = originalHead;
        tail = originalTail;
    }
}
