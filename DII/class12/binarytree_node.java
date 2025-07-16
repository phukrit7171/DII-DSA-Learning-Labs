public class binarytree_node<T> extends node<T> {

    public binarytree_node(node<T> parent, T value) {
        super(parent, value);
        // จองที่สำหรับลูกซ้าย (index 0) และลูกขวา (index 1)
        this.get_child().add(null);
        this.get_child().add(null);
    }

    public binarytree_node<T> get_left_node() {
        return (binarytree_node<T>) this.get_child().get(0);
    }

    public void set_left_node(binarytree_node<T> node) {
        if (node != null) {
           node.parent = this;
        }
        this.get_child().set(0, node);
    }
    
    public binarytree_node<T> get_right_node() {
        return (binarytree_node<T>) this.get_child().get(1);
    }

    public void set_right_node(binarytree_node<T> node) {
        if (node != null) {
            node.parent = this;
        }
        this.get_child().set(1, node);
    }

    // New method to set parent directly
    public void set_parent(binarytree_node<T> parent) {
        this.parent = parent;
    }
    
    // Override is_leaf_node for binary tree
    @Override
    public boolean is_leaf_node() {
        return this.get_left_node() == null && this.get_right_node() == null;
    }
}