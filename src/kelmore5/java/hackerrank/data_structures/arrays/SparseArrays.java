package kelmore5.java.hackerrank.data_structures.arrays;

import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] s = new String[n];

        for(int i = 0; i < n; i++) {
            s[i] = scan.next();
        }

        int q = scan.nextInt();
        while(q > 0) {
            String temp = scan.next();

            int count = 0;
            for(String ss: s) {
                if(ss.equals(temp)) {
                    count++;
                }
            }

            System.out.println(count);

            q--;
        }
    }
}
