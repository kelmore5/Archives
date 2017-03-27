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
public class LeftRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        for(int i = 0; i < d; i++) {
            rotate(a);
        }

        for(Integer i: a) {
            System.out.print(i + " ");
        }
    }

    public static void rotate(int[] a) {
        int temp = a[0];

        for(int i = 0; i < a.length-1; i++) {
            a[i] = a[i+1];
        }

        a[a.length-1] = temp;
    }
}
