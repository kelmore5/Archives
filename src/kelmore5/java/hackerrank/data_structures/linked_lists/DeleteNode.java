package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class DeleteNode {
    Node Delete(Node head, int position) {
        if(head == null) {
            return head;
        } else if(position == 0) {
            head = head.next;
            return head;
        }
        Node temp = head;
        while(position > 1) {
            temp = temp.next;
            position--;
        }

        temp.next = temp.next.next;
        return head;

    }
}
