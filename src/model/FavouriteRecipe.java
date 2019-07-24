package model;

import java.util.ArrayList;

public class FavouriteRecipe extends Recipe {

    private Fridge fridge;

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

    // EFFECTS: prints out the details about this recipe
    @Override
    public void showDetails() {
        System.out.println(this.getName() + " :(" + this.getCategory() + " " + this.getCookingTime()+ " minutes)");
        System.out.println("Ingredients: " + this.getIngredients());
        System.out.println("Instructions:" + this.getInstruction());
    }

    @Override
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
