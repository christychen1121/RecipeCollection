package ui;

import model.FoodItem;
import model.Fridge;
import model.Loadable;
import model.Saveable;

import java.io.*;

public class FridageManager extends Application implements Loadable, Saveable {

//    public void printFridgeInstruction() {
//        System.out.println("-To Show Food in Fridge,      Enter '[1]'");
//        System.out.println("-To Add Food in Fridge,       Enter '[2]'");
//        System.out.println("-To remove Food from Fridge,  Enter '[3]'");
//        System.out.println("-To get recipe ideas,         Enter '[4]'");
//        System.out.println("-To quit,                     Enter '[5]'");
//    }
//
//    public void handleFridgeInput() throws IOException {
//        int num = obtainIntInput();
//        switch (num) {
//            case 1: showFridge();
//                break;
//            case 2: addFoodInFridge();
//                break;
//            case 3: removeFoodFromFridge();
//                break;
//            case 4:
//                searchIngredient();
//                break;
//            case 5: recipeManager.save("recipecollection");
//                save("fridge");
//                b = false;
//                break;
//            default: System.out.println("Invalid option. Please enter again.");
//        }
//    }

//    private void showFridge() {
//        for (FoodItem foodItem: fridge.getFridge()) {
//            System.out.println(foodItem.getName());
//        }
//        showDetails();
//    }

    public String showDetails(FoodItem foodItem) {
        String list = "";
        for (String recipe: foodItem.getContainedIn()) {
            list = list + "\n" + recipe;
        }
        String output = "Recipes available for " + foodItem.getName() + ":" + list;
        return output;
    }

    // MODIFIES: fridge
    // EFFECTS: adds the selected food item into the fridge
    protected void addFoodInFridge(String s) {
        String[] splits = s.split(",");
        for (String foodItem: splits) {
            fridge.addToFridge(foodItem);
        }
    }

    protected String searchIngredient(String s) throws IOException {
        ReadWebPageEx readWebPageEx = new ReadWebPageEx();
        readWebPageEx.search(s);
        Parser parser = new Parser();
        return parser.read();
    }

    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Fridge result = (Fridge) ois.readObject();
        ois.close();
        fridge.setFridge(result.getFridge());
        fridge.setIngredients(result.getIngredients());
    }

    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(fridge);
        oos.close();
    }

//    // EFFECTS: gets user's next string input
//    private String obtainStringInput() {
//        Scanner input = new Scanner(System.in);
//        return input.nextLine();
//    }
//
//    // EFFECTS: gets user's next string input
//    private static int obtainIntInput() {
//        try {
//            Scanner input = new Scanner(System.in);
//            return input.nextInt();
//        } catch (InputMismatchException e) {
//            System.out.println("Your input is invalid. Please enter again.");
//            obtainIntInput();
//            return 0;
//        }
//    }
}
