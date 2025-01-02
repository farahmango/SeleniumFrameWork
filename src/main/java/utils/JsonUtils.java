package utils;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonUtils {

    public static JsonObject deserializeJson(String filePath) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            // create parser
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
            return parser;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JsonException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object parseJson(String filePath) {
        JSONParser parser = new JSONParser();
        FileReader fileReader;
        File file = new File(filePath);
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object parse;
        try {
            parse = parser.parse(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }
    public static Object readObjFromJson(String filePath, String key) {
        JsonObject parser = deserializeJson(filePath);
        Object value = parser.get(key);
        return value;
    }

    public static JsonArray readArrayFromJson(String filePath, String key) {
        JsonObject parser = deserializeJson(filePath);
        JsonArray values = (JsonArray) parser.get(key);
        return values;
    }

    public static Map<String, Object> readMapOfObjJson(String filePath, String key1) {
        JsonObject parser = deserializeJson(filePath);
        Map<String, Object> values = (Map<String, Object>) parser.get(key1);
        return (values);
    }

    public static void readArrayOfObj(String filePath, String key1) {
        JsonArray arrayOfObj = JsonUtils.readArrayFromJson(filePath, key1);
        arrayOfObj.forEach(entry -> {
            Map<String, String> obj = (Map<String, String>) entry;
            obj.forEach((key, value) -> System.out.println(key + ": " + value));
        });
    }
}