package kelmore5.java.hackerrank.data_structures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxS = new Stack<Integer>();
        int max = -1;

        while(n > 0) {
            int t = scan.nextInt();
            if(t == 1) {
                int newX = scan.nextInt();
                stack.push(newX);
                if(max == -1 || maxS.isEmpty()) {max = newX;}
                else {max = Math.max(newX, maxS.peek());}
                maxS.push(max);
            } else if(t == 2) {
                stack.pop();
                maxS.pop();
                if(!maxS.isEmpty()) {max = maxS.peek();}
            } else {
                System.out.println(max);
            }

            n--;
        }

    }
}
