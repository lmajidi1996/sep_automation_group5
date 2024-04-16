package com.sep.utilities.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {


    /**
 * Reads the properties file from the given path and returns the properties object.
 *
 * @param path the path of the properties file
 * @return the properties object from the properties file
 * @throws IOException if there is an error reading the properties file
 */
public static Properties readProperties(String path) {
    Properties properties = new Properties();
    try (FileInputStream file = new FileInputStream(path)) {
        properties.load(file);
    } catch (IOException e) {
        System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
        e.printStackTrace();
    }
    return properties;
}



    /**
 * Reads the properties file from the given path and returns the value of the given key.
 *
 * @param path the path of the properties file
 * @param key the key of the value to be retrieved
 * @return the value of the given key from the properties file
 */
public static String getProperty(String path, String key) {
    Properties properties = readProperties(path);

    try {
        FileInputStream file = new FileInputStream(path);
        properties.load(file);
        file.close();

    } catch (IOException e) {
        System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
        e.printStackTrace();
    }
    return properties.getProperty(key);
}


    /**
 * Reads the properties file from the given path and returns a map of key-value pairs.
 *
 * @param path the path of the properties file
 * @return a map of key-value pairs from the properties file
 */
public static Map<String, String> getProperties(String path) {
    Map<String, String> map = new HashMap<>();
    Properties properties = readProperties(path);

    try {
        FileInputStream file = new FileInputStream(path);
        properties.load(file);

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            map.put(key, value);
        }

    } catch (IOException e) {
        System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
        e.printStackTrace();
    }

    return map;
}


}
