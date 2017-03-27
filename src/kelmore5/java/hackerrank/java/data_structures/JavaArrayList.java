package kelmore5.java.hackerrank.java.data_structures;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaArrayList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();

        while(n > 0) {
            int nn = scan.nextInt();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while(nn > 0) {
                temp.add(scan.nextInt());
                nn--;
            }
            array.add(temp);
            n--;
        }

        n = scan.nextInt();
        while(n > 0) {
            int x = scan.nextInt()-1;
            int y = scan.nextInt()-1;

            if(x >= array.size()) {
                System.out.println("ERROR!");
            } else {
                ArrayList<Integer> temp = array.get(x);
                if(y >= temp.size()) {
                    System.out.println("ERROR!");
                } else {
                    System.out.println(temp.get(y));
                }
            }
            n--;
        }
    }
}
