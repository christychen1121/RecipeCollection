package ui;

import model.Exceptions.InvalidInputException;
import model.FavouriteRecipe;
import model.ListOfRecipe;
import model.Recipe;
import model.RegularRecipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecipeCollection {
    public static ListOfRecipe recipeCollection = new ListOfRecipe();
    static Boolean b = true;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        recipeCollection.load("recipecollection");
        while (b) {
            printInstruction();
            handleUserInput();
        }
    }

    // EFFECTS: prints out all the instructions shown on the RecipeCollection page
    public static void printInstruction() {
        System.out.println("Hello! What would you like to do?\n");
        System.out.println("-To Add a New Recipe, Enter '[1]'");
        System.out.println("-To Remove a Recipe,  Enter '[2]'");
        System.out.println("-To Show All Recipes, Enter '[3]'");
        System.out.println("-To quit,             Enter '[4]'");
    }

    // EFFECTS: calls different methods based on user's input
    public static void handleUserInput() throws IOException {
        try {
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            switch (num) {
            case 1:
                addOptions();
                break;
            case 2:
                removeOptions();
                break;
            case 3:
                recipeCollection.showList();
                break;
            case 4:
                recipeCollection.save("recipecollection");
                b = false;
                break;
            default:
                System.out.println("Invalid option. Please enter again.");
            }
        } catch(InputMismatchException e) {
            System.out.println("Your input is invalid. Please enter again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: checks to see if the recipe has been added, if true, prints a message
    //          that says the recipe is already in the list, otherwise, add the recipe
    //          into the list
    public static void addOptions() {
        System.out.println("Please enter your recipe.");
        Scanner input = new Scanner(System.in);
        String recipeName = input.nextLine();
        if (recipeCollection.ifAlreadyAdded(recipeName)) {
            System.out.println(recipeName + " is already in the list.");
        } else {
            recipeCollection.addToList(recipeKinds(recipeName));
        }
    }

    // MODIFIES: Recipe
    // EFFECTS: constructs different kinds of recipe according to the user's input
    public static Recipe recipeKinds(String recipeName) {
        System.out.println("-To Add a Regular Recipe,   Enter '[1]'");
        System.out.println("-To Add a Favourite Recipe, Enter '[2]'");
        Recipe recipe = null;
        try {
            Scanner input = new Scanner(System.in);
            int recipeChosen = input.nextInt();
            switch (recipeChosen) {
            case 1:
                recipe = new RegularRecipe(recipeName);
                setCategoryandTime(recipe);
                setIngredients(recipe);
                break;
            case 2:
                recipe = new FavouriteRecipe(recipeName);
                setCategoryandTime(recipe);
                setIngredients(recipe);
                setInstructions(recipe);
                break;
            default:
                System.out.println("Invalid option. Please enter again.");
                recipeKinds(recipeName);
            }
        } catch(InputMismatchException e) {
            System.out.println("Your input is invalid. Please enter again.");
            recipeKinds(recipeName);
        }
        finally {
            return recipe;
        }
    }

    private static void setCategoryandTime(Recipe recipe) {
        System.out.println("Please enter category and cooking time for this recipe.");
        Scanner input = new Scanner (System.in);
        String s = input.nextLine();
        String[] splits = s.split(",");
        String category = splits[0];
        int time = Integer.parseInt(splits[1]);
        try {
            recipe.setCategory(category);
            recipe.setCookingTime(time);
        } catch (InvalidInputException ie) {
            ie.printErrorMessage();
            setCategoryandTime(recipe);
        }
    }

    private static void setIngredients(Recipe recipe) {
        System.out.println("Please enter the ingredients for this recipe.");
        Scanner input = new Scanner (System.in);
        String s = input.nextLine();
        String[] splits = s.split(",");
        ArrayList<String> ingredients = new ArrayList<>();
        for (String ingredient: splits) {
            ingredients.add(ingredient);
        }
        recipe.setIngredients(ingredients);
    }

    private static void setInstructions(Recipe favrecipe) {
        System.out.println("Please enter the instructions for this recipe.");
        Scanner input = new Scanner (System.in);
        String s = input.nextLine();
        String[] splits = s.split("/");
        ArrayList<String> instructions = new ArrayList<>();
        for (String instruction: splits) {
            instructions.add(instruction);
        }
        favrecipe.setInstruction(instructions);
    }

    // MODIFIES: this
    // EFFECTS: removes the selected recipe from the list
    public static void removeOptions() {
        System.out.println("Please enter the name of recipe to remove.");
        recipeCollection.showList();
        Scanner input = new Scanner(System.in);
        String recipeChosen = input.nextLine();
        recipeCollection.removeSelection(recipeChosen);
    }
}