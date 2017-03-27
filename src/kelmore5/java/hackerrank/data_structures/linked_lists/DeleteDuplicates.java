package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class DeleteDuplicates {
    Node RemoveDuplicates(Node head) {
        if(head == null) {return head;}
        Node temp = head;

        while(head != null) {
            while(head.next != null && head.next.data == head.data) {
                head.next = head.next.next;
            }

            head = head.next;
        }

        return temp;
    }
}
