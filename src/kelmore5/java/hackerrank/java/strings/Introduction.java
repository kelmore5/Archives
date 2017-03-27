package kelmore5.java.hackerrank.java.strings;

import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class Introduction {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) <= 0 ? "No" : "Yes");

        String aa = "" + A.charAt(0);
        String bb = "" + B.charAt(0);
        A = aa.toUpperCase() + A.substring(1);
        B = bb.toUpperCase() + B.substring(1);
        System.out.println(A + " " + B);

    }
}
