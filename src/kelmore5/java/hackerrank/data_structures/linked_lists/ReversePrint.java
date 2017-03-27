package kelmore5.java.hackerrank.data_structures.linked_lists;

import java.util.Collections;
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
public class ReversePrint {
    void ReversePrint(Node head) {
        if(head == null) {return;}
        List<Integer> list = new LinkedList<Integer>();
        while(head != null) {
            list.add(head.data);
            head = head.next;
        }

        Collections.reverse(list);
        for(Integer i: list) {
            System.out.println(i);
        }
    }
}
