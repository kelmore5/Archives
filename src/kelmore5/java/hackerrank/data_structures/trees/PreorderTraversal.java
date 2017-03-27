package kelmore5.java.hackerrank.data_structures.trees;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class PreorderTraversal {
    void preOrder(Node root) {
        if(root == null) {return;}
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
