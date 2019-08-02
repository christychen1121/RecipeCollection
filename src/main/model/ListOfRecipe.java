package model;

import java.io.*;
import java.util.*;

public class ListOfRecipe implements Loadable, Saveable {

    private Map<String,Recipe> recipes;

    // EFFECTS: construct an empty map of recipes
    public ListOfRecipe() {
        recipes = new HashMap<>();
    }

    // EFFECTS: return recipes map
    public  Map getRecipes() {
        return this.recipes;
    }

    // MODIFIES: this
    // EFFECTS: sets the recipes map
    private void setRecipes(Map recipes) {
        this.recipes = recipes;
    }

    // MODIFIES: this
    // EFFECTS: adds the given recipe to the list of recipe
    //          prints a message to notify the user that the recipe is added
    public void addToList(Recipe recipe) {
        recipes.put(recipe.getName(),recipe);
        System.out.println(recipe.getName() + " added to RecipeCollection!");
    }

    // EFFECTS: returns true if the given recipe name is contained in the list of recipe name,
    //          false otherwise
    public boolean ifAlreadyAdded(String recipeName) {
        return (recipes.get(recipeName) != null);
    }

    // MODIFIES: this
    // EFFECTS: removes the recipe from the list of recipe
    //          prints a message to notify the user that the regularRecipe is removed
    public void removeFromList(String recipeName) {
        if (recipes.containsKey(recipeName)) {
            recipes.remove(recipeName);
            System.out.println(recipeName + " removed from RecipeCollection!");
        }
    }

    // EFFECTS: prints out the name of each recipe in the list
    public void showList() {
        System.out.println(recipes.keySet());
    }

    // EFFECTS: print out details of the recipe chosen
    public void showDetails() {
        System.out.println("To see details, please print out name of the recipe.");
        Scanner input = new Scanner(System.in);
        String recipeChosen = input.nextLine();
        recipes.get(recipeChosen).showDetails();
    }

    // MODIFIES: this
    // EFFECTS: sets the recipes in recipeCollection to the list of recipe read from the file
    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap<String,Recipe> result = (HashMap<String,Recipe>) ois.readObject();
        ois.close();
        setRecipes(result);
    }

    // MODIFIES: this
    // EFFECTS: save the current list of recipes into the file
    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getRecipes());
        oos.close();
    }
}