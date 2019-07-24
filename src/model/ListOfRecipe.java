package model;

import ui.Loadable;
import ui.Saveable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfRecipe implements Loadable, Saveable {

    private ArrayList<Recipe> recipes;

    // EFFECTS: construct an empty list of recipes
     public ListOfRecipe(){
         recipes = new ArrayList<>();
     }

    // EFFECTS: return regularRecipes list
    public ArrayList<Recipe> getRecipe() {
        return this.recipes;
    }

    // EFFECTS: sets the regularRecipes list
    public void setRecipe(ArrayList recipes) {
        this.recipes = recipes;
    }

    // MODIFIES: this
    // EFFECTS: adds the given regularRecipe to the list of regularRecipe
    //          adds the given regularRecipe name to the list of regularRecipe name
    //          prints a message to notify the user that the regularRecipe is added
    public void addToList(Recipe recipe){
        recipes.add(recipe);
        System.out.println(recipe.getName() +" added to RecipeCollection!");
    }

    // EFFECTS: returns true if the given recipe name is contained in the list of recipe name,
    //          false otherwise
    public boolean ifAlreadyAdded(String recipeName){
         ArrayList<String> recipeNames = new ArrayList<>();
         for (Recipe recipe: recipes) {
             recipeNames.add(recipe.getName());
         }
        return recipeNames.contains(recipeName);
    }

    // MODIFIES: this
    // EFFECTS: removes the regularRecipe from the list of regularRecipe
    //          removes the regularRecipe name from the list of regularRecipe names
    //          prints a message to notify the user that the regularRecipe is removed
    protected void removeFromList(Recipe recipe){
        recipes.remove(recipe);
        System.out.println(recipe.getName() + " removed from RecipeCollection!");
    }

    // MODIFIES: this
    // EFFECTS: search the given recipe in the list of recipe
    //          if found, call removeFromList method to remove that recipe
    public void removeSelection(String recipeChosen){
        for(int i = 0; i< recipes.size(); i++){
            String recipeName = recipes.get(i).getName();
            if(recipeName.equals(recipeChosen)){
                removeFromList(recipes.get(i)); } }
    }

    // EFFECTS: prints out the name of each recipe in the list
    public void showList() {
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(i+1 + "." + recipes.get(i).getName());
        }
        showDetails();

    }
    // EFFECTS: print out details of the recipe chosen
    private void showDetails() {
        System.out.println("To see details, please print out number of the recipe.");
        Scanner input = new Scanner(System.in);
        int recipeChosen = input.nextInt();
        for (int i = 0; i < recipes.size(); i++) {
            if (i == recipeChosen-1) {
                recipes.get(i).showDetails();
            }
        }

    }
    // MODIFIES: this
    // EFFECTS: sets the regularRecipes in recipeCollection to the list of recipe read from the file
    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<RegularRecipe> result = (List<RegularRecipe>) ois.readObject();
        ois.close();
        setRecipe((ArrayList) result);
    }

    // MODIFIES: this
    // EFFECTS: save the current list of regularRecipes into the file
    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getRecipe());
        oos.close();
    }
}