package com.sep.utilities;

import com.sep.utilities.file.PropertiesUtils;

/**
 * Reads the configuration properties from the Configuration.properties file.
 */
public class ConfigurationReader {

    /**
     * Returns the value of the specified property key from the Configuration.properties file.
     *
     * @param key the property key
     * @return the value of the specified property key
     */
    public static String getConfigProperty(String key) {
        if (key != null) {
            return PropertiesUtils.getProperty("Configuration.properties", key);
        }
        throw new NullPointerException("INVALID PROPERTIES KEY");
    }

}
