package PageObjects;

import Suporte.Esperas;
import Suporte.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroBancarioPage {
    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public CadastroBancarioPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(this.driver);
    }

    public WebElement getBotaoVoltar() {
        WebElement getBotaoVoltarAoLogin = espera.visibilidadeDoElementoLocado (By.xpath("//*[@id=\"btnBack\"]"));
        js.highlight(driver,getBotaoVoltarAoLogin);
        return getBotaoVoltarAoLogin;
    }

    public WebElement getEmail() {
        WebElement getEmail = espera.visibilidadeDoElementoLocado
                (By.xpath("//form/div[2]/input"));
        js.highlight(driver,getEmail);
        return getEmail;
    }
    public WebElement getNome() {
        WebElement getNome = espera.visibilidadeDoElementoLocado
                (By.xpath("//input[@type='name' and @name='name']"));
        js.highlight(driver,getNome);
        return getNome;
    }

    public WebElement getSenha() {
        WebElement getSenha = espera.visibilidadeDoElementoLocado (By.xpath("//form[@class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY']//input[@placeholder='Informe sua senha']"));
        js.highlight(driver,getSenha);
        return getSenha;
    }

    public WebElement getConfirmacaoDaSenha() {
        WebElement getConfirmacaoDaSenha = espera.visibilidadeDoElementoLocado
                (By.xpath("//input[@type='password' and @name='passwordConfirmation']"));
        js.highlight(driver,getConfirmacaoDaSenha);
        return getConfirmacaoDaSenha;
    }
    public WebElement getBotaoToggleAddBalance() {
        WebElement getBotaoToggleAddBalance = espera.visibilidadeDoElementoLocado (By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[6]/label"));
        js.highlight(driver,getBotaoToggleAddBalance);
        return getBotaoToggleAddBalance;
    }

    public WebElement getBotaoCadastrar() {
        WebElement getBotaoCadastrar = espera.visibilidadeDoElementoLocado (By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/button"));
        js.highlight(driver,getBotaoCadastrar);
        return getBotaoCadastrar;
    }
    public WebElement getBotaoSair() {
       WebElement getBotaoSair = espera.visibilidadeDoElementoLocado (By.xpath("/html/body/div/div/div[1]/div/a"));
        js.highlight(driver,getBotaoSair);
        return getBotaoSair;
    }
}
