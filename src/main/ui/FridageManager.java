package ui;

import model.FoodItem;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FridageManager extends Application {

    public void printFridgeInstruction() {
        System.out.println("-To Show Food in Fridge,      Enter '[1]'");
        System.out.println("-To Add Food in Fridge,       Enter '[2]'");
        System.out.println("-To remove Food from Fridge,  Enter '[3]'");
        System.out.println("-To get recipe ideas,         Enter '[4]'");
        System.out.println("-To quit,                     Enter '[5]'");
    }

    public void handleFridgeInput() throws IOException {
        int num = obtainIntInput();
        switch (num) {
            case 1: showFridge();
                break;
            case 2: addFoodInFridge();
                break;
            case 3: removeFoodFromFridge();
                break;
            case 4:
                searchIngredient();
                break;
            case 5: recipeCollection.save("recipecollection");
                fridge.save("fridge");
                b = false;
                break;
            default: System.out.println("Invalid option. Please enter again.");
        }
    }

    private void showFridge() {
        for (FoodItem foodItem: fridge.getFridge()) {
            System.out.println(foodItem.getName());
        }
        showDetails();
    }

    private void showDetails() {
        System.out.println("To see details, please print out name of the food.");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        FoodItem foodItem = new FoodItem(s);
        for (FoodItem f: fridge.getFridge()) {
            if (f.equals(foodItem)) {
                System.out.println("Recipes available for " + f.getName() + ":");
                System.out.print(f.getContainedIn());
            }
        }
    }

    // MODIFIES: fridge
    // EFFECTS: adds the selected food item into the fridge
    private void addFoodInFridge() {
        System.out.println("Please enter the food items.");
        String s = obtainStringInput();
        String[] splits = s.split(",");
        for (String foodItem: splits) {
            fridge.addToFridge(foodItem);
        }
    }

    // MODIFIES: fridge
    // EFFECTS: removes the selected food item from the fridge
    private void removeFoodFromFridge() {
        System.out.println("Please enter the name of food item to remove.");
        String foodChosen = obtainStringInput();
        fridge.removeFromFridge(foodChosen);
    }

    private void searchIngredient() throws IOException {
        System.out.println("Please enter the name of ingredient for searching");
        String s = obtainStringInput();
        ReadWebPageEx readWebPageEx = new ReadWebPageEx();
        readWebPageEx.search(s);
        Parser parser = new Parser();
        parser.read();
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
