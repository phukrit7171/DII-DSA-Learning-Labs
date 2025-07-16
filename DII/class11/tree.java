import java.util.LinkedList;
import java.util.Queue;

public class tree<T> {
    private node<T> root;
    private node<T> _node_found; // สำหรับใช้ใน DFS

    public tree(node<T> root) {
        this.root = root;
        this._node_found = null;
    }

    public node<T> get_root() {
        return this.root;
    }

    /**
     * Q1.2: พิมพ์โครงสร้าง Tree ทั้งหมดแบบ Level-Order
     * @param node โหนดเริ่มต้น (ปกติคือ root)
     */
    public void print_tree(node<T> node) {
        if (node == null) return;
        Queue<node<T>> queue = new LinkedList<>();
        queue.add(node);
        System.out.println("root: " + node.get_value());
        while (!queue.isEmpty()) {
            node<T> n = queue.poll();
            System.out.print("p:" + n.get_value() + " c: {");
            for (node<T> child_node : n.get_child()) {
                System.out.print(child_node.get_value() + ", ");
                queue.add(child_node);
            }
            System.out.println("}");
        }
    }

    /**
     * Q1.4: พิมพ์โครงสร้าง Tree ทั้งหมดโดยไม่แสดงโหนดใบเป็น Parent
     * @param node โหนดเริ่มต้น (ปกติคือ root)
     */
    public void print_tree_v2(node<T> node) {
        if (node == null) return;
        Queue<node<T>> queue = new LinkedList<>();
        queue.add(node);
        System.out.println("root: " + node.get_value());
        while (!queue.isEmpty()) {
            node<T> n = queue.poll();
            if (!n.is_leaf_node()) {
                System.out.print("p:" + n.get_value() + " c: {");
                for (node<T> child_node : n.get_child()) {
                    System.out.print(child_node.get_value() + ", ");
                    queue.add(child_node);
                }
                System.out.println("}");
            }
        }
    }
    
    /**
     * Q1.5 (BFS): ค้นหาโหนดแบบ Breadth-First Search
     * @param startNode โหนดเริ่มต้น
     * @param value ค่าที่ต้องการค้นหา
     * @return โหนดแรกที่พบ หรือ null ถ้าไม่พบ
     */
    public node<T> bfs(node<T> startNode, T value) {
        if (startNode == null) return null;
        Queue<node<T>> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            node<T> n = queue.poll();
            if (n.get_value().equals(value)) {
                return n;
            }
            for (node<T> child : n.get_child()) {
                queue.add(child);
            }
        }
        return null;
    }

    /**
     * Q1.5 (DFS): เมธอดหลักสำหรับเรียกใช้ Depth-First Search
     * @param startNode โหนดเริ่มต้น
     * @param value ค่าที่ต้องการค้นหา
     * @return โหนดแรกที่พบ หรือ null ถ้าไม่พบ
     */
    public node<T> dfs(node<T> startNode, T value) {
        this._node_found = null; // รีเซ็ตค่าก่อนการค้นหาทุกครั้ง
        recur_dfs(startNode, value);
        return this._node_found;
    }

    /**
     * Q1.5 (DFS Helper): เมธอด Recursive สำหรับทำ DFS
     */
    private void recur_dfs(node<T> currentNode, T value) {
        if (currentNode == null || this._node_found != null) {
             // หยุดทำงานถ้าเจอโหนดแล้ว หรือโหนดปัจจุบันเป็น null
            return;
        }

        if (currentNode.get_value().equals(value)) {
            this._node_found = currentNode;
            return;
        }

        for (node<T> child : currentNode.get_child()) {
            recur_dfs(child, value);
        }
    }
}