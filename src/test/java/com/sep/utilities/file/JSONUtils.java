package com.sep.utilities.file;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONUtils {


    // Static method to parse a JSON file and return a JSONObject
    public static JSONObject parseJsonFile(String filePath) {
        JSONObject jsonObject = null;
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static List<Map<String, Object>> getJsonObjectsAsListOfMaps(String filePath) {
        List<Map<String, Object>> listOfMaps = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;
                Map<String, Object> map = (Map<String, Object>) jsonObject;
                listOfMaps.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfMaps;
    }


    // Static method to get data from a JSONObject
    public static String getData(JSONObject jsonObject, String key) {
        return (String) jsonObject.get(key);
    }



    // Static method to convert JSONObject to Map
    public static Map<String, Object> jsonToMap(JSONObject jsonObject) {
        return (Map<String, Object>) jsonObject;
    }

}
