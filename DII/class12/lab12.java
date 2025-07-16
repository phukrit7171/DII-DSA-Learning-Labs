public class lab12 {

    public static void main(String[] args) {
        System.out.println("--- Q1.2: Build and Print BST ---");
        binarysearchtree bst1 = new binarysearchtree();
        bst1.add_node(5);
        bst1.add_node(3);
        bst1.add_node(7);
        bst1.add_node(1);
        bst1.add_node(6);
        bst1.add_node(8);
        bst1.add_node(2);
        
        bst1.print_tree();
        /*
        Expected output:
        root: 5
        p:5 c: {3(0), 7(1), }
        p:3 c: {1(0), }
        p:7 c: {6(0), 8(1), }
        p:1 c: {2(1), }
        */

        System.out.println("\n--- Q1.3: Search in BST ---");
        System.out.println("Search for 5: " + (bst1.search(5) != null ? "Found" : "Not Found"));
        System.out.println("Search for 2: " + (bst1.search(2) != null ? "Found, value=" + bst1.search(2).get_value() : "Not Found"));
        System.out.println("Search for 10: " + (bst1.search(10) != null ? "Found" : "Not Found"));

        System.out.println("\n--- Q1.4: Search Min/Max in Subtrees ---");
        binarytree_node<Integer> root = (binarytree_node<Integer>) bst1.get_root();
        
        binarytree_node<Integer> node_max_left = bst1.search_max_leftside(root);
        System.out.println("Max value in left subtree of root: " + node_max_left.get_value()); // Expected: 2
        
        binarytree_node<Integer> node_min_right = bst1.search_min_rightside(root);
        System.out.println("Min value in right subtree of root: " + node_min_right.get_value()); // Expected: 6
    }
}