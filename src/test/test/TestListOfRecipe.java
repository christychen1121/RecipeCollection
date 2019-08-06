package test;

import exception.InvalidCategoryException;
import exception.InvalidTimeException;
import model.ListOfRecipe;
import model.Recipe;
import model.RegularRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestListOfRecipe {
    ListOfRecipe recipeCollection;
    Recipe r1;
    Recipe r2;

    @BeforeEach
    public void setup() {
        recipeCollection = new ListOfRecipe();
        r1 = new RegularRecipe("r1");
        r2 = new RegularRecipe("r2");
    }

    @Test
    public  void testGetRecipe() throws InvalidCategoryException, InvalidTimeException {
        r1.setCategory("snack");
        r1.setCookingTime(30);
        recipeCollection.addToList(r1);
        Recipe recipe = recipeCollection.getRecipe(r1.getName());
        assertEquals("snack",recipe.getCategory());
        assertEquals(30,recipe.getCookingTime());
    }

    @Test
    public void testAddToList() {
        assertTrue(recipeCollection.getRecipes().size() == 0);
        recipeCollection.addToList(r1);
        assertTrue(recipeCollection.getRecipes().containsValue(r1));
        assertFalse(recipeCollection.getRecipes().containsValue(r2));
        recipeCollection.addToList(r2);
        assertTrue(recipeCollection.getRecipes().containsValue(r2));
    }

    @Test
    public void testIfAlreadyAdded() {
        assertFalse(recipeCollection.ifAlreadyAdded("r1"));
        recipeCollection.addToList(r1);
        assertTrue(recipeCollection.ifAlreadyAdded("r1"));
    }

    @Test
    public void testRemoveSelection() {
        recipeCollection.addToList(r1);
        recipeCollection.addToList(r2);
        assertTrue(recipeCollection.getRecipes().containsValue(r1));
        recipeCollection.removeFromList(r1.getName());
        assertFalse(recipeCollection.getRecipes().containsValue(r1));
        assertTrue(recipeCollection.getRecipes().containsValue(r2));
    }


}
