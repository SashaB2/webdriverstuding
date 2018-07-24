package libs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {

    private static String configFile = "./src/main/resources/config.properties";

    /**
     * get value by key from config.properties
     * @param key
     * @return
     */
    public static String getConfigValue(String key){
        return getValueFromFile(key, configFile);
    }

    /**
     * get value by key from file
     * @param key
     * @param filename
     * @return
     */
    private static String getValueFromFile(String key, String filename){

        Properties property = new Properties();

        try {
            FileInputStream file = new FileInputStream(filename);
            property.load(file);
            file.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return property.getProperty(key);
    }
}
