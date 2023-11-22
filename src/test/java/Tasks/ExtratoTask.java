package Tasks;

import PageObjects.ExtratoPage;
import PageObjects.LoginPage;
import Suporte.*;
import Utilitarios.GeradorDeFake;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ExtratoTask {
    private static WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();
    GerenciadorProperties gerenciador = GerenciadorProperties.getInstancia();
    ExtratoPage extratoPage = new ExtratoPage(driver);
    private LoginPage loginPage;
    private static GeradorDeFake geradorDeFake;

    public ExtratoTask(WebDriver driver) {
        this.driver = driver;
        geradorDeFake = new GeradorDeFake(this.driver);
        espera = new Esperas(this.driver);
        extratoPage= new ExtratoPage(this.driver);
    }
    public void botaoExtrato(){
        extratoPage.getBotaoExtrato().click();
    }

    public void exibeSaldoDisponivel(){
        obterSaldoDisponivel();
    }
    public String obterSaldoDisponivel(){
        String valorSaldoDisponível = extratoPage.getSaldoDisponível().getText();
        return valorSaldoDisponível;
    }
    public void exibeSaldoAdicionadoAoAbrirConta(){
        obterSaldoAdicionadoAoAbrirConta();
    }
    public String obterSaldoAdicionadoAoAbrirConta(){
        String valorSaldoAdicionadoAoAbrirConta = extratoPage.getSaldoAdicionadoAoAbrirConta().getText();
        return valorSaldoAdicionadoAoAbrirConta;
    }
    public void exibeValorTransferenciaEnviada(){
        obterValorTransferenciaEnviada();
        exibirExtrato();
    }
    public String obterValorTransferenciaEnviada(){
        String valorTransferenciaEnviada = extratoPage.getValorTransferenciaEnviada().getText();
        return valorTransferenciaEnviada;
    }
    public void exibeValorTransferenciaRecebida(){
       obterValorTransferenciaRecebida();
       exibirExtrato();
    }
    public String obterValorTransferenciaRecebida(){
        String valorTransferenciaRecebida = extratoPage.getValorTransferenciaRecebida().getText();
        return valorTransferenciaRecebida;
    }

    private void exibirExtrato() {
        try {
            Relatorio.extentTest.log(Status.PASS, "Extrato exibido com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (TimeoutException e) {
            Relatorio.extentTest.log(Status.FAIL, "Ocorreu algum problema na exibição do extrato" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }

}
