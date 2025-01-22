import com.github.cliftonlabs.json_simple.JsonArray;
import interfaces.FilesPath;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                Map<String, Object> obj = (HashMap<String, Object>) entry;
                obj.forEach((key, value) ->
                        System.out.println(key + ": " + value));
                JsonArray arrayOfObj2 = (JsonArray) obj.get("categories");
                arrayOfObj2.forEach(entry2 -> {
                    Map<String, String> obj2 = (HashMap<String, String>) entry2;
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
            Map<String, String> obj = (HashMap<String, String>) entry;
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
        obj = (HashMap<String, String>) parser;
        obj.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }


    @Test
    public void readJsonObjj() {
        Object parser = JsonUtils.deserializeJson(FilesPath.jsonFilePath + "data5.json");
        Map<String, Object> obj ;
        obj= (HashMap<String, Object>) parser;
        obj.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
        Map<String,Object > infoObj ;
        infoObj = (HashMap<String, Object>) obj.get("info");
        infoObj.forEach((key, value)->{
            System.out.println(key + ": " + value);
        });

        Map<String,String> contactObj ;
        contactObj = (HashMap<String, String>) infoObj.get("contacts");;
        contactObj.forEach((key, value)->{
            System.out.println(key + ": " + value);
        });

        List<Object> studentsList ;
        studentsList= (List<Object>) obj.get("students");
        studentsList.forEach(entry->{
            Map<String,Object> obj2 ;
            obj2 = (HashMap<String, Object>) entry;
            obj2.forEach((key,value)->{
                System.out.println(key + ": " + value);
            });
            Map<String,String > obj3 ;
            obj3 = (HashMap<String, String >) obj2.get("grade");
            obj3.forEach((key,value)->{
                System.out.println(key + ": " + value);
            });

        });
    }
}
