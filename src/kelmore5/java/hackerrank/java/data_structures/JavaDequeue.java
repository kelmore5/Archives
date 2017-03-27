package kelmore5.java.hackerrank.java.data_structures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[10000001];
        int count = 0;

        int i = 0;
        for(; i < m; i++) {
            int num = in.nextInt();
            deque.add(num);
            if(a[num] == 0) {count++;}
            a[num]++;
        }

        int max = count;

        for (; i < n; i++) {
            if(max == m) {break;}
            int num = in.nextInt();
            int remove = deque.pollFirst();
            a[remove]--;
            if(a[remove] == 0) {count--;}
            deque.add(num);
            if(a[num] == 0){count++;}
            a[num]++;
            max = count > max ? count : max;
        }

        System.out.println(max);
    }
}
