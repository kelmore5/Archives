package kelmore5.java.hackerrank.java.data_structures;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> a = new LinkedList<Integer>();

        while(n > 0) {
            a.add(scan.nextInt());
            n--;
        }

        int q = scan.nextInt(); scan.nextLine();
        while(q > 0) {
            String command = scan.nextLine();
            if(command.equals("Insert")) {
                int pos = scan.nextInt();
                if(pos == a.size()) {
                    a.add(scan.nextInt());
                } else {
                    a.add(pos, scan.nextInt());
                }
            } else {
                a.remove(scan.nextInt());
            }
            if(scan.hasNext()) {
                scan.nextLine();
            }
            q--;
        }

        for(Integer i: a) {
            System.out.print(i + " ");
        }

    }
}
