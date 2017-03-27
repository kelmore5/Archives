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
public class JavaForLoops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int previous = 0;

            for(int j = 0; j < n; j++) {
                previous = previous + (int) Math.pow(2, j)*b;
                System.out.print((a + previous) + " ");
            }

            System.out.println("");
        }
        in.close();
    }
}
