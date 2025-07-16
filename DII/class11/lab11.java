import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lab11 {

    /**
     * Q1.1: สร้าง Tree โดยการเพิ่มโหนดจากซ้ายไปขวา, บนลงล่าง
     * @param n จำนวนโหนดทั้งหมด
     * @param max_child_node จำนวนลูกสูงสุดที่แต่ละโหนดจะมีได้
     * @return โหนดรากของ Tree ที่สร้างขึ้น
     */
    public static node<Integer> add_left_to_right(int n, int max_child_node) {
        if (n <= 0) {
            return null;
        }
        // สร้าง root node
        node<Integer> root = new node<>(null, 1);
        if (n == 1) {
            return root;
        }
        
        // ใช้ Queue เพื่อจัดการลำดับของ parent ที่จะเพิ่ม child
        Queue<node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        
        int node_count = 1;

        while(node_count < n) {
            node<Integer> current_parent = queue.poll();
            
            for (int i = 0; i < max_child_node; i++) {
                if(node_count < n) {
                    node_count++;
                    node<Integer> new_child = new node<>(current_parent, node_count);
                    current_parent.add_child(new_child);
                    queue.add(new_child); // เพิ่ม child เข้าคิวเพื่อเป็น parent ในอนาคต
                } else {
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("--- Q1.1 & Q1.2: Create and Print Tree ---");
        node<Integer> root = add_left_to_right(10, 3);
        tree<Integer> tree1 = new tree<>(root);
        tree1.print_tree(root);
        /*
        Expected output:
        root: 1
        p:1 c: {2, 3, 4, }
        p:2 c: {5, 6, 7, }
        p:3 c: {8, 9, 10, }
        p:4 c: {}
        p:5 c: {}
        p:6 c: {}
        p:7 c: {}
        p:8 c: {}
        p:9 c: {}
        p:10 c: {}
        */
        
        System.out.println("\n--- Q1.3: Check is_leaf_node ---");
        System.out.println("Is root a leaf? " + root.is_leaf_node()); // false
        node<Integer> node5 = root.get_child().get(0).get_child().get(0);
        System.out.println("Node " + node5.get_value() + " is a leaf? " + node5.is_leaf_node()); // true

        System.out.println("\n--- Q1.4: Print Tree V2 (Hide leaf parents) ---");
        tree1.print_tree_v2(root);
        /*
        Expected output:
        root: 1
        p:1 c: {2, 3, 4, }
        p:2 c: {5, 6, 7, }
        p:3 c: {8, 9, 10, }
        */

        System.out.println("\n--- Q1.5: DFS and BFS ---");
        // เปลี่ยนค่าโหนด 4 -> 5 เพื่อให้มีเลข 5 สองตำแหน่ง
        node<Integer> node4 = root.get_child().get(2);
        node4.set_value(5);
        System.out.println("Changed node 4 to 5 for testing.");
        tree1.print_tree_v2(root);
        
        // DFS Search
        node<Integer> dfs_result = tree1.dfs(root, 5);
        System.out.println("DFS found node with value: " + dfs_result.get_value());
        System.out.println("Parent of DFS result is: " + dfs_result.get_parent().get_value()); // Expected: 2
        
        // BFS Search
        node<Integer> bfs_result = tree1.bfs(root, 5);
        System.out.println("BFS found node with value: " + bfs_result.get_value());
        System.out.println("Parent of BFS result is: " + bfs_result.get_parent().get_value()); // Expected: 1

        System.out.println("\n--- Q1.6 & Q1.7: Back Track & Reverse Back Track ---");
        // ค้นหาโหนด 5 ที่ลึกที่สุด (เดิมคือโหนด 5)
        node<Integer> node_to_track = tree1.dfs(root, 5); // จะเจอโหนด 5 ที่เป็นลูกของ 2 ก่อน
        
        // Q1.6
        System.out.print("Backtrack from DFS result: ");
        List<node<Integer>> path_A = root.get_back_track(node_to_track);
        for(node<Integer> n : path_A) {
            System.out.print(n.get_value() + "->");
        }
        System.out.println("root");

        // ค้นหาโหนด 5 ที่อยู่ระดับตื้นกว่า (เดิมคือโหนด 4)
        node<Integer> another_node_to_track = tree1.bfs(root, 5); // จะเจอโหนด 5 ที่เป็นลูกของ 1 ก่อน

        System.out.print("Backtrack from BFS result: ");
        List<node<Integer>> path_B = root.get_back_track(another_node_to_track);
        for(node<Integer> n : path_B) {
            System.out.print(n.get_value() + "->");
        }
        System.out.println("root");

        // Q1.7
        System.out.print("Reverse Backtrack (path to node): ");
        List<node<Integer>> reverse_path = root.get_reverse_back_track(node_to_track);
        for(node<Integer> n : reverse_path) {
            System.out.print(n.get_value() + "->");
        }
        System.out.println("leaf");
    }
}