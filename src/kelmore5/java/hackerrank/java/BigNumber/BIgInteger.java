package kelmore5.java.hackerrank.java.BigNumber;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class BIgInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger b1 = new BigInteger(scan.nextLine());
        BigInteger b2 = new BigInteger(scan.nextLine());

        System.out.println(b1.add(b2));
        System.out.println(b1.multiply(b2));
    }
}
