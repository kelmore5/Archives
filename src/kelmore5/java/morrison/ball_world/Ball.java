package kelmore5.java.morrison.ball_world;


import java.awt.Color;
import java.awt.Graphics;

/**
 * <pre class="doc_header">
 * A simple ball class used to render colorful balls in {@link BallWorld}.
 * Specifies color, radius, and position
 * </pre>
 *
 * @author kelmore5
 * @custom.date Fall 2011
 */
class Ball {
    private Color color;
    private int[] point;
    private int radius;

    /**
     * Instantiates a new Ball.
     *
     * @param _color  the color of the ball
     * @param p       the position of the ball
     * @param _radius the radius of the ball
     */
    Ball(Color _color, int[] p, int _radius) {
        color = _color;
        point = p;
        radius = _radius;
    }

    /**
     * A draw method for a ball
     *
     * @param g the Java graphics class
     */
    void draw(Graphics g) {
        //Set color and then fill based on pre-defined size
        g.setColor(color);
        g.fillOval(point[0], point[1], radius*2, radius*2);
    }
}
