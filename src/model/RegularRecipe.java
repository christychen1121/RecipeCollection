package model;

public class RegularRecipe extends Recipe {

    // MODIFIES: this
    // EFFECTS: constructs a new RegularRecipe object setting its name to name
    public RegularRecipe(String name) {
        super(name);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new RegularRecipe object setting its name to name
    public RegularRecipe(String name, String category, int cookingTime) {
        super(name,category,cookingTime);
    }

    // EFFECTS: prints out the details about this recipe
    @Override
    public void showDetails() {
        System.out.println(this.getName() + " :(" + this.getCategory() + " " + this.getCookingTime()+ " minutes)");
        System.out.println("Ingredients: " + this.getIngredients());
    }
}