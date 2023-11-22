package Suporte;

import Utilitarios.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static Suporte.Relatorio.configuraRelatorioExtent;
import static Suporte.Relatorio.*;

public class TesteBase extends GerenciadorDriver {
    private static WebDriver driver;
    private static FileOperations fileOperations = new FileOperations();

    public static WebDriver getDriver(){
        driver = getDriver(TipoDriver.CHROME);
        return driver;
    }

    @BeforeEach
    public void inicializa() throws IOException {

        String URL = fileOperations.getProperties("url").getProperty("url.index");
        configuraRelatorioExtent();
        getDriver().get(URL);
    }

    @AfterEach
    public void encerra(){
        encerraRelatorio();
        encerrarDriver();
    }
}
