package ui;

import javax.swing.*;
import java.awt.*;


class MainPage extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public static final int BUTTON_WIDTH = 400;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_X = 100;

    public void display() {
        JFrame frame = new JFrame("Welcome Page");
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.PINK);

        JLabel greeting = new JLabel("Welcome! \n What Would You Like To Do?");
        greeting.setBounds(190,100,BUTTON_WIDTH,BUTTON_HEIGHT);
        panel.add(greeting);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        (new MainPage()).display();
        /* JButton b1 = new JButton("1. Go To RecipeCollection");
        JButton b2 = new JButton("2. Go To Fridge");
        JButton b3 = new JButton("3. Quit");
        b1.setBounds(BUTTON_X,200,BUTTON_WIDTH,BUTTON_HEIGHT);
        b2.setBounds(BUTTON_X,280,BUTTON_WIDTH,BUTTON_HEIGHT);
        b3.setBounds(BUTTON_X,360,BUTTON_WIDTH,BUTTON_HEIGHT);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);*/

//        b1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//            }
//        });
//
//        b2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//            }
//        });
//
//        b3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//            }
//        });
    }
}
