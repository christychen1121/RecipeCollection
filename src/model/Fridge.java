package model;

import java.io.IOException;
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

    public void load(String name) throws IOException, ClassNotFoundException {

    }


    public void save(String name) throws IOException {

    }
}
