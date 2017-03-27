package kelmore5.java.hackerrank.data_structures.linked_lists;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class CycleDetection {
    boolean hasCycle(Node head) {
        if(head == null) {return false;}
        List<Node> s = new LinkedList<Node>();

        while(head != null) {
            if(s.contains(head)) {return true;}
            s.add(head);
            head = head.next;
        }

        return false;
    }

}
