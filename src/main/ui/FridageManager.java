package ui;

import model.FoodItem;
import model.Fridge;
import model.Loadable;
import model.Saveable;

import java.io.*;

public class FridageManager extends Application implements Loadable, Saveable {

    public String showDetails(FoodItem foodItem) {
        String list = "";
        for (String recipe: foodItem.getContainedIn()) {
            list = list + "\n" + recipe;
        }
        String output = "Recipes available for " + foodItem.getName() + ":" + list;
        return output;
    }

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

}
