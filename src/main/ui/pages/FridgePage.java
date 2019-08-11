package ui.pages;

import model.FoodItem;
import ui.FridageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FridgePage extends FridageManager {
    public static final int WIDTH = 624;
    public static final int HEIGHT = 480;

    public static final int BUTTON_WIDTH = 320;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_X = 150;

    private JFrame frame = new JFrame("Fridge");
    private Container cp = frame.getContentPane();
    private ImageIcon img = new ImageIcon("/Users/christy/Desktop/cs210/project_jxchen17/data/recipeBookImg.jpg");
    private JLabel recipePic = new JLabel(img);
    private JLabel greeting = new JLabel("Hello! \n What Would You Like To Do?");
    private JButton b1 = new JButton("1. To Show Food in Fridge");
    private JButton b2 = new JButton("2. To Add Food in Fridge");
    private JButton b3 = new JButton("3. To Remove Food from Fridge");
    private JButton b4 = new JButton("4. To Get recipe ideas");
    private JButton b5 = new JButton("5. Quit");

    public void display() {
        setButton();
        setPanel();
        setFrame();
    }

    private void setFrame() {
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        frame.getLayeredPane().add(recipePic,new Integer(Integer.MIN_VALUE));
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void setPanel() {
        cp.setLayout(null);
        ((JPanel)cp).setOpaque(false);
        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
        cp.add(b4);
        cp.add(b5);
        greeting.setBounds(190,70,BUTTON_WIDTH,BUTTON_HEIGHT);
        cp.add(greeting);
    }

    private void setButton() {
        b1.setBounds(BUTTON_X,120,BUTTON_WIDTH,BUTTON_HEIGHT);
        b2.setBounds(BUTTON_X,180,BUTTON_WIDTH,BUTTON_HEIGHT);
        b3.setBounds(BUTTON_X,240,BUTTON_WIDTH,BUTTON_HEIGHT);
        b4.setBounds(BUTTON_X,300,BUTTON_WIDTH,BUTTON_HEIGHT);
        b5.setBounds(BUTTON_X,360,BUTTON_WIDTH,BUTTON_HEIGHT);
        setB1();
        setB2();
        setB3();
        setB4();
        setB5();
    }

    private void setB1() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowFridgePage().display();
                frame.setVisible(false);
            }
        });
    }

    private void setB2() {
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = JOptionPane.showInputDialog("Please Enter Food Item(s).\n (Separate by comma)");
                addFoodInFridge(inputValue);
                try {
                    fridageManager.save("fridge");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void setB3() {
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> foodItems = new ArrayList<>();
                for (FoodItem foodItem: fridge.getFridge()) {
                    foodItems.add(foodItem.getName());
                }
                Object[] possibleValues = foodItems.toArray();
                Object selectedValue = JOptionPane.showInputDialog(null,"Please Select the Food to Remove",
                        "input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                fridge.removeFromFridge((String) selectedValue);
            }
        });
    }

    private void setB4() {
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = JOptionPane.showInputDialog("Please Enter An Ingredient For Searching");
                try {
                    JOptionPane.showMessageDialog(null, searchIngredient(searchValue));

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void setB5() {
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    recipeManager.save("recipecollection");
                    save("fridge");
                    new MainPage().display();
                    frame.dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
