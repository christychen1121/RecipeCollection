package model;

import java.io.IOException;

public interface Saveable {

    // EFFECTS: save the current list of recipes into the file
    void save(String name) throws IOException;
}
