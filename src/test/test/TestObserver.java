package test;

import model.FoodItem;
import model.Fridge;
import observer.FridgeObserver;
import observer.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestObserver {
    Subject subject;
    FridgeObserver f1;
    FridgeObserver f2;
    FridgeObserver f3;

    @BeforeEach
    public void setup() {
        subject = new Fridge();
        f1 = new FoodItem("kale");
        f2 = new FoodItem("bean sprouts");
        f3 = new FoodItem("banana");
    }

    @Test
    public void testAddObservers() {
        assertTrue(subject.getObservers().isEmpty());
        subject.addObserver(f1);
        assertTrue(subject.getObservers().contains(f1));
        subject.addObserver(f2);
        subject.addObserver(f3);
        assertTrue(subject.getObservers().size() == 3);
        assertTrue(subject.getObservers().contains(f3));
    }

    @Test
    public void testNotifyObservers() {
        FoodItem f4 = new FoodItem("kale");
        subject.notifyObservers(f4);
    }
}
