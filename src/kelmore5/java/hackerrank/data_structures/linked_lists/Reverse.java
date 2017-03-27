package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class Reverse {
    Node Reverse(Node head) {
        if(head == null) {return head;}
        Node newHead = new Node();
        newHead.data = head.data;
        Node temp = head.next;
        while(temp != null) {
            Node temp2 = new Node();
            temp2.data = temp.data;

            temp2.next = newHead;
            newHead = temp2;

            temp = temp.next;
        }

        return newHead;
    }

}
