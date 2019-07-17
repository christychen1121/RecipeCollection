package test;

import model.ListOfRecipe;
import model.Recipe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestListOfRecipe {
    ListOfRecipe recipeCollection;

    @Before
    public void setup() {
        recipeCollection = new ListOfRecipe();
    }

    @Test
    public void testAddRecipe(){
        assertTrue(recipeCollection.getRecipe().size() ==0);
        Recipe r1 = new Recipe("r1");
        Recipe r2 = new Recipe("r2");
        recipeCollection.addRecipe(r1);
        assertTrue (recipeCollection.getRecipe().contains(r1));
        assertTrue(recipeCollection.getRecipeNames().contains(r1.getName()));
        assertFalse(recipeCollection.getRecipe().contains(r2));
        assertFalse(recipeCollection.getRecipeNames().contains(r2.getName()));
        recipeCollection.addRecipe(r2);
        assertTrue(recipeCollection.getRecipe().contains(r2));
        assertTrue(recipeCollection.getRecipeNames().contains(r2.getName()));
    }

    @Test
    public void testIfAlreadyAdded(){
        Recipe r1 = new Recipe("r1");
        assertFalse(recipeCollection.ifAlreadyAdded("r1"));
        recipeCollection.addRecipe(r1);
        assertTrue(recipeCollection.ifAlreadyAdded("r1"));
    }

    @Test
    public void testRemoveSelection(){
        Recipe r1 = new Recipe("r1");
        Recipe r2 = new Recipe("r2");
        recipeCollection.addRecipe(r1);
        recipeCollection.addRecipe(r2);
        assertTrue (recipeCollection.getRecipe().contains(r1));
        recipeCollection.removeSelection(r1.getName());
        assertFalse (recipeCollection.getRecipe().contains(r1));
        assertTrue (recipeCollection.getRecipe().contains(r2));
    }

    @Test
    public void testShowRecipes(){
        Recipe r1 = new Recipe("r1");
        Recipe r2 = new Recipe("r2"); }

}
