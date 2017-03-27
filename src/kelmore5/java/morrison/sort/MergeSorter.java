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
public class MergeSorter {
    private static int[] zip(int[] x, int[] y) {
        int[] temp = new int[1];

        if(x.length <= 0 && y.length <= 0) {
            return merge(temp, new int[0]);
        }
        else if(x.length <= 0 && y.length > 0) {
            temp[0] = y[0];
        }
        else if(x[0] < y[0] && x.length > 0) {
            temp[0] = x[0];
            return merge(temp, zip(Arrays.copyOfRange(x, 1, x.length), y));
        }
        else {
            temp[0] = y[0];
            return merge(temp, zip(x, Arrays.copyOfRange(y, 1, y.length)));
        }

        return temp;
    }

    private static int[] merge(int[] x, int[] y) {
        int[] temp = new int[x.length + y.length];
        System.arraycopy(x, 0, temp, 0, x.length);
        System.arraycopy(y, 0, temp, x.length, y.length);
        return temp;
    }

    private static int[] sort(int[] x) {
        int depth = x.length / 2;
        int[] temp = new int[x.length];
        for(int i = 0; i < depth; i++) {
            temp = merge(temp, zip(new int[] {x[i] }, new int[] {x[i++]}));
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] x = new int[] {0,5,2,3,7,9};
        x = sort(x);

        for(int i: x) {
            System.out.println(i);
        }

    }
}
