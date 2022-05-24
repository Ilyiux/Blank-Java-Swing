import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    public final static int WIDTH = 1920;
    public final static int HEIGHT = 1080;
    private Thread thread;

    public Panel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(false);

        this.setFocusable(true);
        init();
    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int frameTicks = 120;
        double drawInterval = 1000000000 / (double) frameTicks;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();
                delta --;
            }
        }
    }

    private void init() {
        // Runs *once* at the start of the program
    }

    private void update() {
        // Runs at a set rate, before drawing
    }

    @Override
    public void paintComponent(Graphics g) {

    }
}
