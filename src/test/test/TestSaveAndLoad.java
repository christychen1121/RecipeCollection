package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestSaveAndLoad {
    private ListOfRecipe testrecipeCollection;
    private Recipe r1 = new RegularRecipe("chia pudding","snacks",5);
    private Recipe r2 = new RegularRecipe("curry chicken","lunch",30);
    private Recipe r3 = new RegularRecipe("avocado toast","breakfast",10);

    @Before
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
        List<RegularRecipe> result = (List<RegularRecipe>) ois.readObject();
        ois.close();
        assertEquals(result.size(),3);
        assertEquals(result.get(0).getName(),"chia pudding");
        assertEquals(result.get(0).getCategory(),"snacks");
        assertEquals(result.get(0).getCookingTime(),5);
        assertTrue(result.get(0).getIngredients().contains("chia seeds"));
        assertEquals(result.get(2).getName(),"avocado toast");
    }

    @Test
    public void testLoad() throws IOException, ClassNotFoundException {
        Loadable ld = new ListOfRecipe();
        ld.load("testing");
        testrecipeCollection.load("testing");
//        assertTrue(testrecipeCollection.getRecipes().size() == 3);
//        assertTrue(testrecipeCollection.getRecipes().get(1).getCookingTime() == 30);
    }
}
