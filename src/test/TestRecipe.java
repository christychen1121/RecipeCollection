package test;

import model.Recipe;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestRecipe {
    Recipe recipe;

    @Before
    public void setup(){
        recipe = new Recipe("r1");
    }
    @Test
    public void testRecipeName(){
        assertEquals (recipe.getName(), "r1");
        recipe.setName("r2");
        assertEquals(recipe.getName(),"r2");
    }
}
