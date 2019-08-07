package ui;

import exception.InvalidInputException;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class RecipeManager extends Application implements Loadable,Saveable {

    public void printRecipeInstruction() {
        System.out.println("-To Add a New Recipe,         Enter '[1]'");
        System.out.println("-To Remove a Recipe,          Enter '[2]'");
        System.out.println("-To Show All Recipes,         Enter '[3]'");
        System.out.println("-To quit,                     Enter '[4]'");
    }

    public void handleRecipeInput() throws IOException {
        int num = obtainIntInput();
        switch (num) {
            case 1: addOptions();
                break;
            case 2: removeOptions();
                break;
            case 3: showList();
                showDetails();
                break;
            case 4: save("recipecollection");
                fridageManager.save("fridge");
                b = false;
                break;
            default: System.out.println("Invalid option. Please enter again.");
        }
    }

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
        showList();
        String recipeChosen = obtainStringInput();
        recipeCollection.removeFromList(recipeChosen);
    }

    // EFFECTS: prints out the name of each recipe in the list
    private void showList() {
        System.out.println(recipeCollection.getRecipes().keySet());
    }

    // EFFECTS: print out details of the recipe chosen
    private void showDetails() {
        System.out.println("To see details, please print out name of the recipe.");
        Scanner input = new Scanner(System.in);
        String recipeChosen = input.nextLine();
        //recipeCollection.getRecipe(recipeChosen).showDetails();
        Recipe recipe = (Recipe) recipeCollection.getRecipes().get(recipeChosen);
        recipe.showDetails();
        //recipeCollection.getRecipes().get(recipeChosen).showDetails();
    }
    
    // MODIFIES: this
    // EFFECTS: sets the recipes in recipeCollection to the list of recipe read from the file
    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap<String,Recipe> result = (HashMap<String,Recipe>) ois.readObject();
        ois.close();
        recipeCollection.setRecipes(result);
    }

    // MODIFIES: this
    // EFFECTS: save the current list of recipes into the file
    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(recipeCollection.getRecipes());
        oos.close();
    }

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