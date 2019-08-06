package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestSaveAndLoad {
    private ListOfRecipe testrecipeCollection;
    private Recipe r1 = new RegularRecipe("chia pudding","snacks",5);
    private Recipe r2 = new RegularRecipe("curry chicken","lunch",30);
    private Recipe r3 = new RegularRecipe("avocado toast","breakfast",10);

    @BeforeEach
    public void setup() {
        testrecipeCollection = new ListOfRecipe();
        r1.addIngredient(new FoodItem("chia seeds"));
        r1.addIngredient(new FoodItem("almond milk"));
        r1.addIngredient(new FoodItem("vanilla extract"));
    }

    @Test
    public void testSave() throws IOException, ClassNotFoundException {
        testrecipeCollection.addToList(r1);
        testrecipeCollection.addToList(r2);
        testrecipeCollection.addToList(r3);
        testrecipeCollection.save("testing");
        FileInputStream fis = new FileInputStream("testing");
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap<String,Recipe> result = (HashMap<String, Recipe>) ois.readObject();
        ois.close();
        assertEquals(result.size(),3);
        assertTrue(result.containsKey("chia pudding"));
        assertEquals(result.get("chia pudding").getCategory(),"snacks");
        assertEquals(result.get("chia pudding").getCookingTime(),5);
        assertTrue(result.get("chia pudding").getIngredients().contains(new FoodItem("chia seeds")));
        assertTrue(result.containsKey("avocado toast"));
    }

    @Test
    public void testLoad() throws IOException, ClassNotFoundException {
        testrecipeCollection.load("testing");
        assertTrue(testrecipeCollection.getRecipes().containsKey("curry chicken"));
        assertTrue(testrecipeCollection.getRecipes().size() == 3);
    }
}
