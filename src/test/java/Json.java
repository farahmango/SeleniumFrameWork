import com.github.cliftonlabs.json_simple.JsonArray;
import interfaces.FilesPath;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.util.ArrayList;
import java.util.Map;

public class Json {

    @Test
    public void readObjFromJson() {
        Object data = JsonUtils.readObjFromJson(FilesPath.jsonFilePath + "data.json", "age");
        System.out.println(data.toString());
    }

    @Test
    public void readArrayFromJson() {
        JsonArray values = JsonUtils.readArrayFromJson(FilesPath.jsonFilePath + "data.json", "paymentMethods");
        values.forEach(System.out::println);
    }

    @Test
    public void readMapOfObjJson() {
        Map<String, Object> values = JsonUtils.readMapOfObjJson(FilesPath.jsonFilePath + "data.json", "address");
        values.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    public void readArrayOfObj() {
        JsonUtils.readArrayOfObj(FilesPath.jsonFilePath + "data.json", "projects");
    }

    @Test
    public void test() {
        Object parser = JsonUtils.parseJson(FilesPath.jsonFilePath + "data2.json");
        ArrayList<String> arr;
        arr = (ArrayList<String>) parser;
        for (String island : arr) {
            System.out.println(island);
        }
    }

    @Test
    public void test2() {
        Object parser = JsonUtils.parseJson(FilesPath.jsonFilePath + "data3.json");
        Map<String, Object> obj;
        obj = (Map<String, Object>) parser;
        obj.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
