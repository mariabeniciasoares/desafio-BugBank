package Utilitarios;

import java.io.IOException;
import java.util.Properties;

public class ConfiguracaoProperties {
    private static Properties properties;

    static {
        FileOperations fileOperations = new FileOperations();
        try {
            properties = fileOperations.getProperties("meuarquivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPropriedade(String chave) {

        return properties.getProperty(chave);
    }
}
