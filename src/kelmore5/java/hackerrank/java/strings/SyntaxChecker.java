package kelmore5.java.hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class SyntaxChecker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            try {
                Pattern.compile(in.nextLine());
                System.out.println("Valid");
            } catch(Exception ex) {
                System.out.println("Invalid");
            }

            testCases--;
        }
    }
}
