package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class MergeTwoSortedLists {
    Node MergeLists(Node headA, Node headB) {
        if(headA == null && headB == null) {return null;}
        else if(headA == null) {return headB;}
        else if(headB == null) {return headA;}

        Node newHead = new Node();
        Node temp = newHead;

        if(headA.data < headB.data) {newHead.data = headA.data; headA = headA.next;}
        else {newHead.data = headB.data; headB = headB.next;}

        while(headA != null) {
            while(headB != null && headB.data <= headA.data) {
                newHead.next = new Node();
                newHead.next.data = headB.data;
                newHead = newHead.next;

                headB = headB.next;
            }

            newHead.next = new Node();
            newHead.next.data = headA.data;
            newHead = newHead.next;
            headA = headA.next;
        }

        while(headB != null) {
            newHead.next = new Node();
            newHead.next.data = headB.data;
            newHead = newHead.next;
            headB = headB.next;
        }



        return temp;
    }

}
