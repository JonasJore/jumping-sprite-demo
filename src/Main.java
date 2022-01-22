import javax.swing.JFrame;
import java.awt.EventQueue;

public class Main extends JFrame {

    public Main() {
        initUi();
    }

    private void initUi() {
        add(new Board());

        setTitle("Jumping sprite demo");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
