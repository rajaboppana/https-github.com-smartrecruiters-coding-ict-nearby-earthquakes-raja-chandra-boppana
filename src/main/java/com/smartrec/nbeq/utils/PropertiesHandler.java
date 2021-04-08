package com.smartrec.nbeq.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author RajaBoppana
 *
 */
public class PropertiesHandler {

    private static final Logger LOGGER = LogManager.getLogger();
    
    private String propertiesFileName;
    private Properties properties;

    public PropertiesHandler(String propertiesFileName) {
        LOGGER.debug("Using properties file: " + propertiesFileName);
        this.propertiesFileName = propertiesFileName;
        readPropertiesFromFile();
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private void readPropertiesFromFile() {
        properties = new Properties();
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(propertiesFileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
