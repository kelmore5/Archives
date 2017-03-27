package kelmore5.java.hackerrank.java.strings;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class Compare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = scan.nextInt();
        ArrayList<String> substrings = new ArrayList<String>();

        for(int i = 0; i < s.length()-n+1; i++) {
            substrings.add(s.substring(i, i+n));
        }

        String min = substrings.get(0);
        String max = substrings.get(0);

        for(String st: substrings) {
            if(min.compareTo(st) < 0) {
                min = st;
            }
            if(max.compareTo(st) > 0) {
                max = st;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}
