package ui;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class RecipeManager extends Application implements Loadable,Saveable {

    protected void setIngredients(Recipe recipe,String s) {
        String[] splits = s.split(",");
        for (String foodItem: splits) {
            FoodItem ingredient = new FoodItem(foodItem);
            recipe.addIngredient(ingredient);
            fridge.addToIngredientList(ingredient);
        }
    }

    protected void setInstructions(Recipe recipe, String s) {
        String[] splits = s.split("\n");
        ArrayList<String> instructions = new ArrayList<>();
        for (String split: splits) {
            instructions.add(split);
        }
        ((FavouriteRecipe)recipe).setInstruction(instructions);
    }

    // EFFECTS: sets the recipes in recipeCollection to the list of recipe read from the file
    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap<String,Recipe> result = (HashMap<String,Recipe>) ois.readObject();
        ois.close();
        recipeCollection.setRecipes(result);
    }

    // EFFECTS: save the current list of recipes into the file
    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(recipeCollection.getRecipes());
        oos.close();
    }
}