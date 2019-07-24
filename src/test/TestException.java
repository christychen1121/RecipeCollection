package test;

import model.Exceptions.InvalidInputException;
import model.Recipe;
import model.RegularRecipe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class TestException {
    Recipe recipe;

    @Before
    public void setup() {
        recipe = new RegularRecipe("fired rice");
    }

    @Test
    // when no InvalidInputException is thrown
    public void testNoInvalidInputException() {
        try {
            recipe.setCategory("breakfast");
            recipe.setCookingTime(20);

        } catch (InvalidInputException e) {
            fail("I was not expecting an exception");
        }
    }

    @Test
    // when an InvalidCategoryException is thrown but no InvalidTimeException thrown
    public void testInvalidCategoryException() {
        try {
            recipe.setCookingTime(20);
            recipe.setCategory("lunch");
            fail("I wasn't expecting this line of code.");

        } catch (InvalidInputException e) {
            System.out.println("Great! Exception Caught!");
        }
    }

    @Test
    // when an InvalidTimeException is thrown but no InvalidCategoryException thrown
    public void testInvalidTimeException() {
        try {
            recipe.setCategory("main dish");
            recipe.setCookingTime(-1);
            fail("I wasn't  expecting this line of code.");
        }  catch (InvalidInputException e) {
            System.out.println("Great! Exception Caught!");
        }
    }

    @Test
    // when both exceptions are thrown
    public void testInvalidInputException() {
        try {
            recipe.setCategory("lunch");
            recipe.setCookingTime(65);
            fail("I wasn't  expecting this line of code.");
        } catch (InvalidInputException e) {
            System.out.println("Great! Exception Caught!");
        }
    }
}
