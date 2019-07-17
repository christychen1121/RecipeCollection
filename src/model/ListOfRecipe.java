package model;

import ui.Saveable;
import ui.Loadable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfRecipe implements Saveable, Loadable {

     private ArrayList<Recipe> recipes;
     private ArrayList<String> recipeNames;

     // EFFECTS: construct an empty list of recipes and an empty list of recipe names
     public ListOfRecipe(){
         recipes = new ArrayList<>();
         recipeNames = new ArrayList<>();
     }

    // EFFECTS: return recipes list
    public ArrayList<Recipe> getRecipe() {
        return this.recipes;
    }

    // EFFECTS: sets the recipes list
    public void setRecipe(ArrayList recipes) {
        this.recipes = recipes;
    }

    // EFFECTS: sets the recipe names list
    public void setRecipeNames(ArrayList recipesName) {
        this.recipeNames = recipesName;
    }

    // EFFECTS: return recipe names list
    public ArrayList<String> getRecipeNames() {
        return this.recipeNames;
    }

    // MODIFIES: this
    // EFFECTS: adds the given recipe to the list of recipe
    //          adds the given recipe name to the list of recipe name
    //          prints a message to notify the user that the recipe is added
    public void addRecipe(Recipe recipe){
        recipeNames.add(recipe.getName());
        recipes.add(recipe);
        System.out.println(recipe.getName() +" added to RecipeCollection!");
    }

    // EFFECTS: returns true if the given recipe name is contained in the list of recipe name,
    //          false otherwise
    public boolean ifAlreadyAdded(String recipeName){
         return recipeNames.contains(recipeName);
    }

    // MODIFIES: this
    // EFFECTS: removes the recipe from the list of recipe
    //          removes the recipe name from the list of recipe names
    //          prints a message to notify the user that the recipe is removed
    private void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
        recipeNames.remove(recipe.getName());
        System.out.println(recipe.getName() + " removed from RecipeCollection!");
    }

    // MODIFIES: this
    // EFFECTS: search the given recipe in the list of recipe
    //          if found, call removeRecipe method to remove that recipe
    public void removeSelection(String recipeChosen){
        for(int i = 0; i< recipes.size(); i++){
            String recipeName = recipes.get(i).getName();
            if(recipeName.equals(recipeChosen)){
                removeRecipe(recipes.get(i)); } }
    }

    // EFFECTS: prints out the name of each recipe in the list
    public void showRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getName());
        }
    }
    // MODIFIES: this
    // EFFECTS: sets the recipes in recipeCollection to the list of recipe read from the file
    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Recipe> result = (List<Recipe>) ois.readObject();
        ois.close();
        setRecipe((ArrayList) result);
        ArrayList<String> recipeNames = new ArrayList<>();
        for(Recipe recipe : result) {
            recipeNames.add(recipe.getName());
        }
        setRecipeNames(recipeNames);
    }

    // MODIFIES: this
    // EFFECTS: save the current list of recipes into the file
    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getRecipe());
        oos.close();
    }
}
