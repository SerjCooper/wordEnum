import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.*;


public class EnumWords{

    private String filePath;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    private static void readJson(String filepath) {
        JsonParser parser = new JsonParser();
        try {
            JsonArray jArray = (JsonArray) parser.parse(new FileReader(filepath));

            for (Object o : jArray){
                    JsonObject rootObject = (JsonObject) o;

                    String message = rootObject.get("message").getAsString(); // get property "message"
                    JsonObject childObject = rootObject.getAsJsonObject("place"); // get place object
                    String place = childObject.get("name").getAsString(); // get property "name"
                    System.out.println(message + " " + place); // print "Hi World!"*/
                }
            }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }


}
