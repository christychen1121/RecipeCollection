package test;

import exception.InvalidCategoryException;
import exception.InvalidTimeException;
import model.FoodItem;
import model.Recipe;
import model.RegularRecipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRecipe {

    Recipe recipe;

    @Test
    public void testAddIngredient() {
        recipe = new RegularRecipe("meatball spaghetti","main dish",30);
        assertTrue(recipe.getIngredients().isEmpty());
        FoodItem f1 = new FoodItem("meatball");
        FoodItem f2 = new FoodItem("tomato");
        FoodItem f3 = new FoodItem("rosemary");
        recipe.addIngredient(f1);
        recipe.addIngredient(f2);
        recipe.addIngredient(f3);
        assertTrue(recipe.getIngredients().size() == 3);
        assertTrue(recipe.getIngredients().contains(f1));
        assertTrue(recipe.getIngredients().contains(f2));
        assertTrue(recipe.getIngredients().contains(f3));
        assertTrue(f1.getContainedIn().contains(recipe.getName()));
        assertTrue(f2.getContainedIn().contains(recipe.getName()));
        assertTrue(f3.getContainedIn().contains(recipe.getName()));

        recipe.addIngredient(f1);
        assertTrue(recipe.getIngredients().size() == 3);
    }
    @Test
    public void testEquals() throws InvalidCategoryException, InvalidTimeException {
        recipe = new RegularRecipe(" ");
        recipe.setName("meatball spaghetti");
        recipe.setCategory("main dish");
        recipe.setCookingTime(20);
        Recipe recipe1 = new RegularRecipe("meatball spaghetti");
        assertTrue(recipe.equals(recipe1));
        Recipe recipe2 = null;
        assertFalse(recipe.equals(recipe2));
        assertTrue(recipe.hashCode() == recipe1.hashCode());
    }

}
