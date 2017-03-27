package kelmore5.java.hackerrank.data_structures.linked_lists;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class GetNodeValue {
    int GetNode(Node head,int n) {
        List<Integer> list = new ArrayList<Integer>();

        while(head != null) {
            list.add(head.data);
            head = head.next;
        }

        return list.get(list.size()-1-n);
    }

}
