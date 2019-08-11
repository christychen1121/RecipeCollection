package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Fridge implements Serializable {

    private ArrayList<FoodItem> ingredients = new ArrayList<>();
    private ArrayList<FoodItem> fridge = new ArrayList<>();

    public ArrayList<FoodItem> getIngredients() {
        return ingredients;
    }

    public ArrayList<FoodItem> getFridge() {
        return fridge;
    }

    public void setIngredients(ArrayList<FoodItem> ingredients) {
        this.ingredients = ingredients;
    }

    public void setFridge(ArrayList<FoodItem> fridge) {
        this.fridge = fridge;
    }

    public void addToIngredientList(FoodItem ingredient) {
        if (ingredients.contains(ingredient)) {
            for (FoodItem f: ingredients) {
                if (f.equals(ingredient)) {
                    f.addContainedIn(ingredient.getContainedIn().get(0));
                    notify(f);
                }
            }
        } else {
            ingredients.add(ingredient);
            notify(ingredient);
        }
    }

    public void notify(FoodItem foodItem) {
        for (FoodItem item: fridge) {
            if (item.equals(foodItem)) {
                item.setContainedIn(foodItem.getContainedIn());
                System.out.println(item.getName() + " has been updated!");
            }
        }
    }

    // EFFECTS: does nothing when fridge already contains the item, otherwise,
    //          adds the same food item in ingredients list to fridge if ingredients
    //          list contains it, if not, add new food item to fridge
    public void addToFridge(String s) {
        FoodItem foodItem = new FoodItem(s);
        if (fridge.contains(foodItem)) {
            System.out.println("Fridge already contains " + s);
        } else if (ingredients.contains(foodItem)) {
            for (FoodItem ingredient: ingredients) {
                if (ingredient.equals(foodItem)) {
                    fridge.add(ingredient);
                    System.out.println(s + " has been added to the fridge!");
                }
            }
        } else {
            fridge.add(foodItem);
            System.out.println(s + " has been added to the fridge!");
        }

    }

    public void removeFromFridge(String s) {
        FoodItem foodItem = new FoodItem(s);
        if (fridge.contains(foodItem)) {
            fridge.remove(foodItem);
            System.out.println(s + " has been removed from the fridge!");
        }
    }
}
