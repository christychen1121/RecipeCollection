package test;

import model.ListOfRecipe;
import model.RegularRecipe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestListOfRegularRecipe {
    ListOfRecipe recipeCollection;

    @Before
    public void setup() {
        recipeCollection = new ListOfRecipe();
    }

    @Test
    public void testAddRecipe(){
        assertTrue(recipeCollection.getRecipe().size() ==0);
        RegularRecipe r1 = new RegularRecipe("r1");
        RegularRecipe r2 = new RegularRecipe("r2");
        recipeCollection.addToList(r1);
        assertTrue (recipeCollection.getRecipe().contains(r1));
        assertFalse(recipeCollection.getRecipe().contains(r2));
        recipeCollection.addToList(r2);
        assertTrue(recipeCollection.getRecipe().contains(r2));
    }

    @Test
    public void testIfAlreadyAdded(){
        RegularRecipe r1 = new RegularRecipe("r1");
        assertFalse(recipeCollection.ifAlreadyAdded("r1"));
        recipeCollection.addToList(r1);
        assertTrue(recipeCollection.ifAlreadyAdded("r1"));
    }

    @Test
    public void testRemoveSelection(){
        RegularRecipe r1 = new RegularRecipe("r1");
        RegularRecipe r2 = new RegularRecipe("r2");
        recipeCollection.addToList(r1);
        recipeCollection.addToList(r2);
        assertTrue (recipeCollection.getRecipe().contains(r1));
        recipeCollection.removeSelection(r1.getName());
        assertFalse (recipeCollection.getRecipe().contains(r1));
        assertTrue (recipeCollection.getRecipe().contains(r2));
    }

    @Test
    public void testShowRecipes(){
        RegularRecipe r1 = new RegularRecipe("r1");
        RegularRecipe r2 = new RegularRecipe("r2"); }

}
