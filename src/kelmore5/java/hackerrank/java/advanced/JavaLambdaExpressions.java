package kelmore5.java.hackerrank.java.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaLambdaExpressions {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.is_odd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.is_prime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.is_palindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    static PerformOperation is_odd() {
        return (int a) -> a % 2 != 0;
    }

    static PerformOperation is_prime() {
        return (int a) -> isPrimeHelper(a);
    }

    static PerformOperation is_palindrome() {
        return (int a) -> isPalindromeHelper(a);
    }

    static boolean isPalindromeHelper(int a) {
        char[] c = ("" + a).toCharArray();
        for(int i = 0; i < c.length/2; i++) {
            if(c[i] != c[c.length-i-1]) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrimeHelper(int a) {
        for(int i = 2; i <= a/2; i++) {
            if(a % i == 0) {
                return false;
            }
        }
        return true;
    }
}