package ui.pages;

import ui.RecipeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

public class RecipeCollectionPage extends RecipeManager {
    public static final int WIDTH = 624;
    public static final int HEIGHT = 480;

    public static final int BUTTON_WIDTH = 320;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_X = 150;

    private JFrame frame = new JFrame("RecipeCollection");
    private Container cp = frame.getContentPane();
    private JLabel greeting = new JLabel("Hello! \n What Would You Like To Do?");
    private JButton b1 = new JButton("1. To Add A New Recipe");
    private JButton b2 = new JButton("2. To Remove A Recipe");
    private JButton b3 = new JButton("3. To Show All Recipes");
    private JButton b4 = new JButton("4. Quit");
    private ImageIcon img = new ImageIcon(getClass().getResource("recipeBookImg.jpg"));
    private JLabel recipePic = new JLabel(img);

    public void display()  {
        setButton();
        setCp();
        setFrame();
    }

    private void setCp() {
        cp.setLayout(null);
        ((JPanel)cp).setOpaque(false);
        greeting.setBounds(190,70,BUTTON_WIDTH,BUTTON_HEIGHT);
        cp.add(greeting);
        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
        cp.add(b4);
    }

    private void setFrame() {
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        frame.getLayeredPane().add(recipePic,new Integer(Integer.MIN_VALUE));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setButton() {
        setB1();
        setB2();
        setB3();
        setB4();
    }

    private void setB1() {
        b1.setBounds(BUTTON_X,120,BUTTON_WIDTH,BUTTON_HEIGHT);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibleValues = {"RegularRecipe", "FavouriteRecipe"};
                Object selectedValue = JOptionPane.showInputDialog(null,"Please Select the Type of Recipe to Add.",
                        "input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                if (selectedValue == "RegularRecipe") {
                    frame.setVisible(false);
                    new AddRegRecipePage().display();
                } else if (selectedValue == "FavouriteRecipe") {
                    frame.setVisible(false);
                    new AddFavRecipePage().display();
                }
            }
        });
    }

    private void setB2() {
        b2.setBounds(BUTTON_X,180,BUTTON_WIDTH,BUTTON_HEIGHT);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<String> mySet = recipeCollection.getRecipes().keySet();
                Object[] possibleValues = mySet.toArray();
                Object selectedValue = JOptionPane.showInputDialog(null,"Please Select the Recipe to Remove.",
                        "input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                recipeCollection.removeFromList((String) selectedValue);
            }
        });
    }

    private void setB3() {
        b3.setBounds(BUTTON_X,240,BUTTON_WIDTH,BUTTON_HEIGHT);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowRecipePage().display();
                frame.setVisible(false);
            }
        });
    }

    private void setB4() {
        b4.setBounds(BUTTON_X,300,BUTTON_WIDTH,BUTTON_HEIGHT);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save("recipecollection");
                    fridageManager.save("fridge");
                    frame.dispose();
                    new MainPage().display();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
