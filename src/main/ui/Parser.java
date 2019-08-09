package ui;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {
    public String read() throws FileNotFoundException {
        String output = "";
        try {
            JsonParser parse = new JsonParser();
            JsonObject object = (JsonObject) parse.parse(new FileReader("JSon"));

            JsonArray result = object.get("meals").getAsJsonArray();
            String list = "";
            for (int i = 0; i < result.size();i++) {
                JsonObject subObject = result.get(i).getAsJsonObject();
                list = list + "\n" + "---------------------" + "\n"
                        + (i + 1) + ". " + subObject.get("strMeal").getAsString();
            }
            output = "Related Recipes: " + list;

        } catch (JsonIOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
