package kelmore5.java.hackerrank.java.data_structures;

import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class OneDArrayPartTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }

            if(jump(a, m, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            t--;
        }

    }

    public static boolean jump(int[] a, int m, int step) {
        if(step+1 >= a.length || step+m >= a.length) {
            return true;
        }

        a[step] = 1;

        if(step-1 >= 0 && a[step+m] == 0 && a[step+1] == 0 && a[step-1] == 0) {
            return jump(a, m, step+m) || jump(a, m, step+1) || jump(a, m, step-1);
        }
        if(a[step+m] == 0 && a[step+1] == 0) {
            return jump(a, m, step+m) || jump(a, m, step+1);
        }
        if(a[step+m] == 0 && step-1 >= 0 && a[step-1] == 0) {
            return jump(a, m, step+m) || jump(a, m, step-1);
        }
        if(a[step+1] == 0 && step-1 >= 0 && a[step-1] == 0) {
            return jump(a, m, step+1) || jump(a, m, step-1);
        }
        if(a[step+m] == 0) {
            return jump(a, m, step+m);
        }
        if(a[step+1] == 0) {
            return jump(a, m, step+1);
        }
        if(step-1 >= 0 && a[step-1] == 0) {
            return jump(a, m, step-1);
        }

        return false;
    }
}
