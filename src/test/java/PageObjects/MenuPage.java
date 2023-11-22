package PageObjects;

import Suporte.Esperas;
import Suporte.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(this.driver);
    }

    public WebElement getSaldoEmConta() {
        WebElement getSaldoEmConta = espera.visibilidadeDoElementoLocado (By.id("textBalance"));
        js.highlight(driver,getSaldoEmConta);
        return getSaldoEmConta;

    }

    public WebElement getMapearNomeCorrentista() {
        WebElement getMapearNomeCorrentista = espera.visibilidadeDoElementoLocado(By.cssSelector("p#textName.home__Text-sc-1auj767-9"));
        js.highlight(driver,getMapearNomeCorrentista);
        return getMapearNomeCorrentista;
        
    }
}
