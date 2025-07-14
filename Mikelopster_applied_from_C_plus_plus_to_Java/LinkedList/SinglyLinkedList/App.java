package Mikelopster_applied_from_C_plus_plus_to_Java.LinkedList.SinglyLinkedList;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // test Node class
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2, node1);
        Node<Integer> node3 = new Node<>(3, node2);
        System.out.println("Node 1: " + node1.getData()); // Output: Node 1: 1
        System.out.println("Node 2: " + node2.getData()); // Output: Node 2: 2
        System.out.println("Node 3: " + node3.getData()); // Output: Node 3: 3
        System.out.println("Node 2 next: " + node2.getNext().getData()); // Output: Node 2 next: 1
        System.out.println("Node 3 next: " + node3.getNext().getData()); // Output: Node 3 next: 2
        System.out.println("Node 1 is empty: " + node1.isEmpty()); // Output: Node 1 is empty: false
        System.out.println("Node 2 is last: " + node2.isLast()); // Output: Node 2 is last: false
        System.out.println("Node 3 is first: " + node3.isFirst()); // Output: Node 3 is first: false
        System.out.println("Node 2 is middle: " + node2.isMiddle()); // Output: Node 2 is middle: true
        System.out.println("Node 3 is tail: " + node3.isTail()); // Output: Node 3 is tail: false
        System.out.println("Node 1 is head: " + node1.isHead()); // Output: Node 1 is head: false
        System.out.println("Node 2 is head: " + node2.isHead()); // Output: Node 2 is head: false
        System.out.println("Node 3 is head: " + node3.isHead()); // Output: Node 3 is head: false
        System.out.println("Node 1 is tail: " + node1.isTail()); // Output: Node 1 is tail: true
        System.out.println("Node 2 is tail: " + node2.isTail()); // Output: Node 2 is tail: false
        System.out.println("Node 3 is tail: " + node3.isTail()); // Output: Node 3 is tail: false
        System.out.println("Node 1: " + node1); // Output: Node 1: Node{data=1, next=null}
        System.out.println("Node 2: " + node2); // Output: Node 2: Node{data=2, next=Node{data=1, next=null}}
        System.out.println("Node 3: " + node3); // Output: Node 3: Node{data=3, next=Node{data=2, next=Node{data=1, next=null}}}
        System.out.println("Node 1 toString: " + node1.toString()); // Output: Node 1 toString: Node{data=1, next=null}
        System.out.println("Node 2 toString: " + node2.toString()); // Output: Node 2 toString: Node{data=2, next=Node{data=1, next=null}}
        System.out.println("Node 3 toString: " + node3.toString()); // Output: Node 3 toString: Node{data=3, next=Node{data=2, next=Node{data=1, next=null}}}
    }
}
