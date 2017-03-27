package kelmore5.java.hackerrank.java.data_structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaMap {static Map<String, Integer> map = new HashMap<String, Integer>();
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            map.put(name, phone);
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            Integer num = map.get(s);
            if(num == null) {
                System.out.println("Not found") ;
            } else {
                System.out.println(s + "=" + num);
            }
        }
    }

}
