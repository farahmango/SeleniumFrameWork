import com.github.cliftonlabs.json_simple.JsonArray;
import interfaces.FilesPath;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.util.ArrayList;
import java.util.Map;

public class Json {

    @Test
    public void readValueFromJsonObj() {
        Object data = JsonUtils.readValueFromJsonObj(FilesPath.jsonFilePath + "data.json", "age");
        System.out.println(data.toString());
    }

    @Test
    public void readArrayOfStringFromJsonObj() {
        ArrayList<String> values = JsonUtils.readArrayOfStringFromJsonObj(FilesPath.jsonFilePath + "data.json", "paymentMethods");
        values.forEach(System.out::println);
    }

    @Test
    public void readObjFromJsonObj() {
        Map<String, String> values = JsonUtils.readObjFromJsonObj(FilesPath.jsonFilePath + "data.json", "address");
        System.out.println(values.get("city"));
        values.forEach((key, value) ->
                System.out.println(key + ": " + value));
    }

    @Test
    public void readArrayOfObjFromJsonObj() {
        System.out.println("**********************");
        JsonArray arrayOfObj = JsonUtils.readArrayOfObjFromJsonObj(FilesPath.jsonFilePath + "data4.json", "data");
            arrayOfObj.forEach(entry-> {
                Map<String, Object> obj = (Map<String, Object>) entry;
                obj.forEach((key, value) ->
                        System.out.println(key + ": " + value));
                JsonArray arrayOfObj2 = (JsonArray) obj.get("categories");
                arrayOfObj2.forEach(entry2 -> {
                    Map<String, String> obj2 = (Map<String, String>) entry2;
                    obj2.forEach((key, value) ->
                            System.out.println(key + ": " + value));
                });
            });
    }

    @Test
    public void readArrayOfObj() {
        System.out.println("**********************");
        JsonArray arrayOfObj = JsonUtils.readArrayOfObjFromJsonObj(FilesPath.jsonFilePath + "data.json", "projects");
        arrayOfObj.forEach(entry-> {
            Map<String, String> obj = (Map<String, String>) entry;
            obj.forEach((key, value) ->
                    System.out.println(key + ": " + value));
        });
    }
    @Test
    public void readJsonArray() {
        Object parser = JsonUtils.parseJson(FilesPath.jsonFilePath + "data2.json");
        ArrayList<String> arr;
        arr = (ArrayList<String>) parser;
        arr.forEach(
                System.out::println
        );
    }

    @Test
    public void readJsonObj() {
        Object parser = JsonUtils.deserializeJson(FilesPath.jsonFilePath + "data3.json");
        Map<String, String> obj;
        obj = (Map<String, String>) parser;
        obj.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
