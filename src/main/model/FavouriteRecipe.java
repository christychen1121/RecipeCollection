package model;

import java.util.ArrayList;

public class FavouriteRecipe extends Recipe {

    private ArrayList<String> instruction;

    // MODIFIES: this
    // EFFECTS: constructs a new FavouriteRecipe object setting its name to name
    public FavouriteRecipe(String name) {
        super(name);
    }

    // EFFECTS: prints out the details about this recipe and its instructions
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Instructions:" + this.getInstruction());
    }

    // MODIFIES: this
    // EFFECTS: change the instruction of FavouriteRecipe to the list given
    public void setInstruction(ArrayList<String> instruction) {
        this.instruction = instruction;
    }

    // EFFECTS: return ingredients of FavouriteRecipe object
    public ArrayList<String> getInstruction() {
        return this.instruction;
    }

}
