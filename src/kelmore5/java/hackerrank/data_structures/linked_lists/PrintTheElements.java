package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class PrintTheElements {
    void Print(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }
}