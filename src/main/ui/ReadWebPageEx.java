package ui;

import java.io.*;
import java.net.URL;


public class ReadWebPageEx {

    BufferedReader br = null;

    public void search(String ingredient) throws IOException {
        try {
            URL url = new URL(getURL(ingredient));
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            save(sb);

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    private String getURL(String ingredient) {
        String api = "https://www.themealdb.com/api/json/v1/1/filter.php";
        String query = "?i=" + ingredient;
        return (api + query);
    }

    private void save(StringBuilder stringBuilder) throws FileNotFoundException {
        try {
            PrintWriter writer = new PrintWriter("JSon");
            writer.println(stringBuilder);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
