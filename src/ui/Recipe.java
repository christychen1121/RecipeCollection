package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {

    private String name;
    private String Category; // based on meal time
    private String DifficultyLevel; //Easy, Medium, Difficult
    private int CookingTime; // in minutes

    static ArrayList<Recipe> RecipeCollection = new ArrayList<>();
    Scanner input;

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

            Recipe recipe = new Recipe();
            recipe.name = s1;
            recipe.addRecipe(recipe);
            ArrayList<String> recipeNames = new ArrayList<>();
            recipeNames.add(s1);
        }
        else {
            if (s.equals("remove")) {
                System.out.println("Please select a recipe.");
                showRecipes();
                String s2 = input.nextLine();
                for(int i=0; i<RecipeCollection.size();i++){
                    String recipeName = RecipeCollection.get(i).name;
                    if(recipeName.equals(s2)){
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
        System.out.println("-Add a New Recipe");
        System.out.println("-Remove a Recipe");
        System.out.println("-Show All Recipes");
    }

    public void addRecipe(Recipe recipe){
//        if (verify(recipe.name)){
//            System.out.println(recipe.name + " is already in the list.");
//        }
//        else {
            RecipeCollection.add(recipe);
            System.out.println(recipe.name +" added to RecipeCollection!");
        }

//    }

    //public boolean verify(String recipeName){
       // return (recipeNames.contains(recipeName));
    //}

    public void removeRecipe(Recipe recipe){
        RecipeCollection.remove(recipe);
        System.out.println(recipe.name + " removed from RecipeCollection!");

    }

    public static void showRecipes(){
        for (Recipe recipe : RecipeCollection){
            System.out.println(recipe.name);
        }

    }
}
