package test;

import model.RegularRecipe;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestRegularRecipe {
    RegularRecipe regularRecipe;

    @Before
    public void setup(){
        regularRecipe = new RegularRecipe("r1");
    }
    @Test
    public void testRecipeName(){
        assertEquals (regularRecipe.getName(), "r1");
        regularRecipe.setName("r2");
        assertEquals(regularRecipe.getName(),"r2");
    }
}
