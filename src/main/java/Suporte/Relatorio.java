package Suporte;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relatorio {
    public static WebDriver driver;
    private static final String CAMINHO_RELATORIO = System.getProperty("user.dir") + File.separator + "Report";
    public static ExtentHtmlReporter htmlRelatorio;
    public static ExtentReports extentRelatorio;
    public static ExtentTest extentTest;

    public static void configuraRelatorioExtent(){
        CriaDiretorio.criaDiretoriaRelatorio(CAMINHO_RELATORIO);

        Date dataAtual =new Date();
        SimpleDateFormat formatoDt = new SimpleDateFormat("ddMMyyyy_HHmm");
        htmlRelatorio = new ExtentHtmlReporter(CAMINHO_RELATORIO + File.separator
                + "Relatorio de evidencia gerado em " + formatoDt.format(dataAtual) + ".html");

        htmlRelatorio.config().setDocumentTitle("Relatorio de Automacao - Desafio WEB - BugBank (https://bugbank.netlify.app/) ");
        htmlRelatorio.config().setReportName("Relatorio do Caso de Teste: Realizar Transferência entre Contas");
        htmlRelatorio.config().setTheme(Theme.STANDARD);
        htmlRelatorio.config().setEncoding("UTF-8");
        htmlRelatorio.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlRelatorio.config().setCSS(".nav-wrapper { background-color: #1E317A !important; } .brand-logo " +
                "{ background-color: #1E317A !important; padding: 0 10px 0 0 !important; margin: 0 !important; " +
                "position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 " +
                "{ background-color: #1E317A !important; color: #FFF !important;}");
        htmlRelatorio.config().setJS("$('.brand-logo').html('<img src=\"https://i.imgur.com/qDYwkD2.png\" " +
                "class=\"db-logo\"/>');");

        extentRelatorio = new ExtentReports();
        extentRelatorio.attachReporter(htmlRelatorio);
    }

    public static void encerraRelatorio(){
        extentRelatorio.flush();
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public static void inicializaTesteRelatorio(String descricao){
        extentTest = extentRelatorio.createTest(descricao);
    }
}
