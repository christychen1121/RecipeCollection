package test;

import model.RegularRecipe;
import org.junit.Test;

public class TestRegularRecipe {
    RegularRecipe r1;
    RegularRecipe r2;


    @Test
    public void testRecipe(){
        r1 = new RegularRecipe("fish taco");
        r2 = new RegularRecipe("pork taco","main dish",30);
        r1.showDetails();
    }
}
