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
public class JavaStatic {

    static Scanner scan = new Scanner(System.in);
    static int B = getInt();
    static int H = getInt();
    static boolean flag = B > 0 && H > 0;
    static boolean thrown = false;

    static int getInt() {
        int a = scan.nextInt();
        if(!thrown && a <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            thrown = true;
            return a;
        } else {
            return a;
        }
    }

}
