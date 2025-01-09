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
import java.util.ArrayList;
import java.util.Map;

public class JsonUtils {


    /** <return JsonObject to read jsonObject file>
     * @param filePath       file path to read json
     * @return JsonObject => HashMap <key,value>
                             key of type string , value of type object
     */
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

    /**
     * <return object to read jsonArray file>
     * @param filePath       file path to read json
     * @return Object
     */
    public static Object parseJson(String filePath) {
        Object parse;
        try {
            JSONParser parser = new JSONParser();
            Reader fileReader;
            fileReader = Files.newBufferedReader(Paths.get(filePath));
            parse = parser.parse(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return parse;
    }

    /**
     * <read a specific obj value from the json file>
     * @param filePath       file path to read json
     * @param key            parsing the key as string to read the value
     * @return Object
     */
    public static Object readValueFromJsonObj(String filePath, String key) {
        JsonObject parser = deserializeJson(filePath);
        Object value = parser.get(key);
        return value;
    }

    /**
     * <read a specific array of string values from the json file>
     * @param filePath       file path to read json
     * @param key            parsing the key as string to read the array values
     * @return ArrayList<String>
     */
    public static ArrayList<String> readArrayOfStringFromJsonObj(String filePath, String key) {
        JsonObject parser = deserializeJson(filePath);
        ArrayList<String> values = (ArrayList<String>) parser.get(key);
        return values;
    }

    /**
     * <read a specific inner obj inside the jsonObj from the json file>
     * @param filePath        file path to read json
     * @param key1            parsing the key as string to read the inner the obj
     * @return Map<String,String>
     */
    public static Map<String, String> readObjFromJsonObj(String filePath, String key1) {
        JsonObject parser = deserializeJson(filePath);
        Map<String, String> values = (Map<String, String>) parser.get(key1);
        return (values);
    }


    /**  <read array of obj inside array of obj>
     * read a specific inner array of obj inside the jsonObj from the json file
     * @param filePath        file path to read json
     * @param arrayKey1            parsing the key as string to read the array of obj
     * @return JsonArray => ArrayList<Object>
     */
    public static JsonArray readArrayOfObjFromJsonObj(String filePath, String arrayKey1) {
        JsonObject parser = deserializeJson(filePath);
        JsonArray arrayOfObj = (JsonArray) parser.get(arrayKey1);
        return arrayOfObj;
    }
}
