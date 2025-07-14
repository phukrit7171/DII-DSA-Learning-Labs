import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class lab11 {
    // Question 1.1: Add nodes left to right
    public static node add_left_to_right(int n, int max_child_node) {
        if (n <= 0) return null;
        
        node root = new node<Integer>(null, 1);
        Queue<node> queue = new LinkedList<>();
        queue.offer(root);
        
        int currentValue = 2;
        
        while (!queue.isEmpty() && currentValue <= n) {
            node current = queue.poll();
            
            // Add children to current node (up to max_child_node)
            for (int i = 0; i < max_child_node && currentValue <= n; i++) {
                node child = new node<Integer>(current, currentValue);
                current.add_child(child);
                queue.offer(child);
                currentValue++;
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        // Test cases
        node root = add_left_to_right(10, 3);
        tree<Integer> tree1 = new tree<Integer>(root);
        
        // Test print_tree
        System.out.println("Original tree:");
        tree1.print_tree(root);
        
        // Test is_leaf_node
        System.out.println("\nLeaf node tests:");
        System.out.println("Root is leaf: " + root.is_leaf_node()); // false
        System.out.println("Node 5 value: " + ((node) ((node) root.get_child().get(0)).get_child().get(0)).get_value()); // 5
        System.out.println("Node 5 is leaf: " + ((node) ((node) root.get_child().get(0)).get_child().get(0)).is_leaf_node()); // true
        
        // Test print_tree_v2
        System.out.println("\nTree v2 (no leaf parents):");
        tree1.print_tree_v2(root);
        
        // Test DFS and BFS (Depth-First Search and Breadth-First Search)
        ((node) tree1.get_root().get_child().get(2)).set_value(5);
        System.out.println("\nAfter changing node 4 to 5:");
        tree1.print_tree_v2(root);
        
        // Test DFS (Depth-First Search)
        System.out.println("\nDFS test:");
        node node1 = tree1.dfs(root, 5);
        System.out.println("Found value: " + node1.get_value()); // 5
        System.out.println("Parent value: " + node1.get_parent().get_value()); // 2
        
        // Test BFS (Breadth-First Search)
        System.out.println("\nBFS test:");
        node node2 = tree1.bfs(root, 5);
        System.out.println("Found value: " + node2.get_value()); // 5
        System.out.println("Parent value: " + node2.get_parent().get_value()); // 1
        
        // Test back tracking
        System.out.println("\nBack tracking tests:");
        node nodeA = tree1.dfs(root, 5);
        node nodeB = tree1.bfs(root, 5);
        
        List<node> ListA = root.get_back_track(nodeA);
        System.out.print("DFS back track: ");
        for (node n : ListA) {
            System.out.print(n.get_value() + "->");
        }
        System.out.println();
        
        List<node> ListB = root.get_back_track(nodeB);
        System.out.print("BFS back track: ");
        for (node n : ListB) {
            System.out.print(n.get_value() + "->");
        }
        System.out.println();
        
        // Test reverse back tracking
        System.out.println("\nReverse back tracking tests:");
        List<node> reverseA = root.get_reverse_back_track(nodeA);
        System.out.print("DFS reverse: ");
        for (node n : reverseA) {
            System.out.print(n.get_value() + "->");
        }
        System.out.println();
        
        List<node> reverseB = root.get_reverse_back_track(nodeB);
        System.out.print("BFS reverse: ");
        for (node n : reverseB) {
            System.out.print(n.get_value() + "->");
        }
    }
}