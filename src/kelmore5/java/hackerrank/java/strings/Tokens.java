package kelmore5.java.hackerrank.java.strings;

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
public class Tokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s + "6";

        ArrayList<String> strings = new ArrayList<String>();
        String temp = "";

        for(char c: s.toCharArray()) {
            if(Character.isLetter(c)) {
                temp += c;
            } else if(temp.length() > 0){
                strings.add(temp);
                temp = "";
            }
        }

        System.out.println(strings.size());
        for(String ss: strings) {
            System.out.println(ss);
        }

        scan.close();
    }
}
