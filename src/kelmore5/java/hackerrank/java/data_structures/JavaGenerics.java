package kelmore5.java.hackerrank.java.data_structures;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaGenerics {
    public void printArray(Object[] array) {
        for(Object o: array) {
            System.out.println(o.toString());
        }
    }
}
