package ui.pages;

import javafx.scene.media.AudioClip;
import ui.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


class MainPage extends Application {
    public static final int WIDTH = 624;
    public static final int HEIGHT = 480;

    public static final int BUTTON_WIDTH = 320;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_X = 150;

    private JFrame frame = new JFrame("Welcome Page");
    private Container cp = frame.getContentPane();

    private JButton b1 = new JButton("1. Go To RecipeCollection");
    private JButton b2 = new JButton("2. Go To Fridge");
    private JButton b3 = new JButton("3. Quit");
    private JLabel greeting = new JLabel("Hello! \n What Would You Like To Do?");

    private ImageIcon img = new ImageIcon("src/main/ui/pages/recipeBookImg.jpg");
    private JLabel recipePic = new JLabel(img);


    public static void main(String[] args) {
        try {
            recipeManager.load("Recipe");
            fridageManager.load("fridge");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        (new MainPage()).display();
        AudioClip audioClip = new AudioClip(new File(
                "data/The Winding Paths.mp3").toURI().toString());
        audioClip.play();
    }

    public void display() {
        setLabel();
        setButton();
        setCp();
        setFrame();
    }

    private void setFrame() {
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.getLayeredPane().add(recipePic,new Integer(Integer.MIN_VALUE));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setCp() {
        cp.setLayout(null);
        ((JPanel)cp).setOpaque(false);
        cp.add(greeting);
        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
    }

    private void setLabel() {
        greeting.setBounds(190,70,BUTTON_WIDTH,BUTTON_HEIGHT);
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
    }

    private void setButton() {
        setB1();
        setB2();
        setB3();
    }

    private void setB1() {
        b1.setBounds(BUTTON_X,150,BUTTON_WIDTH,BUTTON_HEIGHT);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RecipeCollectionPage().display();
            }
        });
    }

    private void setB2() {
        b2.setBounds(BUTTON_X,230,BUTTON_WIDTH,BUTTON_HEIGHT);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new FridgePage().display();
            }
        });
    }

    private void setB3() {
        b3.setBounds(BUTTON_X,310,BUTTON_WIDTH,BUTTON_HEIGHT);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fridageManager.save("fridge");
                    recipeManager.save("Recipe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });
    }
}
