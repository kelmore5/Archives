package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class InsertAtHead {
    Node Insert(Node head,int x) {
        if(head == null) {
            head = new Node();
            head.data = x;
            return head;
        } else {
            Node temp = new Node();
            temp.data = x;
            temp.next = head;
            return temp;
        }
    }
}
