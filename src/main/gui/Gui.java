package gui;

import javax.swing.*;
import java.awt.*;

class Gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocation(400,100);
//        frame.setSize(600,600);
        frame.setBounds(400,100,600,600);
        Container container = frame.getContentPane();
        JButton b1 = new JButton("1. Go To RecipeCollection");
        JButton b2 = new JButton("2. Go To Fridge");
        JButton b3 = new JButton("3. Quit");
        frame.getContentPane().add(BorderLayout.NORTH,b1);
        frame.getContentPane().add(BorderLayout.CENTER,b2);
        frame.getContentPane().add(BorderLayout.SOUTH,b3);
        frame.setVisible(true);
    }
}
