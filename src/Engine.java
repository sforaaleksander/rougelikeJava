package src;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Engine {

    public static void playerMove(){

    Coords W = new Coords(-1, 0);
    Coords S = new Coords(1, 0);
    Coords A = new Coords(0, -1);
    Coords D = new Coords(0, 1);
    }


    public static void walk()) {
        JTextField textField = new JTextField();

        textField.addKeyListener(new Game());
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
}


class Game extends KeyAdapter {
    
    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                // code block
                // Hero.moveUp()

                break;
            case 's':
                // code block
                // Hero.moveDown()
                break;
            case 'a':
                // code block
                // Hero.moveLeft()
                break;
            case 'd':
                // code block
                // Hero.moveRight()
                break;   
        }
    }
}
}