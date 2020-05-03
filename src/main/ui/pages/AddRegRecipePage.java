package ui.pages;

import model.Recipe;
import model.RegularRecipe;
import ui.RecipeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddRegRecipePage extends RecipeManager {
    private static final int WIDTH = 624;
    private static final int HEIGHT = 480;
    private static final int LABEL_X = 130;
    private static final int AREA_X = 220;
    private static final int LABEL_WIDTH = 100;
    private static final int LABEL_HEIGHT = 50;

    private JFrame frame = new JFrame("Add Recipe Page");
    private Container cp = frame.getContentPane();
    private ImageIcon img = new ImageIcon("src/main/ui/pages/recipeBookImg.jpg");
    private JLabel recipePic = new JLabel(img);

    private JLabel name = new JLabel("Name: ");
    private JLabel time = new JLabel("Cooking Time: ");
    private JLabel category = new JLabel("Category: ");
    private JLabel ingredients = new JLabel("Ingredients: ");
    private JTextField nameInput = new JTextField();
    private JTextField timeInput = new JTextField();
    private JComboBox<String> categoryInput;
    private JTextArea ingredientInput = new JTextArea();
    private JButton done = new JButton("Done!");

    public void display() {
        setButton();
        setLabelAndText();
        setPanel();
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

    private void setPanel() {
        cp.setLayout(null);
        ((JPanel)cp).setOpaque(false);
        cp.add(name);
        cp.add(time);
        cp.add(category);
        cp.add(ingredients);
        cp.add(nameInput);
        cp.add(timeInput);
        cp.add(categoryInput);
        cp.add(ingredientInput);
        cp.add(done);
    }

    private void setLabelAndText() {
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        name.setBounds(LABEL_X,80,LABEL_WIDTH,LABEL_HEIGHT);
        time.setBounds(LABEL_X,130,LABEL_WIDTH,LABEL_HEIGHT);
        category.setBounds(LABEL_X,180,LABEL_WIDTH,LABEL_HEIGHT);
        ingredients.setBounds(LABEL_X,230,LABEL_WIDTH,LABEL_HEIGHT);

        nameInput.setBounds(AREA_X,80,160,40);
        timeInput.setBounds(AREA_X,130,160,40);
        String[] listData = new String[]{"breakfast","main dish","snack"};
        categoryInput = new JComboBox<>(listData);
        categoryInput.setBounds(AREA_X,180,180,50);
        ingredientInput.setBounds(AREA_X,230,250,100);
        ingredientInput.setLineWrap(true);

        done.setBounds(250,400,LABEL_WIDTH,LABEL_HEIGHT);
    }

    private void setButton() {
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recipe regularRecipe = new RegularRecipe(nameInput.getText(),
                        (String)categoryInput.getSelectedItem(),Integer.parseInt(timeInput.getText()));
                String s = ingredientInput.getText();
                setIngredients(regularRecipe,s);
                recipeCollection.addToList(regularRecipe);
                JOptionPane.showMessageDialog(null,regularRecipe.getName() + " has been added!");
                try {
                    recipeManager.save("Recipe");
                    new MainPage().display();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(false);
            }
        });
    }
}
