package kelmore5.java.hackerrank.java.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class Subarray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        ArrayList<Integer[]> subs = new ArrayList<Integer[]>();
        for(int i = 0; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                subs.add(Arrays.copyOfRange(a, i, j));
            }
        }

        int count = 0;
        for(Integer[] ii: subs) {
            int sum = 0;
            for(Integer i: ii) {
                sum += i;
            }

            if(sum < 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
