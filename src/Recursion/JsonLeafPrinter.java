package Recursion;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonLeafPrinter {
    public static void printLeafNodes(String path, Object obj) {
        if (obj instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) obj;
            for (String key : jsonObj.keySet()) {
                Object value = jsonObj.get(key);
                printLeafNodes(path.isEmpty() ? key : path + "." + key, value);
            }
        } else if (obj instanceof JSONArray) {
            JSONArray arr = (JSONArray) obj;
            for (int i = 0; i < arr.length(); i++) {
                Object value = arr.get(i);
                printLeafNodes(path + "[" + i + "]", value);
            }
        } else {
            // Primitive value
            System.out.println(path + "=" + obj);
        }
    }

    public static void main(String[] args) {
        // Example JSONs
        String json1 = "{\"arr\":[10,20]}";
        String json2 = "{\"a\":{\"b\":1}}";
        JSONObject obj1 = new JSONObject(json1);
        JSONObject obj2 = new JSONObject(json2);

        printLeafNodes("", obj1);
        printLeafNodes("", obj2);
    }
}
