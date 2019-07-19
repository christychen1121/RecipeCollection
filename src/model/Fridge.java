package model;

import java.io.IOException;
import java.util.ArrayList;

public class Fridge {

    private ArrayList<String> foodItems;

    public void Fridge() {
        this.foodItems = new ArrayList<>();
    }

    public ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<String> foodItems) {
        this.foodItems = foodItems;
    }

    public void addToList(RegularRecipe recipe) {

    }

    protected void removeFromList(RegularRecipe regularRecipe) {

    }


    public void removeSelection(String recipeChosen) {

    }


    public void load(String name) throws IOException, ClassNotFoundException {

    }


    public void save(String name) throws IOException {

    }
}
