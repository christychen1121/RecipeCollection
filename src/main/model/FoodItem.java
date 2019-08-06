package model;

import observer.FridgeObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class FoodItem implements FridgeObserver,Serializable {

    private String name;
    private ArrayList<String> containedIn;

    public FoodItem(String name) {
        this.name = name;
        containedIn = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getContainedIn() {
        return containedIn;
    }

    public void addContainedIn(String recipeName) {
        this.containedIn.add(recipeName);
    }

    public void addContainedIn(Recipe recipe) {
        if (!containedIn.contains(recipe.getName())) {
            containedIn.add(recipe.getName());
            recipe.addIngredient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoodItem foodItem = (FoodItem) o;
        return Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void update(FoodItem foodItem) {
        if (this.equals(foodItem)) {
            this.containedIn = foodItem.getContainedIn();
            System.out.println(this.name + " has been updated!");
        }
    }
}
