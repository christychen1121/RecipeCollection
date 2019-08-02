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
    private ArrayList<String> getInstruction() {
        return this.instruction;
    }


//    // EFFECTS: purchase all the ingredients for this recipe
//    public void purchaseIngredients(ArrayList<String> ingredients) {
//        System.out.println("Purchase the following ingredients: ");
//        for (String ingredient: ingredients) {
//            if (!inFridgeOrNot(ingredient)) {
//                System.out.println(ingredient);
//            }
//        }
//    }
//
//    // EFFECTS: check to see if the fridge contains the given ingredient
//    private boolean inFridgeOrNot(String ingredient) {
//        return (fridge.getFridge().contains(ingredient));
//    }

}
