package Tasks;

import PageObjects.CadastroBancarioPage;
import PageObjects.TransferenciaPage;
import Suporte.*;
import Utilitarios.GeradorDeFake;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class TransferenciaTask {

    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();
    GerenciadorProperties gerenciador = GerenciadorProperties.getInstancia();

    private TransferenciaPage transferenciaPage;
    private static GeradorDeFake geradorDeFake;

    public TransferenciaTask(WebDriver driver) {
        this.driver = driver;
        geradorDeFake = new GeradorDeFake(this.driver);
        espera = new Esperas(this.driver);
        transferenciaPage = new TransferenciaPage(this.driver);
    }
    public void botaoTransferencia() {
        transferenciaPage.getBotaoTransferencia().click();
    }
    public void digitarNumeroDaContaTransferencia() {

        transferenciaPage.getNumeroDaContaTransferencia().clear();
        transferenciaPage.getNumeroDaContaTransferencia().isDisplayed();
        String dado = gerenciador.lerPropriedade("conta2");
        transferenciaPage.getNumeroDaContaTransferencia().sendKeys(dado);
        transferenciaPage.getNumeroDaContaTransferencia().sendKeys(Keys.TAB);
        validaGetNumeroDaContaTransferencia();
    }
    private void validaGetNumeroDaContaTransferencia() {
        try {
            Assertions.assertFalse(transferenciaPage.getNumeroDaContaTransferencia().getAttribute("value").equalsIgnoreCase(" "));
            Relatorio.extentTest.log(Status.PASS, "Conta da Transferencia inserida com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "A conta da Transferencia inserida não é válida!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    public void digitarDigitoDaContaTransferencia() {
        transferenciaPage.getDigitoDaContaTransferencia().clear();
        transferenciaPage.getDigitoDaContaTransferencia().isDisplayed();
        String dado = gerenciador.lerPropriedade("digito2");
        transferenciaPage.getDigitoDaContaTransferencia().sendKeys(dado);
        transferenciaPage.getDigitoDaContaTransferencia().sendKeys(Keys.TAB);
        validaGetDigitoDaContaTransferencia();
    }
    private void validaGetDigitoDaContaTransferencia() {
        try {
            Assertions.assertFalse(transferenciaPage.getDigitoDaContaTransferencia().getAttribute("value").equalsIgnoreCase(" "));
            Relatorio.extentTest.log(Status.PASS, "Digito da conta a ser Transferida inserida com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "O digito da conta a ser transferida  inserido não é válida!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    public void digitarValorTransferencia() {
        transferenciaPage.getValorTransferencia().isDisplayed();
        transferenciaPage.getValorTransferencia().clear();
        String valorTransferido = String.valueOf(100.00);
        transferenciaPage.getValorTransferencia().sendKeys(valorTransferido);
        gerenciador.salvarPropriedade("transferencia1", String.valueOf(valorTransferido));
        gerenciador.salvarPropriedade("transferencia2", String.valueOf(valorTransferido));
        transferenciaPage.getValorTransferencia().sendKeys(Keys.TAB);
        validaGetValorTransferencia();
    }
    private void validaGetValorTransferencia() {
        try {
            Assertions.assertFalse(transferenciaPage.getValorTransferencia().getAttribute("value").equalsIgnoreCase(" "));
            Relatorio.extentTest.log(Status.PASS, "O valor foi inserido com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "O valor inserido não é válido!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    public void digitarDescricaoDaTransferencia() {

        transferenciaPage.getDescricaoDaTransferencia().clear();
        transferenciaPage.getDescricaoDaTransferencia().isDisplayed();
        String textoDescricaoTransferencia = "Transferencia realizada por " + gerenciador.lerPropriedade("nome1");
        transferenciaPage.getDescricaoDaTransferencia().sendKeys(textoDescricaoTransferencia);
        transferenciaPage.getDescricaoDaTransferencia().sendKeys(Keys.TAB);
        validaGetDescricaoDaTransferencia();
    }
    private void validaGetDescricaoDaTransferencia() {
        try {
            Assertions.assertFalse(transferenciaPage.getDescricaoDaTransferencia().getAttribute("value").equalsIgnoreCase(" "));
            Relatorio.extentTest.log(Status.PASS, "A descrição foi inserida com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "A descrição inserida não é válida!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    public void botaoTransferirAgora() {
        transferenciaPage.getbotaoTransferirAgora().isDisplayed();
        transferenciaPage.getbotaoTransferirAgora().click();
    }
}
