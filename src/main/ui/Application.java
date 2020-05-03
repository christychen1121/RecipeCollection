package ui;

import model.Fridge;
import model.ListOfRecipe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    protected static RecipeManager recipeManager = new RecipeManager();
    protected static FridageManager fridageManager = new FridageManager();
    protected static Fridge fridge = new Fridge();
    protected static ListOfRecipe recipeCollection = new ListOfRecipe();

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
