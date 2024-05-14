package in.pickright.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelpers {

    private static Properties properties;
    private static FileInputStream file;
    private static String fileLink;
    private static final String configFilePath = "/src/test/resources/config/config.properties";

    public static String getValue(String key) {
        String keyValue = null;
        try {
            if (file == null || properties == null) {
                properties = new Properties();
                fileLink = Helpers.getCurrentDir() + configFilePath; // Using System.getProperty to get the current directory
                file = new FileInputStream(fileLink);
                properties.load(file);
            }
            keyValue = properties.getProperty(key);
        } catch (IOException e) {
            // Log the exception instead of printing directly
            System.out.println("Error loading properties file: " + e.getMessage());
        } finally {
            // Move file closing outside the if condition
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    // Log the exception instead of printing directly
                    System.out.println("Error closing file stream: " + e.getMessage());
                }
            }
        }
        return keyValue;
    }
}
