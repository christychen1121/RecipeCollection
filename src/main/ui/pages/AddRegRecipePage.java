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

    private JFrame frame = new JFrame("Add Recipe Page");
    private Container cp = frame.getContentPane();
    private ImageIcon img = new ImageIcon(getClass().getResource("recipeBookImg.jpg"));
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
        name.setBounds(100,100,100,50);
        time.setBounds(100,180,100,50);
        category.setBounds(100,260,100,50);
        ingredients.setBounds(100,340,100,50);

        nameInput.setBounds(200,100,160,40);
        timeInput.setBounds(200,180,160,40);
        String[] listData = new String[]{"breakfast","main dish","snack"};
        categoryInput = new JComboBox<>(listData);
        categoryInput.setBounds(200,260,180,50);
        ingredientInput.setBounds(200,340,250,100);
        ingredientInput.setLineWrap(true);

        done.setBounds(250,500,100,50);
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
                    recipeManager.save("recipecollection");
                    new MainPage().display();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(false);
            }
        });
    }
}
