package model;

import java.util.ArrayList;

public class FavouriteRecipe extends Recipe {

    private ArrayList<String> instruction = new ArrayList<>();

    // MODIFIES: this
    // EFFECTS: constructs a new FavouriteRecipe object setting its name to name
    public FavouriteRecipe(String name) {
        super(name);
    }

    public FavouriteRecipe(String name, String category, int time) {
        super(name,category,time);
    }

    // EFFECTS: prints out the details about this recipe and its instructions
    @Override
    public String showDetails() {
        String instructions = "Instructions: ";
        for (String instruction: this.instruction) {
            instructions = instructions + "\n" + instruction;
        }
        String string = super.showDetails() + "\n" + instructions;
        return string;
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
