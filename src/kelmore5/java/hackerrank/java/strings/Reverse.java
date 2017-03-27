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
public class Reverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B = "";

        for(int i = A.length()-1; i >= 0; i--) {
            B += A.charAt(i);
        }

        System.out.println(A.compareTo(B) == 0 ? "Yes" : "No");
    }
}
