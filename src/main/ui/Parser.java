package ui;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {
    public void read() throws FileNotFoundException {

        try {
            JsonParser parse = new JsonParser();
            JsonObject object = (JsonObject) parse.parse(new FileReader("JSon"));

            JsonArray result = object.get("meals").getAsJsonArray();
            System.out.println("Related Recipes: ");
            for (int i = 0; i < result.size();i++) {
                System.out.println("---------------------");
                JsonObject subObject = result.get(i).getAsJsonObject();
                System.out.println((i + 1) + ". " + subObject.get("strMeal").getAsString());
            }
        } catch (JsonIOException e) {
            e.printStackTrace();
        }
    }
}
