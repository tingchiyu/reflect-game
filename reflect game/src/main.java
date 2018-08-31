import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class main {
    public static void main(String arg[]){
        JFrame f = new JFrame("reflect game");
        f.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        f.setVisible(true);
        f.setSize(600,600);
        JTextField t = new JTextField("Press enter to start, press space bar when the screen turns yellow");
        t.setHorizontalAlignment(JTextField.CENTER);
        f.getContentPane().add(t);
        f.setVisible(true);
        KeyListener lis = new KeyListener() {
            long tStart;

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    t.setText("Ready");
                }
                if (e.getKeyCode() == 32){
                    long tEnd = System.nanoTime();
                    t.setBackground(Color.WHITE);
                    t.setText("Your reaction time is: " + ((tEnd - tStart)/Math.pow(10, 9)) + "seconds");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    tStart = startGame(f, t);
                }
            }
        };
        f.addKeyListener(lis);
    }
    public static long startGame(JFrame f, JTextField t){
        Random rand = new Random();
        int r = rand.nextInt(8) + 2;
        try {
            Thread.sleep(r * 1000);
        } catch (InterruptedException ex){}
        t.setBackground(Color.YELLOW);
        t.setText("Press space bar now");
        return System.nanoTime();
    }
}