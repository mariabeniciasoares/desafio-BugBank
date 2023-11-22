package PageObjects;

import Suporte.Esperas;
import Suporte.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(this.driver);
    }
    public WebElement getInformeSeuEmail() {
        WebElement getInformeSeuEmail = espera.visibilidadeDoElementoLocado
                (By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input"));
        js.highlight(driver,getInformeSeuEmail);
        return getInformeSeuEmail;
    }
    public WebElement getInformeSuaSenha() {
        WebElement getInformeSuaSenha = espera.visibilidadeDoElementoLocado
                (By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input"));
        js.highlight(driver,getInformeSuaSenha);
        return getInformeSuaSenha;
    }
    public WebElement getBotaoAcessar() {
        WebElement getBotaoAcessar = espera.visibilidadeDoElementoLocado
                ((By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[1]")));
        js.highlight(driver,getBotaoAcessar);
        return getBotaoAcessar;
    }
    public WebElement getBotaoRegistrar() {
        WebElement getBotaoRegistrar = espera.visibilidadeDoElementoLocado
                (By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]"));
        js.highlight(driver,getBotaoRegistrar);
        return getBotaoRegistrar;
    }
}
