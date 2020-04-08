import javax.swing.*;


public class Engine {
    public static void jFrame(Game giera) {
        JTextField textField = new JTextField();

        textField.addKeyListener(giera);
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
}
