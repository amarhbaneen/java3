package utilities;

import java.awt.*;
import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing");
        final JLabel label = new JLabel("Hello World,Hello Worl,Hello Worl,Hello WorlHello Worl");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);    }
}
