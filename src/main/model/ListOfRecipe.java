package model;

import java.util.HashMap;
import java.util.Map;

public class ListOfRecipe {

    private Map<String,Recipe> recipes;

    // EFFECTS: construct an empty map of recipes
    public ListOfRecipe() {
        recipes = new HashMap<>();
    }

    // EFFECTS: return recipes map
    public  Map getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Map<String,Recipe> recipes) {
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
}