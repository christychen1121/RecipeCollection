package test;

import model.FoodItem;
import model.Fridge;
import model.RegularRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestFridge {
    Fridge fridge;
    FoodItem f1;
    FoodItem f2;
    FoodItem f3;

    @BeforeEach
    public void setup() {
        fridge = new Fridge();
        f1 = new FoodItem("carrot");
        f2 = new FoodItem("strawberries");
        f3 = new FoodItem("beef");
        f1.addContainedIn(new RegularRecipe("curry chicken"));
        f2.addContainedIn(new RegularRecipe("strawberry cheesecake"));
        f3.addContainedIn(new RegularRecipe("beef udon"));
    }

    @Test
    public void testAddToIngredientList() {
        assertTrue(fridge.getIngredients().isEmpty());

        // when ingredients list doesn't contain the food item
        fridge.addToIngredientList(f1);
        assertTrue(fridge.getIngredients().contains(f1));
        fridge.addToIngredientList(f2);
        assertTrue(fridge.getIngredients().size() == 2);
        assertTrue(fridge.getIngredients().contains(f2));
        assertFalse(fridge.getIngredients().contains(f3));
        fridge.addToIngredientList(f3);
        assertTrue(fridge.getIngredients().contains(f3));
        assertTrue(fridge.getIngredients().size() == 3);

        // when ingredients list contains the food item, it should move the recipe
        // in ContainedIn of the food item to the ContainedIn of the food item in fridge
        assertTrue(fridge.getIngredients().get(0).getContainedIn().size() == 1);
        assertTrue(fridge.getIngredients().get(0).getContainedIn().contains("curry chicken"));
        FoodItem f4 = new FoodItem("carrot");
        f4.addContainedIn(new RegularRecipe("carrot cake"));
        fridge.addToIngredientList(f4);
        assertTrue(fridge.getIngredients().size() == 3);
        assertTrue(fridge.getIngredients().contains(f4));
        assertTrue(fridge.getIngredients().get(0).getContainedIn().size() == 2);
        assertTrue(fridge.getIngredients().get(0).getContainedIn().contains("carrot cake"));
    }

    @Test
    public void testAddToFridge() {
        assertTrue(fridge.getFridge().isEmpty());

        // when fridge and ingredients list don't contain the food item
        fridge.addToFridge("potato");
        fridge.addToFridge("tomato");
        assertEquals("potato",fridge.getFridge().get(0).getName());
        assertEquals("tomato",fridge.getFridge().get(1).getName());
        assertTrue(fridge.getFridge().size() == 2);

        // when fridge contains the food item, the method does nothing
        fridge.addToFridge("potato");
        fridge.addToFridge("potato");
        assertTrue(fridge.getFridge().size() == 2);
    }

    @Test
    public void testAddToFridge2() {
        assertTrue(fridge.getFridge().isEmpty());
        fridge.addToIngredientList(f1);

        // when fridge does't contain the food item,
        // yet ingredients list contains it
        fridge.addToFridge("carrot");
        assertTrue(fridge.getFridge().contains(f1));
        assertTrue(fridge.getFridge().size() == 1);
    }

    @Test
    public void testRemoveFromFrdige() {
        assertTrue(fridge.getFridge().isEmpty());
        fridge.addToFridge("carrot");
        fridge.addToFridge("tomato");
        fridge.removeFromFridge("carrot");
        assertFalse(fridge.getFridge().contains(new FoodItem("carrot")));
        assertTrue(fridge.getFridge().size() == 1);
        fridge.removeFromFridge("tomato");
        assertTrue(fridge.getFridge().isEmpty());
    }


    @Test
    public void testSave() throws IOException {
        fridge.addToIngredientList(f1);
        fridge.addToIngredientList(f2);
        fridge.addToFridge("carrot");
        fridge.save("testSaveLoad");
//        FileInputStream fis = new FileInputStream("testSaveLoad");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Fridge result = (Fridge) ois.readObject();
//        ois.close();
    }

    @Test
    public void testLoad() throws IOException, ClassNotFoundException {
        assertTrue(fridge.getFridge().size() == 0);
        fridge.load("testSaveLoad");
        assertTrue(fridge.getFridge().size() == 1);
        assertTrue(fridge.getIngredients().size() == 2);
        assertTrue(fridge.getIngredients().contains(f1));
        assertTrue(fridge.getIngredients().contains(f2));
        assertTrue(fridge.getFridge().contains(new FoodItem("carrot")));
    }
}
