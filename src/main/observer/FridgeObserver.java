package observer;

import model.FoodItem;

public interface FridgeObserver {
    void update(FoodItem foodItem);
}
