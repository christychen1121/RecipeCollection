package test;

import model.FavouriteRecipe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFavouriteRecipe {

    FavouriteRecipe recipe;

    @Test
    public void testShowDetails() {
        recipe = new FavouriteRecipe("fish taco");
        recipe.showDetails();
    }

    @Test
    public void testInstruction() {
        recipe = new FavouriteRecipe("pork taco","main dish",30);
        ArrayList<String> instuctions = new ArrayList<>();
        instuctions.add("1.Get Taco Wraps.");
        instuctions.add("2.Add Pork Onto the Wrap.");
        recipe.setInstruction(instuctions);
        instuctions = recipe.getInstruction();
        assertTrue(instuctions.contains("1.Get Taco Wraps."));
        assertTrue(instuctions.contains("2.Add Pork Onto the Wrap."));
    }
}
