package libs;

import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {

    private static String configFile;

    static{
        if(Global.isPlatform(Platform.WIN10)) {
            configFile = "./src/main/resources/configWindows.properties";
        }else if(Global.isPlatform(Platform.LINUX)){
            configFile = "./src/main/resources/configLinux.properties";
        }
    }

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
