package kelmore5.java.hackerrank.data_structures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class DynamicArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();

        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            array.add(new LinkedList<Integer>());
        }

        int lastAns = 0;
        while(q > 0) {
            int query = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int seq = ((x ^ lastAns) % n);

            if(query == 1) {
                array.get(seq).add(y);
            } else {
                List<Integer> sequ = array.get(seq);
                lastAns = sequ.get(y%sequ.size());
                System.out.println(lastAns);
            }

            q--;
        }
    }
}
