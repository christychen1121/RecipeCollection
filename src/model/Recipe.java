package model;

import java.util.ArrayList;

public class Recipe {

     private String name;
     private String Category; // based on meal time
     private String DifficultyLevel; //Easy, Medium, Difficult
     private int CookingTime; // in minutes
     private ArrayList<String > ingredients; //show all ingredients

    // MODIFIES: this
    // EFFECTS: constructs a new Recipe object setting its name to name
    public Recipe(String name) {
        this.name = name;
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

}