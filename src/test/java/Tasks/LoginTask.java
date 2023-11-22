package Tasks;

import PageObjects.CadastroBancarioPage;
import PageObjects.LoginPage;
import Suporte.*;
import Utilitarios.FileOperations;
import Utilitarios.GeradorDeFake;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

//import static Utilitarios.ConfiguracaoProperties.properties;

public class LoginTask {
    private static WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();
    GerenciadorProperties gerenciador = GerenciadorProperties.getInstancia();


    private LoginPage loginPage;
    private static GeradorDeFake geradorDeFake;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        geradorDeFake = new GeradorDeFake(this.driver);
        espera = new Esperas(this.driver);
        loginPage = new LoginPage(this.driver);
     }

    public void digitarEmail() {
        loginPage.getInformeSeuEmail().clear();
        loginPage.getInformeSeuEmail().isDisplayed();
        loginPage.getInformeSeuEmail().clear();
        String valor = gerenciador.lerPropriedade("email1");

        loginPage.getInformeSeuEmail().sendKeys(valor);
        loginPage.getInformeSeuEmail().sendKeys(Keys.TAB);
        validaGetDigitarEmail();
    }
    private void validaGetDigitarEmail() {
        try {
            Assertions.assertFalse(loginPage.getInformeSeuEmail().getAttribute("value").equalsIgnoreCase(" "));
            Relatorio.extentTest.log(Status.PASS, "E-mail inserido com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        }catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "O e-mail inserido não é válido!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }

    public void digitarEmail2() {
        loginPage.getInformeSeuEmail().clear();
        loginPage.getInformeSeuEmail().isDisplayed();
        loginPage.getInformeSeuEmail().clear();
        String valor = gerenciador.lerPropriedade("email2");
        loginPage.getInformeSeuEmail().sendKeys(valor);
        loginPage.getInformeSeuEmail().sendKeys(Keys.TAB);
        validaGetDigitarEmail();
    }
    public void digitarSenha(){
        loginPage.getInformeSuaSenha().clear();
        loginPage.getInformeSuaSenha().isDisplayed();
        loginPage.getInformeSuaSenha().clear();
        String valor = gerenciador.lerPropriedade("senha1");

        loginPage.getInformeSuaSenha().sendKeys(valor);
        loginPage.getInformeSuaSenha().sendKeys(Keys.TAB);
        validaGetDigitarSenha();
    }
    private void validaGetDigitarSenha() {
        try {
            Assertions.assertFalse(loginPage.getInformeSuaSenha().getAttribute("value").equalsIgnoreCase(" "));
            Relatorio.extentTest.log(Status.PASS, "Senha inserida com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        }catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "A senha inserida não é válida!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }

    public void digitarSenha2(){
        loginPage.getInformeSuaSenha().clear();
        loginPage.getInformeSuaSenha().isDisplayed();
        loginPage.getInformeSuaSenha().clear();
        String valor = gerenciador.lerPropriedade("senha2");
        loginPage.getInformeSuaSenha().sendKeys(valor);
        loginPage.getInformeSuaSenha().sendKeys(Keys.TAB);
        validaGetDigitarSenha();
    }
    public void botaoAcessar(){
        loginPage.getBotaoAcessar().click();
    }

    public void botaoRegistar(){
        loginPage.getBotaoRegistrar().isDisplayed();
        loginPage.getBotaoRegistrar().click();
    }
}
