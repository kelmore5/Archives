package kelmore5.java.morrison.sort;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
public class RadixSort {
    @SuppressWarnings("unused")
    private static void sort(int[] array) {

    }

    public static String toString(int[] list) {
        String string = "[";
        for(int i: list) {
            string += i;
            string += ", ";
        }

        string = string.substring(0, string.lastIndexOf(","));
        string += "]";
        return string;
    }


    public static void main(String[] args) {
        int[] array = new int[] { 911, 201, 951, 232, 212, 626, 704, 734, 847};
        System.out.println(toString(array));
        sort(array);
        System.out.println(toString(array));
    }
}