import java.util.LinkedList;
import java.util.Queue;

public class tree<T> {
    private node root;
    private node _node_found;
    
    public tree(node root) {
        this.root = root;
    }
    
    public node get_root() {
        return this.root;
    }
    
    // Question 1.2: Print tree showing parent-child relationships
    public void print_tree(node node) {
        if (node == null) return;
        
        // Print current node and all its children on one line
        System.out.print("p:" + node.get_value() + " c: {");
        if (node.has_child()) {
            for (int i = 0; i < node.get_child().size(); i++) {
                node childNode = (node) node.get_child().get(i);
                System.out.print(childNode.get_value());
                if (i < node.get_child().size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(", }");
        
        // Recursively print children
        if (node.has_child()) {
            for (Object child : node.get_child()) {
                print_tree((node) child);
            }
        }
    }
    
    // Question 1.4: Print tree v2 - don't show leaf nodes as parents
    public void print_tree_v2(node node) {
        if (node == null) return;
        
        if (node.has_child()) {
            for (Object child : node.get_child()) {
                node childNode = (node) child;
                // Only print if the child is not a leaf node
                if (!childNode.is_leaf_node()) {
                    System.out.println("p" + node.get_value() + " c" + childNode.get_value());
                }
            }
            
            // Recursively print children
            for (Object child : node.get_child()) {
                print_tree_v2((node) child);
            }
        }
    }
    
    // Question 1.5: Depth First Search
    public node dfs(node node, T value) {
        this._node_found = null;
        recur_dfs(node, value);
        return this._node_found;
    }
    
    private boolean recur_dfs(node node, T value) {
        if (node == null) return false;
        
        if (node.get_value().equals(value)) {
            this._node_found = node;
            return true;
        }
        
        for (Object child : node.get_child()) {
            if (recur_dfs((node) child, value)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Question 1.5: Breadth First Search
    public node bfs(node node, T value) {
        if (node == null) return null;
        
        Queue<node> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            node current = queue.poll();
            
            if (current.get_value().equals(value)) {
                return current;
            }
            
            for (Object child : current.get_child()) {
                queue.offer((node) child);
            }
        }
        
        return null;
    }
}