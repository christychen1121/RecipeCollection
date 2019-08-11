package test;

import model.FoodItem;
import model.Recipe;
import model.RegularRecipe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

        foodItem.addContainedIn(recipe2.getName());
        assertTrue(foodItem.getContainedIn().contains(recipe2.getName()));
        assertTrue(foodItem.getContainedIn().size() == 2);
    }


    @Test
    public  void testSetContainedIn() {
        foodItem = new FoodItem("potato");
        assertTrue(foodItem.getContainedIn().isEmpty());
        ArrayList<String> containedIn = new ArrayList<>();
        containedIn.add("curry chicken");
        containedIn.add("french fries");
        foodItem.setContainedIn(containedIn);
        assertTrue(foodItem.getContainedIn().size() == 2);
        assertTrue(foodItem.getContainedIn().contains("curry chicken"));
        assertTrue(foodItem.getContainedIn().contains("french fries"));
    }

    @Test
    public void testEqualsAndHashCode() {
        foodItem = new FoodItem("tomato");
        FoodItem foodItem1 = new FoodItem("tomato");
        assertTrue(foodItem1.equals(foodItem1));
        assertTrue(foodItem.equals(foodItem1));
        assertTrue(foodItem.hashCode() == foodItem1.hashCode());
        FoodItem foodItem2 = null;
        Recipe recipe = new RegularRecipe("spaghetti");
        assertFalse(foodItem.equals(recipe));
        assertFalse(foodItem.equals(foodItem2));
    }
}
