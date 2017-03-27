package kelmore5.java.hackerrank.java.BigNumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class BIgDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        Object[][] array = new Object[n][2];
        for(int i = 0; i < n; i++) {
            array[i][0] = new BigDecimal(s[i]);
            array[i][1] = s[i];
        }

        Collections.sort(Arrays.asList(array), (a, b) -> (((BigDecimal) b[0]).compareTo((BigDecimal) a[0])));

        for(int i = 0; i < n; i++) {
            s[i] = (String) array[i][1];
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
