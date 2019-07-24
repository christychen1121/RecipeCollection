package model;

import model.Exceptions.InvalidCategoryException;
import model.Exceptions.InvalidTimeException;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class  Recipe implements Serializable {

    protected String name;
    protected String Category; // based on meal time
    protected int CookingTime; // in minutes
    private ArrayList<String > ingredients;
    private ArrayList<String> instruction;

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
    // EFFECTS: change the Category of Recipe to the category given if it equals to "breakfast"
    //          or "main dish" or "snack", otw throw an InvalidCategoryException
    public void setCategory(String category) throws InvalidCategoryException {
        if ((category.equals("breakfast")||(category.equals("main dish")))||(category.equals("snack"))) {
        this.Category = category;
        } else {
            throw new InvalidCategoryException();
        }
    }

    // EFFECTS: return CookingTime of RegularRecipe object
    public int getCookingTime() {
        return this.CookingTime;
    }

    // MODIFIES: this
    // EFFECTS: change the CookingTime of RegularRecipe to the time given
    public void setCookingTime(int time) throws InvalidTimeException {
        if ((time < 60) && (time > 0)) {
            this.CookingTime = time;
        } else {
            throw new InvalidTimeException();
        }
    }

    // EFFECTS: return ingredients of RegularRecipe object
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    // MODIFIES: this
    // EFFECTS: change the ingredients of RegularRecipe to the list given
    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public abstract void showDetails();

    // MODIFIES: this
    // EFFECTS: change the instruction of FavouriteRecipe to the list given
    public void setInstruction(ArrayList<String> instruction) {
        this.instruction = instruction;
    }

    // EFFECTS: return ingredients of RegularRecipe object
    public ArrayList<String> getInstruction() {
        return this.instruction;
    }

    public abstract void purchaseIngredients(ArrayList<String> ingredients);
}
