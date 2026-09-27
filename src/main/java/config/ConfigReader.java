package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("Config.properties");

            if (input == null) {
                throw new RuntimeException(
                        "Config.properties file not found"
                );
            }

            properties.load(input);
            input.close();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load Config.properties", e
            );
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
