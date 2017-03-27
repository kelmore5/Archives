package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class InsertAtPosition {
    Node InsertNth(Node head, int data, int position) {
        if(head == null) {
            head = new Node();
            head.data = data;
            return head;
        } else if(position == 0) {
            Node n = new Node();
            n.data = data;
            n.next = head;
            return n;
        }
        Node temp = head;
        while(position > 1) {
            temp = temp.next;
            position--;
        }

        Node n = new Node();
        n.data = data;
        n.next = temp.next;
        temp.next = n;

        return head;



    }
}
