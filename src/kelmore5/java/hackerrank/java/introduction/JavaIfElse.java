package kelmore5.java.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaIfElse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1 || (n > 5 && n < 21)){
            ans = "Weird";
        } else {

            ans = "Not Weird";

        }
        System.out.println(ans);

    }
}
