package PageObjects;

import Suporte.Esperas;
import Suporte.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtratoPage {
    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public ExtratoPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(this.driver);
    }
    public WebElement getBotaoExtrato() {
        WebElement getBotaoExtrato = espera.visibilidadeDoElementoLocado (By.id("btn-EXTRATO"));
        js.highlight(driver,getBotaoExtrato);
        return getBotaoExtrato;

    }
    public WebElement getSaldoDisponível() {
        WebElement getSaldoDisponível = espera.visibilidadeDoElementoLocado (By.xpath("//*[@id=\"textBalanceAvailable\"]"));
        js.highlight(driver,getSaldoDisponível);
        return getSaldoDisponível;
    }

    public WebElement getSaldoAdicionadoAoAbrirConta() {
        WebElement getSaldoAdicionadoAoAbrirConta = espera.visibilidadeDoElementoLocado
                (By.xpath("//p[@class='bank-statement__Description-sc-7n8vh8-18 kdvgrb' and text()='Saldo adicionado ao abrir conta']"));
        js.highlight(driver,getSaldoAdicionadoAoAbrirConta);
        return getSaldoAdicionadoAoAbrirConta;
    }

    public WebElement getValorTransferenciaEnviada() {
        WebElement getValorTransferenciaEnviada = espera.visibilidadeDoElementoLocado
                (By.xpath("/html/body/div/div/div[3]/div/div[2]/div[2]/div[1]/p[2]"));
        js.highlight(driver,getValorTransferenciaEnviada);
        return getValorTransferenciaEnviada;
    }
    public WebElement getValorTransferenciaRecebida() {
        WebElement getValorTransferenciaRecebida = espera.visibilidadeDoElementoLocado
                (By.xpath("/html/body/div/div/div[3]/div/div[2]/div[2]/div[1]/p[2]"));
        js.highlight(driver,getValorTransferenciaRecebida);
        return getValorTransferenciaRecebida;
    }
}
