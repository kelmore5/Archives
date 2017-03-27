package kelmore5.java.yeh.final_projects.snake;

import java.awt.Color;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/19/17
 */
public class Node<T> {
    private Node<T> next;
    private Position pos;
    private Color color;

    Node(Node<T> _next, Position _pos, Color _color) {
        pos = _pos;
        color = _color;
        next = _next;
    }

    public void setNext(Node<T> _next) {
        next = _next;
    }

    public Position getPosition() {
        return pos;
    }

    public Color getColor() {
        return color;
    }

    public Node<T> getNext() {
        return next;
    }
}