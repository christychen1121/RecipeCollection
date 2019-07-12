package ui;

import model.ListOfRecipe;
import model.Recipe;

import java.util.Scanner;

public class main {
    public static ListOfRecipe recipeCollection = new ListOfRecipe();
    static Boolean b = true;

    public static void main(String[] args) {

        while (b) {
            printInstruction();
            handleUserInput();
        }
    }

    // EFFECTS: prints out all the instructions shown on the main page
    public static void printInstruction() {
        System.out.println("Hello! What would you like to do?");
        System.out.println("");
        System.out.println("-To Add a New Recipe, Enter '[1]'");
        System.out.println("-To Remove a Recipe, Enter '[2]'");
        System.out.println("-To Show All Recipes, Enter '[3]'");
        System.out.println("-To quit,Enter[4]");
    }

    
    public static void handleUserInput(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num == 1){ addOptions(); }
        else if (num == 2) { removeOptions(); }
             else if (num == 3) {
            ListOfRecipe recipes = new ListOfRecipe();
             recipeCollection.showRecipes(); }
                else if (num == 4){ b = false; }
                     else System.out.println("Please enter again.");
    }

    public static void addOptions(){
        System.out.println("Please enter your recipe.");
        Scanner input = new Scanner(System.in);
        String recipeName = input.nextLine();
        ListOfRecipe recipes = new ListOfRecipe();
        if (recipeCollection.ifAlreadyAdded(recipeName)){
            System.out.println("Recipe already in the list.");
        }
        else
        {Recipe recipe = new Recipe(recipeName);
        recipeCollection.addRecipe(recipe,recipeName);}
    }

    public static void removeOptions(){
        System.out.println("Please select a recipe.");
        ListOfRecipe recipes = new ListOfRecipe();
        recipeCollection.showRecipes();
        Scanner input = new Scanner(System.in);
        String recipeChosen = input.nextLine();
        Recipe recipe = new Recipe(recipeChosen);
        recipeCollection.removeSelection(recipeChosen);
    }

}