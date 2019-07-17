package ui;

import java.io.IOException;

public interface Loadable {

    // EFFECTS: sets the recipes in recipeCollection to the list of recipe read from the file
    void load(String name) throws IOException, ClassNotFoundException;
}
