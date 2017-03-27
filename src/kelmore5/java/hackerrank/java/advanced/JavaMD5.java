package kelmore5.java.hackerrank.java.advanced;

import java.security.MessageDigest;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaMD5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        try {
            byte[] bytes = s.getBytes("UTF-8");

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(bytes);

            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0"
                            + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }

            System.out.println(hexString);
        }catch(Exception ex) {}
    }
}
