import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Sprite {
    private static final int GROUND_LEVEL = 202;
    private int directionX;
    private int directionY;
    private boolean isJumping = false;
    private int x = 40;
    private int y = GROUND_LEVEL;
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
        x += directionX;
        y += directionY;
    }

    public void jump() {
        boolean isOnGroundLevel = !isJumping && this.y == GROUND_LEVEL;
        if (isOnGroundLevel) {
            directionY = -2;
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            directionY = 2;
                            isJumping = true;
                        }
                    }, 800
            );
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
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
            directionX = -2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            directionX = 2;
        }
        if (key == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            directionX = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            directionX = 0;
        }
        if (key == KeyEvent.VK_SPACE) {
            isJumping = false;
        }
    }
}
