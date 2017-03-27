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
public class BalancedBrackets {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Character> stack = new Stack<Character>();

        while (n > 0) {
            char[] input=sc.next().toCharArray();
            stack.clear();
            for(int i = 0; i < input.length; i++) {
                char c = input[i];
                if(c == '{' || c == '(' || c == '[') {
                    stack.push(c);
                } else {
                    if(stack.empty()) {
                        stack.push(c);
                        i = input.length;
                    } else {
                        char cc = stack.pop();
                        if((cc == '{' && c != '}') || (cc == '(' && c != ')') || (cc == '[' && c != ']')) {
                            stack.push(cc);
                            i = input.length;
                        }
                    }
                }
            }
            n--;
            System.out.println(stack.empty() ? "YES" : "NO");
        }

    }
}
