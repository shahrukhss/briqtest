package props;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

class AppProperties {

    private static String KEY;
    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    String appConfigPath = "app.properties";
    Properties appProp = new Properties();

    public String getKEY() throws Exception {

        appProp.load(new FileInputStream(appConfigPath));
        return appProp.getProperty("key");

    }

}
