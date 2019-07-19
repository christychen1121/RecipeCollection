package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class  Recipe implements Serializable {
    protected String name;
    protected String Category; // based on meal time
    protected int CookingTime; // in minutes
    private ArrayList<String > ingredients; //show all ingredients

    // MODIFIES: this
    // EFFECTS: constructs a new RegularRecipe object setting its name to name
    public Recipe(String name) {
        this.name = name;
    }

    // EFFECTS: construct a new Recipe object and sets the fields to the given values
    public Recipe(String name, String Category, int CookingTime) {
        this.name = name;
        this.Category = Category;
        this.CookingTime = CookingTime;
    }

    // EFFECTS: return name of RegularRecipe object
    public String getName() {
        return this.name;
    }

    // MODIFIES: this
    // EFFECTS: change the name of RegularRecipe to the name given
    public void setName(String name){
        this.name = name;
    }

    // EFFECTS: return Category of RegularRecipe object
    public String getCategory() {
        return this.Category;
    }

    // MODIFIES: this
    // EFFECTS: change the Category of RegularRecipe to the category given
    public void setCategory(String category){
        this.Category = category;
    }

    // EFFECTS: return CookingTime of RegularRecipe object
    public int getCookingTime() {
        return this.CookingTime;
    }

    // MODIFIES: this
    // EFFECTS: change the CookingTime of RegularRecipe to the time given
    public void setCookingTime(int time){
        this.CookingTime = time;
    }

    // EFFECTS: return ingredients of RegularRecipe object
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    // MODIFIES: this
    // EFFECTS: change the ingredients of RegularRecipe to the list given
    public void setIngredients(ArrayList<String> ingredients){
        this.ingredients = ingredients;
    }

    public abstract void showDetails();
}
