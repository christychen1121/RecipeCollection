package ui;

import model.ListOfRecipe;
import model.Recipe;

import java.io.IOException;
import java.util.Scanner;

public class RecipeCollection {
    public static ListOfRecipe recipeCollection = new ListOfRecipe();
    static Boolean b = true;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        recipeCollection.load("recipecollection.ser");
        while (b) {
            printInstruction();
            handleUserInput();
        }
    }

    // EFFECTS: prints out all the instructions shown on the RecipeCollection page
    public static void printInstruction() {
        System.out.println("Hello! What would you like to do?");
        System.out.println("");
        System.out.println("-To Add a New Recipe, Enter '[1]'");
        System.out.println("-To Remove a Recipe, Enter '[2]'");
        System.out.println("-To Show All Recipes, Enter '[3]'");
        System.out.println("-To quit,Enter[4]");
    }


    // EFFECTS: calls different methods based on user's input
    public static void handleUserInput() throws IOException {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        switch (num) {
            case 1: addOptions(); break;
            case 2: removeOptions(); break;
            case 3: recipeCollection.showRecipes();
                    break;
            case 4: recipeCollection.save("recipecollection.ser");
                    b = false; break;
            default:
                System.out.println("Please enter again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: checks to see if the recipe has been added, if true, prints a message
    //          that says the recipe is already in the list, otherwise, add the recipe
    //          into the list
    public static void addOptions(){
        System.out.println("Please enter your recipe.");
        Scanner input = new Scanner(System.in);
        String recipeName = input.nextLine();
        if (recipeCollection.ifAlreadyAdded(recipeName)){
            System.out.println(recipeName+ " is already in the list.");
        }
        else
        {Recipe recipe = new Recipe(recipeName);
        recipeCollection.addRecipe(recipe);}
    }

    // MODIFIES: this
    // EFFECTS: removes the selected recipe from the list
    public static void removeOptions(){
        System.out.println("Please select a recipe.");
        recipeCollection.showRecipes();
        Scanner input = new Scanner(System.in);
        String recipeChosen = input.nextLine();
        recipeCollection.removeSelection(recipeChosen);
    }

}
