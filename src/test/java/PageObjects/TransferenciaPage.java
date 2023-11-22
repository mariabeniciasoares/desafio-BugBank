package PageObjects;

import Suporte.Esperas;
import Suporte.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaPage {
    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(this.driver);
    }
    public WebElement getBotaoTransferencia() {
        WebElement getBotaoTransferencia = espera.visibilidadeDoElementoLocado
                (By.id("btn-TRANSFERÊNCIA"));
        js.highlight(driver,getBotaoTransferencia);
        return getBotaoTransferencia;
    }

    public WebElement getNumeroDaContaTransferencia() {
        WebElement getNumeroDaContaTransferencia = espera.visibilidadeDoElementoLocado
                (By.name("accountNumber"));
        js.highlight(driver,getNumeroDaContaTransferencia);
        return getNumeroDaContaTransferencia;
    }

    public WebElement getDigitoDaContaTransferencia() {
        WebElement getDigitoDaContaTransferencia = espera.visibilidadeDoElementoLocado
                (By.name("digit"));
        js.highlight(driver,getDigitoDaContaTransferencia);
        return getDigitoDaContaTransferencia;
    }

    public WebElement getValorTransferencia() {
        WebElement getValorTransferencia = espera.visibilidadeDoElementoLocado
                (By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[2]/input"));
        js.highlight(driver,getValorTransferencia);
        return getValorTransferencia;
    }

    public WebElement getDescricaoDaTransferencia() {
        WebElement getDescricaoDaTransferencia = espera.visibilidadeDoElementoLocado
                (By.name("description"));
        js.highlight(driver,getDescricaoDaTransferencia);
        return getDescricaoDaTransferencia;
    }

    public WebElement getbotaoTransferirAgora() {
        WebElement getbotaoTransferirAgora = espera.visibilidadeDoElementoLocado
                (By.xpath("//*[@id=\"__next\"]/div/div[3]/form/button"));
        js.highlight(driver,getbotaoTransferirAgora);
        return getbotaoTransferirAgora;
    }



}
