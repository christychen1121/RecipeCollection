package model;

import exception.InvalidCategoryException;
import exception.InvalidTimeException;

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

    // MODIFIES: this
    // EFFECTS: change the name of Recipe to the name given
    public void setName(String name) {
        this.name = name;
    }

    // EFFECTS: return category of Recipe object
    public String getCategory() {
        return this.category;
    }

    // MODIFIES: this
    // EFFECTS: change the category of Recipe to the category given if it equals to "breakfast"
    //          or "main dish" or "snack", otw throw an InvalidCategoryException
    public void setCategory(String category) throws InvalidCategoryException {
        if ((category.equals("breakfast") || (category.equals("main dish"))) || (category.equals("snack"))) {
            this.category = category;
        } else {
            throw new InvalidCategoryException();
        }
    }

    // EFFECTS: return cookingTime of Recipe object
    public int getCookingTime() {
        return this.cookingTime;
    }

    // MODIFIES: this
    // EFFECTS: set the cookingTime of Recipe to the given time
    //          if the time given is within the range of 0 and 60 mins
    public void setCookingTime(int time) throws InvalidTimeException {
        if ((time < 60) && (time > 0)) {
            this.cookingTime = time;
        } else {
            throw new InvalidTimeException();
        }
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
    public void showDetails() {
        System.out.println(this.getName() + " :(" + this.getCategory() + " " + this.getCookingTime() + " minutes)");
        System.out.print("Ingredients: ");
        for (FoodItem ingredient: this.ingredients) {
            System.out.print(ingredient.getName() + " ");
            //printIngredients(this.getIngredients());
        }

//    // EFFECTS: prints out each ingredient in the list
//    private void printIngredients(ArrayList<FoodItem> ingredients) {
//        for (FoodItem ingredient: ingredients) {
//            System.out.print(ingredient.getName() + " ");
//        }
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
