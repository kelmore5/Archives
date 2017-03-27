package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class InsertAtTail {
    Node Insert(Node head,int data) {
        if(head == null) {
            head = new Node();
            head.data = data;
            return head;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node();
            temp.next.data = data;
            return head;
        }

    }
}
