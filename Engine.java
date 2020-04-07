import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Engine extends KeyAdapter {
    Coords UP = new Coords(-1, 0);
    Coords DOWN = new Coords(1, 0);
    Coords LEFT = new Coords(0, -1);
    Coords RIGHT = new Coords(0, 1);


    public static void playerMove(Coords coords) {
        JTextField textField = new JTextField();

        // textField.addKeyListener(new Game());
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                playerMove(UP);
                break;
            case 's':
            playerMove(DOWN);
                break;
            case 'a':
            playerMove(LEFT);
                break;
            case 'd':
            playerMove(RIGHT);
                break;   
        }
    }
}

