package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager { private static String driverPath, url, password, username, wrongusername, wrongpassword;
    private static PropertyManager instance;

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {
        Properties properties = new Properties();
        try {
            FileInputStream fi = new FileInputStream("src/main/java/resources/configuration.properties");
            properties.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driverPath = properties.getProperty("driverPath");
        url = properties.getProperty("url");
        password = properties.getProperty("password");
        username = properties.getProperty("username");
        wrongpassword = properties.getProperty("wrongpassword");
        wrongusername = properties.getProperty("wrongusername");
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getUrl() {
        return url;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public String getWrongusername (){
        return wrongusername;
    }
    public String getWrongpassword () {
        return wrongpassword;
    }
}
