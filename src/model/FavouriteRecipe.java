package model;

import java.util.ArrayList;

public class FavouriteRecipe extends Recipe {

    private Fridge fridge;
    private ArrayList<String> instruction;

    // MODIFIES: this
    // EFFECTS: constructs a new RegularRecipe object setting its name to name
    public FavouriteRecipe(String name) {
        super(name);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new RegularRecipe object setting its name to name
    public FavouriteRecipe(String name, String category, int cookingTime) {
        super(name, category, cookingTime);
    }

    // MODIFIES: this
    // EFFECTS: sets the instruction of favRecipe to the instruction given
    public void setInstruction(ArrayList instruction) {
        this.instruction = instruction;
    }

    // EFFECTS: prints out the details about this recipe
    @Override
    public void showDetails() {
        System.out.println(this.getName() + this.getCategory() + this.getCookingTime());
        System.out.println(this.getIngredients());
        System.out.println(instruction);
    }

    // EFFECTS: purchase all the ingredients for this recipe
    public void purchaseIngredients(ArrayList<String> ingredients) {
        System.out.println("Purchased the following ingredients: ");
        for (String ingredient: ingredients) {
            if (inFridgeOrNot(ingredient)) {

            } else System.out.println(ingredient);
        }
    }

    // EFFECTS: check to see if the fridge contains the given ingredient
    private boolean inFridgeOrNot (String ingredient) {
        return (fridge.getFoodItems().contains(ingredient));
    }
}
