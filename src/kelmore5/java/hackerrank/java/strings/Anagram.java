package kelmore5.java.hackerrank.java.strings;

import java.util.Arrays;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class Anagram {
    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);

        a = new String(aa);
        b = new String(bb);

        return a.compareToIgnoreCase(b) == 0;
    }
}
