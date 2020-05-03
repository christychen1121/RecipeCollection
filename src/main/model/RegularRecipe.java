package model;

public class RegularRecipe extends Recipe {

    // EFFECTS: constructs a new RegularRecipe object setting its name to name
    public RegularRecipe(String name) {
        super(name);
    }

    // EFFECTS: constructs a new RegularRecipe object setting its values to the given values
    public RegularRecipe(String name, String category, int cookingTime) {
        super(name,category,cookingTime);
    }

    // EFFECTS: prints out the details about this recipe
    @Override
    public String showDetails() {
        return super.showDetails();
    }

}