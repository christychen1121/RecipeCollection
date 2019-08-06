package ui;

import model.Fridge;
import model.ListOfRecipe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static RecipeManager recipeManager = new RecipeManager();
    private static FridageManager fridageManager = new FridageManager();
    protected static Fridge fridge = new Fridge();
    protected static ListOfRecipe recipeCollection = new ListOfRecipe();
    protected static Boolean b = true;

    public void runable() throws IOException, ClassNotFoundException {
        recipeCollection.load("recipecollection");
        fridge.load("fridge");
        while (b) {
            printInstruction();
            handleUserInput();
        }
    }

    // EFFECTS: prints out all the instructions shown on the RecipeCollection page
    private static void printInstruction() {
        System.out.println("\nHello! What would you like to do?\n");
        System.out.println("-Go to RecipeCollection,    Enter '[1]'");
        System.out.println("-Go to Fridge,              Enter '[2]'");
        System.out.println("-To quit,                   Enter '[3]'");
    }

    // EFFECTS: calls different methods based on user's input
    private static void handleUserInput() throws IOException {
        int num = obtainIntInput();
        switch (num) {
            case 1:
                recipeManager.printRecipeInstruction();
                recipeManager.handleRecipeInput();
                break;
            case 2:
                fridageManager.printFridgeInstruction();
                fridageManager.handleFridgeInput();
                break;
            case 3: recipeCollection.save("recipecollection");
                fridge.save("fridge");
                b = false;
                break;
            default: System.out.println("Invalid option. Please enter again.");
        }
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
