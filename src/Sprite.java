import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Sprite {

    private int dx;
    private int dy;
    private int x = 40;
    private int y = 200;
    private int width;
    private int height;
    private Image image;

    public Sprite() {
        loadImage();
    }

    private void loadImage() {
        ImageIcon icon = new ImageIcon("src/resources/red-square.png");
        image = icon.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        if (key == KeyEvent.VK_SPACE) {
            dy = -2;
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            dy = 2;
                        }
                    }, 800
            );
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
