package model;

import java.io.*;
import java.util.*;

public class Fridge implements Loadable,Saveable {

    private ArrayList<FoodItem> ingredients = new ArrayList<>();
    private ArrayList<FoodItem> fridge = new ArrayList<>();

    public void addToIngredientList(FoodItem ingredient) {
        if (ingredients.contains(ingredient)) {
            for (FoodItem f: ingredients) {
                if (f.equals(ingredient)) {
                    for (String recipeName: ingredient.getContainedIn()) {
                        f.addContainedIn(recipeName);
                    }
                }
            }
        } else {
            ingredients.add(ingredient);
        }
    }

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

    public void showFridge() {
        for (FoodItem foodItem: fridge) {
            System.out.println(foodItem.getName());
        }
        showDetails();
    }

    private void showDetails() {
        System.out.println("To see details, please print out name of the food.");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        FoodItem foodItem = new FoodItem(s);
        for (FoodItem f: fridge) {
            if (f.equals(foodItem)) {
                System.out.println(f.getContainedIn());
            }
        }
    }

    public void load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<FoodItem> result = (ArrayList<FoodItem>) ois.readObject();
        ois.close();
        this.fridge = result;
    }

    public void save(String name) throws IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(fridge);
        oos.close();
    }
}
