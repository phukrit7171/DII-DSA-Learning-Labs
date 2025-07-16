import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class node<T> {
    protected T value;
    protected node<T> parent;
    protected List<node<T>> list_child;

    public node(node<T> parent, T value) {
        this.parent = parent;
        this.value = value;
        this.list_child = new LinkedList<node<T>>();
    }

    public T get_value() {
        return this.value;
    }

    public void set_value(T value) {
        this.value = value;
    }

    public node<T> get_parent() {
        return this.parent;
    }

    public void add_child(node<T> node) {
        this.list_child.add(node);
    }

    public List<node<T>> get_child() {
        return this.list_child;
    }
    
    public boolean has_child() {
        return !this.list_child.isEmpty();
    }

    /**
     * Q1.3: ตรวจสอบว่าโหนดปัจจุบันเป็นโหนดใบ (ไม่มีลูก) หรือไม่
     * @return true ถ้าเป็นโหนดใบ, false ถ้าไม่ใช่
     */
    public boolean is_leaf_node() {
        return !this.has_child();
    }

    /**
     * Q1.6: คืนค่า List ของโหนดจากโหนดที่ระบุกลับไปยังโหนดราก
     * @param node1 โหนดเริ่มต้น
     * @return List ของโหนดในเส้นทางกลับไปยังราก
     */
    public List<node<T>> get_back_track(node<T> node1) {
        List<node<T>> result_nodes = new LinkedList<>();
        node<T> current = node1;
        while (current != null) {
            result_nodes.add(current);
            current = current.get_parent();
        }
        return result_nodes;
    }

    /**
     * Q1.7: คืนค่า List ของโหนดจากโหนดรากมายังโหนดใบ (ย้อนกลับ List จาก get_back_track)
     * @param leaf_node โหนดใบ
     * @return List ของโหนดในเส้นทางจากรากมายังใบ
     */
    public List<node<T>> get_reverse_back_track(node<T> leaf_node) {
        List<node<T>> back_track_path = get_back_track(leaf_node);
        Collections.reverse(back_track_path);
        return back_track_path;
    }
}