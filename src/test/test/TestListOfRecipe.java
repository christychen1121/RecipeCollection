package test;

import model.ListOfRecipe;
import model.Recipe;
import model.RegularRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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
    public void testSetRecipes() {
        assertTrue(recipeCollection.getRecipes().isEmpty());
        Map<String,Recipe> recipeMap = new HashMap<>();
        recipeMap.put("r1",r1);
        recipeMap.put("r2",r2);
        recipeCollection.setRecipes(recipeMap);
        assertTrue(recipeCollection.getRecipes().containsValue(r1));
        assertTrue(recipeCollection.getRecipes().containsValue(r2));
        assertTrue(recipeCollection.getRecipes().size() == 2);
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
        recipeCollection.removeFromList(r1.getName());
        assertTrue(recipeCollection.getRecipes().size() == 1);
    }


}
