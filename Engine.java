import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {
    public static void jFrame(Game giera) {
        JTextField textField = new JTextField();

        textField.addKeyListener(giera);
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }

    static int randomIntFromRange(int min, int max) {
        int randomInt = ThreadLocalRandom.current().nextInt(min, max);
        return randomInt;
    }
}
