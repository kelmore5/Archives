package kelmore5.java.hackerrank.data_structures.linked_lists;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class InsertNodeIntoSorted {
    Node SortedInsert(Node head,int data) {
        Node temp = new Node();
        temp.data = data;

        Node temp2 = head;

        if(head == null) {return temp;}
        if(head.data > data) {
            temp.next = head;
            head.prev = temp;
            return temp;
        }

        while(head != null) {
            if(head.data > data) {
                head.prev.next = temp;
                temp.prev = head.prev;
                head.prev = temp;
                temp.next = head;
                return temp2;
            }

            if(head.next == null) {
                temp.prev = head;
                head.next = temp;
                return temp2;
            }
            head = head.next;
        }

        return temp2;
    }

}
