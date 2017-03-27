package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class ReverseDoublyLinked {
    Node Reverse(Node head) {
        if(head == null) {return head;}

        Node temp = new Node();
        temp.data = head.data;

        while(head != null) {
            if(head.next != null) {
                head = head.next;
                Node n = new Node();
                n.data = head.data;
                n.next = temp;
                temp.prev = n;
                temp = n;
            } else {
                head = head.next;
            }
        }

        return temp;
    }
}
