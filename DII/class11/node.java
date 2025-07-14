import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class node<T> {
    private T value;
    private final node parent;
    private final List<node> List_child;
    
    public node(node parent, T value) {
        this.List_child = new LinkedList<>();
        this.parent = parent;
        this.value = value;
    }
    
    public T get_value() {
        return this.value;
    }
    
    public void set_value(T value) {
        this.value = value;
    }
    
    public node get_parent() {
        return this.parent;
    }
    
    public void add_child(node node) {
        this.List_child.add(node);
    }
    
    public void remove_child(node node) {
        this.List_child.remove(node);
    }
    
    public List<node> get_child() {
        return this.List_child;
    }
    
    public boolean has_child() {
        return !this.List_child.isEmpty();
    }
    
    // Question 1.3: Check if node is leaf
    public boolean is_leaf_node() {
        return this.List_child.isEmpty();
    }
    
    // Question 1.6: Get back track from node to root
    public List<node> get_back_track(node node1) {
        List<node> path = new LinkedList<>();
        node current = node1;
        
        while (current != null) {
            path.add(current);
            current = current.get_parent();
        }
        
        return path;
    }
    
    // Question 1.7: Get reverse back track (root to node)
    public List<node> get_reverse_back_track(node node1) {
        List<node> path = get_back_track(node1);
        Collections.reverse(path);
        return path;
    }
}