package PageObjects;

import Suporte.Esperas;
import Suporte.GerenciadorProperties;
import Suporte.JavaScriptExecutor;
import Utilitarios.ConfiguracaoProperties;
import Utilitarios.FileOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmacaoContaAbertaPage {
    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public ConfirmacaoContaAbertaPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(this.driver);
    }

    public WebElement getTextoNumeroConta() {
        WebElement getTextoNumeroConta = espera.visibilidadeDoElementoLocado
                (By.xpath("//p[contains(text(), 'foi criada com sucesso')]"));
        js.highlight(driver,getTextoNumeroConta);
        return getTextoNumeroConta;
    }
    public WebElement getBotaoFechar() {
        WebElement getBotaoFechar = espera.visibilidadeDoElementoLocado
                (By.id("btnCloseModal"));
        js.highlight(driver,getBotaoFechar);
        return getBotaoFechar;
    }

}
