package model;

import java.util.ArrayList;

public class ListOfRecipe {

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

    // EFFECTS: return recipe names list
    public ArrayList<String> getRecipeNames() {
        return this.recipeNames;
    }

    // MODIFIES: this
    // EFFECTS: adds the given recipe to the list of recipe
    //          adds the given recipe name to the list of recipe name
    //          prints a message to notify the user that the recipe is added
    public void addRecipe(Recipe recipe, String recipeName){
        recipe.setName(recipeName);
        recipeNames.add(recipeName);
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
    //          prints a message to notify the user that the recipe is removed
    private void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
        System.out.println(recipe.getName() + " removed from RecipeCollection!");
    }

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
}
