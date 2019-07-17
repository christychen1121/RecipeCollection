package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable{

     private String name;
     private String Category; // based on meal time
     private int CookingTime; // in minutes
     private ArrayList<String > ingredients; //show all ingredients

    // MODIFIES: this
    // EFFECTS: constructs a new Recipe object setting its name to name
    public Recipe(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: constructs a new Recipe object setting its name to name
    public Recipe(String name, String category, int cookingTime) {
        this.name = name;
        this.Category = category;
        this.CookingTime = cookingTime;
    }

    // EFFECTS: return name of Recipe object
    public String getName() {
        return this.name;
    }

    // MODIFIES: this
    // EFFECTS: change the name of Recipe to the name given
    public void setName(String name){
        this.name = name;
    }

    // EFFECTS: return Category of Recipe object
    public String getCategory() {
        return this.Category;
    }

    // MODIFIES: this
    // EFFECTS: change the Category of Recipe to the category given
    public void setCategory(String category){
        this.Category = category;
    }

    // EFFECTS: return CookingTime of Recipe object
    public int getCookingTime() {
        return this.CookingTime;
    }

    // MODIFIES: this
    // EFFECTS: change the CookingTime of Recipe to the time given
    public void setCookingTime(int time){
        this.CookingTime = time;
    }

    // EFFECTS: return ingredients of Recipe object
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    // MODIFIES: this
    // EFFECTS: change the ingredients of Recipe to the list given
    public void setIngredients(ArrayList<String> ingredients){
        this.ingredients = ingredients;
    }

}