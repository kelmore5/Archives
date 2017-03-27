package kelmore5.java.hackerrank.java.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaHashset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        int count = 0;

        Map<String, ArrayList<String>> set = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < pair_left.length; i++) {
            ArrayList<String> array = set.get(pair_left[i]);
            if (array == null) {
                set.put(pair_left[i], new ArrayList<String>(Arrays.asList(pair_right[i])));
                count++;
            } else {
                if (!array.contains(pair_right[i])) {
                    array.add(pair_right[i]);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
