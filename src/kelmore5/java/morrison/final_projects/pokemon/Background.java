package kelmore5.java.morrison.final_projects.pokemon;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/18/17
 */
public class Background extends JPanel implements ActionListener, Runnable
{
    private BufferedImage background;
    private Character character;

    Background(Main main) {
        character = new Character(main);
        Dimension size = new Dimension();

        try {
            background = ImageIO.read(new File(Main.fileRoot + "Images/Pokemon/WorldMap.png"));
        }
        catch(IOException ex) { background = null; }

        Timer time = new Timer(5, this);
        time.start();

        size.setSize(background.getWidth(), background.getHeight());
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(background, character.getX(), character.getY(), null);
        g2d.drawImage(character.getImage(),
                (Main.width/2) - (character.getImage().getWidth(null)/2),
                (Main.height/2) + (character.getImage().getHeight(null)/2),
                null);
    }

    public void actionPerformed(ActionEvent e) {
        character.move();
        repaint();
    }

    public Dimension getPosition()
    {
        return character.getPosition();
    }

    public void setPosition(Dimension d)
    {
        character.setPosition(d);
    }

    void keyPressed(KeyEvent e)
    {
        character.keyPressed(e);
    }

    void keyReleased(KeyEvent e)
    {
        character.keyReleased(e);
    }

    @Override
    public void run() {}
}
