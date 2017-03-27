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
public class FindMergePoint {
    int FindMergeNode(Node headA, Node headB) {
        List<Node> list = new LinkedList<Node>();

        while(headA != null) {
            list.add(headA);
            if(list.contains(headB)) {return headB.data;}
            headA = headA.next;
            headB = headB.next;
        }

        while(headB != null) {
            if(list.contains(headB)) {return headB.data;}
            headB = headB.next;
        }

        return -1;

    }
}
