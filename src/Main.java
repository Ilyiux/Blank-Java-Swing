import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("New Window");

        Panel jp = new Panel();
        window.add(jp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        jp.startThread();
    }
}
