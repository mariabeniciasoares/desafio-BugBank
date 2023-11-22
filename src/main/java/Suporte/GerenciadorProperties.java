package Suporte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class GerenciadorProperties {
    private Properties prop;

    // Variável estática para armazenar a única instância compartilhada
    private static GerenciadorProperties instanciaCompartilhada;

    // Construtor privado para evitar a criação de instâncias fora da classe
    private GerenciadorProperties() {
        prop = new Properties();
    }

    // Método para obter a instância compartilhada
    public static GerenciadorProperties getInstancia() {
        if (instanciaCompartilhada == null) {
            instanciaCompartilhada = new GerenciadorProperties();
        }
        return instanciaCompartilhada;
    }

    public void salvarPropriedade(String nomePropriedade, String valor) {
        prop.setProperty(nomePropriedade, valor);
        salvarPropriedadesEmArquivo("src/main/resources/meuarquivo.properties");
    }

    public void salvarPropriedadesEmArquivo(String caminhoArquivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(caminhoArquivo)) {
            prop.store(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerPropriedade(String nomePropriedade) {
        return prop.getProperty(nomePropriedade);
    }
}

