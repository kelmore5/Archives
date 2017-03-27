package kelmore5.java.morrison.sort;

import java.util.Arrays;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
public class Sorting {
    private static void sort1(int[] x)
    {
        int index = 0;
        //inner loop
        int smallest = x[index];
        int whereSmallest = index;
        int where = index;
        while(index < x.length - 1)
        {
            while(where < x.length)
            {
                if(x[where] < smallest)
                {
                    smallest = x[where];
                    whereSmallest = where;
                }
                where += 1;
            }
            swap(x, whereSmallest, index);
            index++;
        }
    }

    private static void swap(int[] x, int k, int l)
    {
        if(k != l)
        {
            int tmp = x[k];
            x[k] = x[l];
            x[l] = tmp;
        }
    }

    public static void main(String[] args)
    {
        int[] x = {32, 56, 13, 97};
        System.out.println(Arrays.toString(x));
        sort1(x);
        System.out.println(Arrays.toString(x));
    }

}