import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Sprite sprite;
    private final int DELAY = 10;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);

        sprite = new Sprite();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (sprite.getY() > 200) {
            sprite.setDirectionY(0);
        }
        initDrawing(graphics);

        Toolkit.getDefaultToolkit().sync();
    }

    private void initDrawing(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    private void step() {
        sprite.move();
        repaint(sprite.getX() - 1, sprite.getY() - 1, sprite.getWidth() + 2, sprite.getHeight() + 2);
        super.repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event) {
            sprite.keyReleased(event);
        }

        @Override
        public void keyPressed(KeyEvent event) {
            sprite.keyPressed(event);
        }
    }
}
