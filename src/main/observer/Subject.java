package observer;

import model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<FridgeObserver> observers = new ArrayList<>();

    public void addObserver(FridgeObserver foodItem) {
        if (!observers.contains(foodItem)) {
            observers.add(foodItem);
        }
    }

    public void notifyObservers(FoodItem foodItem) {
        for (FridgeObserver observer: observers) {
            observer.update(foodItem);
        }
    }
}
