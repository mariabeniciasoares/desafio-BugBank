package Suporte;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class CapturaDeTela {
    private static final String CAMINHO_CAPTURA_TELA = System.getProperty("user.dir") + File.separator + "Report"
            + File.separator + "ImageCapture";

    public static MediaEntityModelProvider capturaTela(WebDriver driver){
        try {
            CriaDiretorio.criaDiretoriaRelatorio(CAMINHO_CAPTURA_TELA);
            File capturaTela = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String caminho = CAMINHO_CAPTURA_TELA + File.separator + capturaTela.getName();
            FileUtils.copyFile(capturaTela, new File(caminho));
            return MediaEntityBuilder.createScreenCaptureFromPath(caminho).build();
        } catch (Exception e){
            System.out.println("Não foi realizada a captura de tela!!!" + e.getMessage());
        }
        return null;
    }

    public static MediaEntityModelProvider capturaTelaBase64(WebDriver driver){
        try {
            CriaDiretorio.criaDiretoriaRelatorio(CAMINHO_CAPTURA_TELA);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build();
        } catch (Exception e){
            System.out.println("Não foi realizada a captura de tela!!!" + e.getMessage());
        }
        return null;
    }
}
