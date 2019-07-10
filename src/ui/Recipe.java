package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {

     String name;
     String Category; // based on meal time
     String DifficultyLevel; //Easy, Medium, Difficult
     int CookingTime; // in minutes

    static ArrayList<Recipe> RecipeCollection = new ArrayList<>();
    static ArrayList<String> recipeNames = new ArrayList<>();


    public static void main (String[] args){
        Boolean b = true;
        while (b){
            mainPage();
        }

        Recipe r1 = new Recipe();
        r1.name = "Avocado Toast";
        r1.Category = "Breakfast";
        r1.DifficultyLevel = "Easy";
        r1.CookingTime = 10;

    }

    public static void mainPage(){
        System.out.println("Hello! What would you like to do?");
        printInstruction();
        handleUserInput();

    }

    public static void handleUserInput(){

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        if (s.equals("add")){
            System.out.println("Please enter your recipe.");
            String s1 = input.nextLine();
            if(ifAlreadyAdded(s1)) {
                System.out.println("Recipe already in the list.");
            }
            else{
                Recipe recipe = new Recipe();
                recipe.addRecipe(recipe, s1);
            }
        }
        else {
            if (s.equals("remove")) {
                System.out.println("Please select a recipe.");
                showRecipes();
                String recipeChosen = input.nextLine();
                for(int i=0; i<RecipeCollection.size();i++){
                    String recipeName = RecipeCollection.get(i).name;
                    if(recipeName.equals(recipeChosen)){
                        RecipeCollection.get(i).removeRecipe(RecipeCollection.get(i));
                    }
                }
            } else {
                if (s.equals("show")) {
                    showRecipes();

                } else System.out.println("Please enter again.");
            }
        }
    }
    public static void printInstruction(){
        System.out.println("");
        System.out.println("-To Add a New Recipe, Enter add ");
        System.out.println("-To Remove a Recipe, Enter remove");
        System.out.println("-To Show All Recipes, Enter show");
    }

    public void addRecipe(Recipe recipe, String recipeName){
        recipe.name = recipeName;
        recipeNames.add(recipeName);
        RecipeCollection.add(recipe);
        System.out.println(recipe.name +" added to RecipeCollection!");
    }
    public static boolean ifAlreadyAdded(String recipeName){
        return recipeNames.contains(recipeName);
    }
    public static void removeRecipe(Recipe recipe){
        RecipeCollection.remove(recipe);
        System.out.println(recipe.name + " removed from RecipeCollection!");
    }
    public static void showRecipes(){
        for (Recipe recipe : RecipeCollection){
            System.out.println(recipe.name);
        }
    }
}
