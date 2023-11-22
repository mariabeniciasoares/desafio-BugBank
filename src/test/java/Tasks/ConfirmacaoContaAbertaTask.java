package Tasks;

import PageObjects.CadastroBancarioPage;
import PageObjects.ConfirmacaoContaAbertaPage;
import PageObjects.LoginPage;
import Suporte.*;
import Utilitarios.FileOperations;
import Utilitarios.GeradorDeFake;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmacaoContaAbertaTask {
    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();
    GerenciadorProperties gerenciador = GerenciadorProperties.getInstancia();

    private ConfirmacaoContaAbertaPage confirmacaoContaAbertaPage;
    private static GeradorDeFake geradorDeFake;

    public ConfirmacaoContaAbertaTask(WebDriver driver) {
        this.driver = driver;
        geradorDeFake = new GeradorDeFake(this.driver);
        espera = new Esperas(this.driver);
        confirmacaoContaAbertaPage = new ConfirmacaoContaAbertaPage(this.driver);

    }

    public void getNumeroContaAberta(){
        confirmacaoContaAbertaPage.getTextoNumeroConta();
        String textoCompleto =  confirmacaoContaAbertaPage.getTextoNumeroConta().getText();

        String padrao = "conta (.*?) foi";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(textoCompleto);

        String valorEntreContaeFoi = "";

        if (matcher.find()) {
            valorEntreContaeFoi = matcher.group(1);
        }

        String[] numerosSeparados = valorEntreContaeFoi.split("-");

        int numeroConta = Integer.parseInt(numerosSeparados[0]);
        int digitoNumeroConta = Integer.parseInt(numerosSeparados[1]);

        gerenciador.salvarPropriedade("conta1", String.valueOf(numeroConta));
        gerenciador.salvarPropriedadesEmArquivo("src/main/resources/meuarquivo.properties");

        gerenciador.salvarPropriedade("digito1", String.valueOf(digitoNumeroConta));

        gerenciador.salvarPropriedade("saldoInicial1", String.valueOf("1000.00"));
        
        validarContaAberta();
    }

    private void validarContaAberta() {
        try {
            Relatorio.extentTest.log(Status.PASS, "Conta aberta com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (TimeoutException e) {
            Relatorio.extentTest.log(Status.FAIL, "Ocorreu algum problema na abertura da conta ou mensagem não encontrada." + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }

    public void getNumeroContaAberta2(){
        confirmacaoContaAbertaPage.getTextoNumeroConta();
        String textoCompleto =  confirmacaoContaAbertaPage.getTextoNumeroConta().getText();

        String padrao = "conta (.*?) foi";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(textoCompleto);

        String valorEntreContaeFoi = "";

        if (matcher.find()) {
            valorEntreContaeFoi = matcher.group(1);
        }

        String[] numerosSeparados = valorEntreContaeFoi.split("-");

        int numeroConta = Integer.parseInt(numerosSeparados[0]);
        int digitoNumeroConta = Integer.parseInt(numerosSeparados[1]);

        gerenciador.salvarPropriedade("conta2", String.valueOf(numeroConta));
        gerenciador.salvarPropriedade("digito2", String.valueOf(digitoNumeroConta));
        gerenciador.salvarPropriedade("saldoInicial2", String.valueOf("1000.00"));

        validarContaAberta();

    }
    public void getFechar(){
        confirmacaoContaAbertaPage.getBotaoFechar().click();
    }

}
