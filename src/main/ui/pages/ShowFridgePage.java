package ui.pages;

import model.FoodItem;
import ui.FridageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShowFridgePage extends FridageManager {
    public static final int WIDTH = 624;
    public static final int HEIGHT = 480;

    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_X = 100;

    private JFrame frame = new JFrame("Food In Fridge");
    private Container container = frame.getContentPane();
    private JButton back = new JButton("Back");
    private ImageIcon img = new ImageIcon("/Users/christy/Desktop/cs210/project_jxchen17/data/recipeBookImg.jpg");
    private JLabel recipePic = new JLabel(img);

    public void display() {
        setButton();
        setFrame();
    }

    private void setFrame() {
        container.add(back);
        ((JPanel)container).setOpaque(false);
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.getLayeredPane().add(recipePic,new Integer(Integer.MIN_VALUE));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7,3,5,5));
        frame.setVisible(true);
    }

    private void setButton() {
        for (FoodItem foodItem: fridge.getFridge()) {
            JButton button = new JButton(foodItem.getName());
            container.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,showDetails(foodItem));
                }
            });
        }
        back.setBounds(BUTTON_X,500,BUTTON_WIDTH, BUTTON_HEIGHT);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FridgePage().display();
                frame.setVisible(false);
            }
        });
    }
}
