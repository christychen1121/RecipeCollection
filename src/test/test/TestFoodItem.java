package test;

import model.FoodItem;
import model.Recipe;
import model.RegularRecipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFoodItem {

    FoodItem foodItem;

    @Test
    public void testAddContainedIn() {
        foodItem = new FoodItem("chicken");
        Recipe recipe1 = new RegularRecipe("butter chicken", "main dish", 30);
        Recipe recipe2 = new RegularRecipe("curry chicken", "main dish", 40);
        assertTrue(foodItem.getContainedIn().isEmpty());
        foodItem.addContainedIn(recipe1);
        assertTrue(foodItem.getContainedIn().contains(recipe1.getName()));
        assertTrue(recipe1.getIngredients().contains(foodItem));

        // if the recipe is already in ContainedIn, then it will not be added
        foodItem.addContainedIn(recipe1);
        assertTrue(foodItem.getContainedIn().size() == 1);

        foodItem.addContainedIn(recipe2);
        assertTrue(foodItem.getContainedIn().contains(recipe2.getName()));
        assertTrue(recipe2.getIngredients().contains(foodItem));
        assertTrue(foodItem.getContainedIn().size() == 2);
    }
}
