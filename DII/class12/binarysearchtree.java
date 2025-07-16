public class binarysearchtree extends tree<Integer> {

    public binarysearchtree() {
        super(null); // เริ่มต้นด้วย root ที่เป็น null
    }

    /**
     * Q1.2: เพิ่มโหนดใหม่เข้าไปใน BST
     * @param value ค่าของโหนดที่จะเพิ่ม
     */
    public void add_node(int value) {
        if (this.get_root() == null) {
            this.root = new binarytree_node<>(null, value);
            return;
        }

        binarytree_node<Integer> current = (binarytree_node<Integer>) this.get_root();
        while (true) {
            if (value < current.get_value()) {
                // ไปทางซ้าย
                if (current.get_left_node() == null) {
                    current.set_left_node(new binarytree_node<>(current, value));
                    return;
                }
                current = current.get_left_node();
            } else if (value > current.get_value()) {
                // ไปทางขวา
                if (current.get_right_node() == null) {
                    current.set_right_node(new binarytree_node<>(current, value));
                    return;
                }
                current = current.get_right_node();
            } else {
                // ค่าซ้ำ ไม่ต้องทำอะไร
                return;
            }
        }
    }
    
    /**
     * Q1.3: ค้นหาโหนดใน BST
     * @param x ค่าที่ต้องการค้นหา
     * @return โหนดที่พบ หรือ null ถ้าไม่พบ
     */
    public binarytree_node<Integer> search(int x) {
        binarytree_node<Integer> current = (binarytree_node<Integer>) this.get_root();
        while (current != null) {
            if (x == current.get_value()) {
                return current;
            } else if (x < current.get_value()) {
                current = current.get_left_node();
            } else {
                current = current.get_right_node();
            }
        }
        return null; // ไม่พบ
    }

    /**
     * Q1.4: ค้นหาโหนดที่มีค่าน้อยที่สุดใน Subtree ด้านขวา
     * @param node โหนดเริ่มต้น
     * @return โหนดที่มีค่าน้อยที่สุด หรือ null ถ้าไม่มี Subtree ด้านขวา
     */
    public binarytree_node<Integer> search_min_rightside(binarytree_node<Integer> node) {
        if (node == null || node.get_right_node() == null) {
            return null;
        }
        
        binarytree_node<Integer> current = node.get_right_node();
        while (current.get_left_node() != null) {
            current = current.get_left_node();
        }
        return current;
    }
    
    // เมธอดนี้มีให้เพื่อเปรียบเทียบ
    public binarytree_node<Integer> search_max_leftside(binarytree_node<Integer> node) {
        if (node == null || node.get_left_node() == null) {
            return null;
        }
        binarytree_node<Integer> current = node.get_left_node();
        while(current.get_right_node() != null) {
            current = current.get_right_node();
        }
        return current;
    }

    /**
     * ลบโหนดที่มีค่า value ออกจาก BST
     * @param value ค่าของโหนดที่จะลบ
     */
    public void delete_node(int value) {
        binarytree_node<Integer> nodeToDelete = this.search(value);
        if (nodeToDelete == null) return;

        // Case 1: Leaf node
        if (nodeToDelete.is_leaf_node()) {
            delete_leaf(nodeToDelete);
        }
        // Case 2: Single child
        else if (nodeToDelete.get_left_node() == null ^ nodeToDelete.get_right_node() == null) {
            delete_single_child(nodeToDelete);
        }
        // Case 3: Two children
        else {
            binarytree_node<Integer> successor = search_min_rightside(nodeToDelete);
            if (successor != null) {
                nodeToDelete.set_value(successor.get_value());
                // Successor will be leaf or have right child
                if (successor.is_leaf_node()) {
                    delete_leaf(successor);
                } else {
                    delete_single_child(successor);
                }
            }
        }
    }

    private void delete_leaf(binarytree_node<Integer> node) {
        if (node.get_parent() == null) {
            // Root node
            root = null;
        } else {
            binarytree_node<Integer> parent = (binarytree_node<Integer>) node.get_parent();
            if (parent.get_left_node() == node) {
                parent.set_left_node(null);
            } else {
                parent.set_right_node(null);
            }
        }
    }

    private void delete_single_child(binarytree_node<Integer> node) {
        binarytree_node<Integer> child = node.get_left_node() != null ?
            node.get_left_node() : node.get_right_node();

        if (node.get_parent() == null) {
            // Root node
            root = child;
            child.set_parent(null);
        } else {
            binarytree_node<Integer> parent = (binarytree_node<Integer>) node.get_parent();
            if (parent.get_left_node() == node) {
                parent.set_left_node(child);
            } else {
                parent.set_right_node(child);
            }
            child.set_parent(parent);
        }
    }

    // เมธอดสำหรับพิมพ์ผลลัพธ์แบบ Binary Tree โดยเฉพาะ
    public void print_tree() {
        if (get_root() != null) {
             print_tree_v2(get_root());
        } else {
             System.out.println("Tree is empty.");
        }
    }
}