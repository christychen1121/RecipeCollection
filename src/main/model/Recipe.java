package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public abstract class  Recipe implements Serializable {

    private String name;
    private String category; // based on meal time
    private int cookingTime; // in minutes
    private ArrayList<FoodItem> ingredients = new ArrayList<>();

    // MODIFIES: this
    // EFFECTS: constructs a new Recipe object setting its name to name
    Recipe(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: construct a new Recipe object and sets the fields to the given values
    Recipe(String name, String category, int cookingTime) {
        this.name = name;
        this.category = category;
        this.cookingTime = cookingTime;
    }

    // EFFECTS: return name of Recipe object
    public String getName() {
        return this.name;
    }

    // EFFECTS: return category of Recipe object
    public String getCategory() {
        return this.category;
    }

    // EFFECTS: return cookingTime of Recipe object
    public int getCookingTime() {
        return this.cookingTime;
    }

    // EFFECTS: return ingredients of Recipe object
    public ArrayList<FoodItem> getIngredients() {
        return this.ingredients;
    }

    // MODIFIES: this
    // EFFECTS: add the given ingredient to the list of ingredient if it is not already there
    public void addIngredient(FoodItem ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            ingredient.addContainedIn(this);
        }
    }

    // EFFECTS: prints out the name, category, cooking time and ingredients of the recipe
    public String showDetails() {
        String list = "Ingredients: ";
        for (FoodItem ingredient: this.ingredients) {
            list = list + ingredient.getName() + ", ";
        }
        String details = this.getName() + " :(" + this.getCategory() + " " + this.getCookingTime() + " minutes)"
                + "\n" + list;
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
