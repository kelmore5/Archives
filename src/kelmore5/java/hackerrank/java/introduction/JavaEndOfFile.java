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
public class JavaEndOfFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while(scan.hasNext()) {
            System.out.println(count++ + " " + scan.nextLine());
        }
    }
}
