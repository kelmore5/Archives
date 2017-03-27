package kelmore5.java.hackerrank.java.data_structures;

import java.util.BitSet;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaBitSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        BitSet[] sets = new BitSet[2];
        for(int i = 0; i < sets.length; i++) {
            sets[i] = new BitSet(n);
        }

        for(int i = 0; i < m; i++) {
            String s = scan.next();
            int one = scan.nextInt();
            int two = scan.nextInt();

            if(s.equals("AND")) {
                sets[one-1].and(sets[two-1]);
            } else if(s.equals("OR")) {
                sets[one-1].or(sets[two-1]);
            } else if(s.equals("XOR")) {
                sets[one-1].xor(sets[two-1]);
            } else if(s.equals("FLIP")) {
                sets[one-1].flip(two);
            } else {
                sets[one-1].set(two);
            }

            System.out.println(sets[0].cardinality() + " " + sets[1].cardinality());
        }
    }
}
