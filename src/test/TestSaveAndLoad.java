package test;

import model.ListOfRecipe;
import model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestSaveAndLoad {
    private ListOfRecipe testrecipeCollection;
    private Recipe r1 = new Recipe("chia pudding","snacks",5);
    private Recipe r2 = new Recipe("curry chicken","lunch",30);
    private Recipe r3 = new Recipe("avocado toast","breakfast",10);

    @Before
    public void setup() {
        testrecipeCollection = new ListOfRecipe();
        ArrayList<String> i1 = new ArrayList<>();
        i1.add("chia seeds"); i1.add("almond milk"); i1.add("vanilla extract");
        r1.setIngredients(i1);
    }

    @Test
    public void testSave() throws IOException, ClassNotFoundException {
        testrecipeCollection.addRecipe(r1);
        testrecipeCollection.addRecipe(r2);
        testrecipeCollection.addRecipe(r3);
        testrecipeCollection.save("testing");
        FileInputStream fis = new FileInputStream("testing");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Recipe> result = (List<Recipe>) ois.readObject();
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
        testrecipeCollection.load("testing");
        assertTrue(testrecipeCollection.getRecipe().size() == 3);
        assertTrue(testrecipeCollection.getRecipeNames().contains("curry chicken"));
        assertTrue(testrecipeCollection.getRecipe().get(1).getCookingTime() == 30);
    }
}
