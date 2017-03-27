package kelmore5.java.hackerrank.java.exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class ExceptionHandlingTryCatch {
    public static void main(String[] args) {
        System.out.println(divide(new Scanner(System.in)));
    }

    public static String divide(Scanner scan) {
        try {
            int x = scan.nextInt();
            int y = scan.nextInt();

            return "" + x/y;
        } catch(InputMismatchException e) {
            System.out.print(e.toString().substring(0, 32));
        } catch(Exception ex) {
            System.out.print(ex.toString());
        }

        return "";
    }
}
