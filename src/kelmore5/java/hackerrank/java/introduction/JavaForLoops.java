package kelmore5.java.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaForLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1; i < 11; i++) {
            System.out.println(N + " x " + i + " = " + N*i);
        }
    }
}
