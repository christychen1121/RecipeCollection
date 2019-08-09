package ui.pages;

import model.Recipe;
import ui.RecipeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;


public class ShowRecipePage extends RecipeManager {

    private static final int WIDTH = 624;
    private static final int HEIGHT = 480;

    private static final int BUTTON_WIDTH = 450;
    private static final int BUTTON_HEIGHT = 30;
    private static final int BUTTON_X = 70;
    private JFrame frame = new JFrame("Welcome Page");
    private Container cp = frame.getContentPane();
    private JLabel heading = new JLabel("All Recipes:");
    private JButton back = new JButton("Back");
    private ImageIcon img = new ImageIcon(getClass().getResource("recipeBookImg.jpg"));
    private JLabel recipePic = new JLabel(img);

    public void display() {
        setButton();
        setPanel();
        setFrame();
    }

    private void setFrame() {
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getLayeredPane().add(recipePic,new Integer(Integer.MIN_VALUE));
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void setPanel() {
        cp.setLayout(null);
        ((JPanel)cp).setOpaque(false);
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        heading.setBounds(50,80,BUTTON_WIDTH,BUTTON_HEIGHT);
        cp.add(heading);
        cp.add(back);
    }

    private void setButton() {
        Set<String> mySet = recipeCollection.getRecipes().keySet();
        int y = 100;
        for (String s: mySet) {
            y = y + 40;
            JButton button = new JButton(s);
            button.setBounds(BUTTON_X,y,BUTTON_WIDTH,BUTTON_HEIGHT);
            cp.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Recipe recipe = (Recipe) recipeCollection.getRecipes().get(s);
                    JOptionPane.showMessageDialog(null, recipe.showDetails());
                }
            });
        }
        setBack();
    }

    private void setBack() {
        back.setBounds(280,400,80, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RecipeCollectionPage().display();
                frame.setVisible(false);
            }
        });
    }
}
