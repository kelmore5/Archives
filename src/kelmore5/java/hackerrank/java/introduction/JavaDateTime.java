package kelmore5.java.hackerrank.java.introduction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, day);
        System.out.println(new SimpleDateFormat("EEEE").format(cal.getTime()).toUpperCase());
    }
}
