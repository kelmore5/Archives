package kelmore5.java.hackerrank.java.advanced;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */
public class JavaSingleton {
    private static JavaSingleton s;
    public String str;
    private JavaSingleton() {
    }

    static JavaSingleton getSingleInstance() {
        if(s == null) {
            synchronized(JavaSingleton.class) {
                if(s == null) {
                    s = new JavaSingleton();
                }
            }
        }
        return s;
    }
}

