package ui.pages;

import model.FavouriteRecipe;
import model.Recipe;
import ui.RecipeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddFavRecipePage extends RecipeManager {
    public static final int WIDTH = 624;
    public static final int HEIGHT = 480;

    private JFrame frame = new JFrame("Add Recipe Page");
    private Container cp = frame.getContentPane();
    private ImageIcon img = new ImageIcon(getClass().getResource("recipeBookImg.jpg"));
    private JLabel recipePic = new JLabel(img);

    private JLabel name = new JLabel("Name: ");
    private JLabel time = new JLabel("Cooking Time: ");
    private JLabel category = new JLabel("Category: ");
    private JLabel ingredients = new JLabel("Ingredients: ");
    private JLabel instructions = new JLabel("Instructions: ");
    private JTextField nameInput = new JTextField();
    private JTextField timeInput = new JTextField();
    private JComboBox<String> categoryInput;
    private JTextArea ingredientInput = new JTextArea();
    private JTextArea instructionInput = new JTextArea();
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
        cp.add(instructions);
        cp.add(nameInput);
        cp.add(timeInput);
        cp.add(categoryInput);
        cp.add(ingredientInput);
        cp.add(instructionInput);
        cp.add(done);
    }

    private void setLabelAndText() {
        recipePic.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        name.setBounds(100,80,100,50);
        time.setBounds(100,130,100,50);
        category.setBounds(100,180,100,50);
        ingredients.setBounds(100,230,100,50);
        instructions.setBounds(100,320,100,50);

        nameInput.setBounds(200,80,160,40);
        timeInput.setBounds(200,130,160,40);
        String[] listData = new String[]{"breakfast","main dish","snack"};
        categoryInput = new JComboBox<>(listData);
        categoryInput.setBounds(200,180,180,50);
        ingredientInput.setBounds(200,230,250,60);
        ingredientInput.setLineWrap(true);
        instructionInput.setBounds(200,320,300,150);
        instructionInput.setLineWrap(true);
        done.setBounds(250,500,100,50);
    }

    private void setButton() {
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recipe favouriteRecipe = new FavouriteRecipe(nameInput.getText(),
                        (String)categoryInput.getSelectedItem(),Integer.parseInt(timeInput.getText()));
                String s = ingredientInput.getText();
                setIngredients(favouriteRecipe,s);
                String s1 = instructionInput.getText();
                setInstructions(favouriteRecipe,s1);

                recipeCollection.addToList(favouriteRecipe);
                JOptionPane.showMessageDialog(null,favouriteRecipe.getName() + " has been added!");
                save();
                frame.setVisible(false);
            }
        });
    }

    private void save() {
        try {
            recipeManager.save("recipecollection");
            new MainPage().display();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
