package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class CompareTwoLists {
    int CompareLists(Node headA, Node headB) {
        if(headA == null && headB == null) {return 1;}
        else if(headA == null || headB == null) {return 0;}

        while(headA != null) {
            if(headB == null) {return 0;}
            if(headA.data != headB.data) {return 0;}

            headA = headA.next;
            headB = headB.next;
        }

        return headB == null ? 1 : 0;
    }
}
