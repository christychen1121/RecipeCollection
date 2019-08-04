package ui;

import model.*;
import exception.InvalidInputException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecipeManager extends Application {
//    private static Fridge fridge = new Fridge();
//    private static ListOfRecipe recipeCollection = new ListOfRecipe();
//    private static Boolean b = true;

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        recipeCollection.load("recipecollection");
//        fridge.load("fridge");
//        while (b) {
//            printInstruction();
//            handleUserInput();
//        }
//    }

//    // EFFECTS: prints out all the instructions shown on the RecipeCollection page
//    private static void printInstruction() {
//        System.out.println("\nHello! What would you like to do?\n");
//        System.out.println("-Go to RecipeCollection,    Enter '[1]'");
//        System.out.println("-Go to Fridge,              Enter '[2]'");
//        System.out.println("-To quit,                   Enter '[3]'");
//    }

    public void printRecipeInstruction() {
        System.out.println("-To Add a New Recipe,         Enter '[1]'");
        System.out.println("-To Remove a Recipe,          Enter '[2]'");
        System.out.println("-To Show All Recipes,         Enter '[3]'");
        System.out.println("-To quit,                     Enter '[4]'");
    }

//    public void printFridgeInstruction() {
//        System.out.println("-To Show Food in Fridge,      Enter '[1]'");
//        System.out.println("-To Add Food in Fridge,       Enter '[2]'");
//        System.out.println("-To remove Food from Fridge,  Enter '[3]'");
//        System.out.println("-To quit,                     Enter '[4]'");
//    }

//    // EFFECTS: calls different methods based on user's input
//    private static void handleUserInput() throws IOException {
//        int num = obtainIntInput();
//        switch (num) {
//            case 1:
//                printRecipeInstruction();
//                handleRecipeInput();
//                break;
//            case 2:
//                printFridgeInstruction();
//                handleFridgeInput();
//                break;
//            case 3: recipeCollection.save("recipecollection");
//                fridge.save("fridge");
//                b = false;
//                break;
//            default: System.out.println("Invalid option. Please enter again.");
//        }
//    }

    public void handleRecipeInput() throws IOException {
        int num = obtainIntInput();
        switch (num) {
            case 1: addOptions();
                break;
            case 2: removeOptions();
                break;
            case 3: recipeCollection.showList();
                recipeCollection.showDetails();
                break;
            case 4: recipeCollection.save("recipecollection");
                fridge.save("fridge");
                b = false;
                break;
            default: System.out.println("Invalid option. Please enter again.");
        }
    }

//    public void handleFridgeInput() throws IOException {
//        int num = obtainIntInput();
//        switch (num) {
//            case 1: fridge.showFridge();
//                break;
//            case 2: addFoodInFridge();
//                break;
//            case 3: removeFoodFromFridge();
//                break;
//            case 4: recipeCollection.save("recipecollection");
//                fridge.save("fridge");
//                b = false;
//                break;
//            default: System.out.println("Invalid option. Please enter again.");
//        }
//    }

    // MODIFIES: this
    // EFFECTS: checks to see if the recipe has been added, if true, prints a message
    //          that says the recipe is already in the list, otherwise, add the recipe
    //          into the list
    private void addOptions() {
        System.out.println("Please enter your recipe.");
        String recipeName = obtainStringInput();
        if (recipeCollection.ifAlreadyAdded(recipeName)) {
            System.out.println(recipeName + " is already in the list.");
        } else {
            recipeCollection.addToList(recipeKinds(recipeName));
        }
    }

    // MODIFIES: Recipe
    // EFFECTS: constructs different kinds of recipe according to the user's input
    private Recipe recipeKinds(String recipeName) {
        System.out.println("-To Add a Regular Recipe,   Enter '[1]'");
        System.out.println("-To Add a Favourite Recipe, Enter '[2]'");
        Recipe recipe = null;
        int recipeChosen = obtainIntInput();
        switch (recipeChosen) {
            case 1: recipe = new RegularRecipe(recipeName);
                setCategoryandTime(recipe);
                setIngredients(recipe);
                break;
            case 2: recipe = new FavouriteRecipe(recipeName);
                setCategoryandTime(recipe);
                setIngredients(recipe);
                setInstructions(recipe);
                break;
            default: System.out.println("Invalid option. Please enter again.");
                recipeKinds(recipeName);
        }
        return recipe;
    }

    private void setCategoryandTime(Recipe recipe) {
        System.out.println("Please enter category and cooking time for this recipe.");
        String s = obtainStringInput();
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

    private void setIngredients(Recipe recipe) {
        System.out.println("Please enter the ingredients for this recipe.");
        String s = obtainStringInput();
        String[] splits = s.split(",");
        for (String foodItem: splits) {
            FoodItem ingredient = new FoodItem(foodItem);
            recipe.addIngredient(ingredient);
            fridge.addToIngredientList(ingredient);
        }
    }

    private void setInstructions(Recipe favrecipe) {
        System.out.println("Please enter the instructions for this recipe.");
        String s = obtainStringInput();
        String[] splits = s.split("/");
        ArrayList<String>  instructions = new ArrayList<>();
        for (String split: splits) {
            instructions.add(split);
        }
        ((FavouriteRecipe)favrecipe).setInstruction(instructions);
    }

    // MODIFIES: this
    // EFFECTS: removes the selected recipe from the list
    private void removeOptions() {
        System.out.println("Please enter the name of recipe to remove.");
        recipeCollection.showList();
        String recipeChosen = obtainStringInput();
        recipeCollection.removeFromList(recipeChosen);
    }

//    // MODIFIES: fridge
//    // EFFECTS: adds the selected food item into the fridge
//    private void addFoodInFridge() {
//        System.out.println("Please enter the food items.");
//        String s = obtainStringInput();
//        String[] splits = s.split(",");
//        for (String foodItem: splits) {
//            fridge.addToFridge(foodItem);
//        }
//    }
//
//    // MODIFIES: fridge
//    // EFFECTS: removes the selected food item from the fridge
//    private void removeFoodFromFridge() {
//        System.out.println("Please enter the name of food item to remove.");
//        String foodChosen = obtainStringInput();
//        fridge.removeFromFridge(foodChosen);
//    }

    // EFFECTS: gets user's next string input
    private String obtainStringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    // EFFECTS: gets user's next string input
    private static int obtainIntInput() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Your input is invalid. Please enter again.");
            obtainIntInput();
            return 0;
        }
    }
}