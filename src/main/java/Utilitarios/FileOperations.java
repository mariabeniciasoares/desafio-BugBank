package Utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileOperations {
    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources" + File.separator;

    public Properties getProperties(String fileName) throws IOException {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            File file = new File(DIR_PATH_PROPERTIES + fileName + ".properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties;
        } catch (Exception e){
            System.out.println("Passando Exception" + e.getMessage());
        } finally {
            inputStream.close();
        }
        return properties;
    }
}
