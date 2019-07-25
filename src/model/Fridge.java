package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Fridge {

    private ArrayList<String> foodItems;

    public Fridge() {
        this.foodItems = new ArrayList<>();
    }

    public ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<String> foodItems) {
        this.foodItems = foodItems;
    }

    public void addToList(String foodItem) {
        if(!foodItems.contains(foodItem)) {
            foodItems.add(foodItem);
        }
    }

    protected void removeFromList(String foodItem) {
        if(foodItem.contains(foodItem)) {
            foodItems.remove(foodItem);
        }
    }

    public void save() throws IOException, ClassNotFoundException {
        PrintWriter writer = new PrintWriter("Fridge.txt","UTF-8");
        for(String foodItem: foodItems) {
            writer.println(foodItem);
            writer.close();
        }
    }


    public void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("Fridge.txt"));

    }
}
