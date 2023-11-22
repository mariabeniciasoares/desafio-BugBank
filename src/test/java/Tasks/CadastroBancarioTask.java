package Tasks;

import PageObjects.CadastroBancarioPage;
import Suporte.*;
import Utilitarios.GeradorDeFake;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class CadastroBancarioTask {

    private WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();
    GerenciadorProperties gerenciador = GerenciadorProperties.getInstancia();

    private CadastroBancarioPage cadastroBancarioPage;
    private static GeradorDeFake geradorDeFake;

    public CadastroBancarioTask(WebDriver driver) {
        this.driver = driver;
        geradorDeFake = new GeradorDeFake(this.driver);
        espera = new Esperas(this.driver);
        cadastroBancarioPage = new CadastroBancarioPage(this.driver);

    }


    public String inserirEmail() {
        cadastroBancarioPage.getEmail().clear();
        String email = "maria@gmail.com";
        cadastroBancarioPage.getEmail().sendKeys(email);
        gerenciador.salvarPropriedade("email1", String.valueOf(email));
        validaGetEmail();

        return email;

    }
    private void validaGetEmail() {
        try {
            String valorEmail = obterValorEmail();
            Assertions.assertFalse(valorEmail.trim().isEmpty(), "O e-mail inserido não é válido.");
            Relatorio.extentTest.log(Status.PASS, "E-mail inserido com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        } catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "O e-mail inserido não é válido!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    private String obterValorEmail() {
        WebElement campoEmail = cadastroBancarioPage.getEmail();
        return campoEmail.getAttribute("value");
    }


    public String inserirEmail2() {
        limparCamposTela();
        //cadastroBancarioPage.getEmail().clear();
        String email = "jose@gmail.com";
        cadastroBancarioPage.getEmail().sendKeys(email);
        gerenciador.salvarPropriedade("email2", String.valueOf(email));
        validaGetEmail();

        return email;
    }

    private void limparCamposTela() {
        cadastroBancarioPage.getEmail().clear();
        cadastroBancarioPage.getNome().clear();
        cadastroBancarioPage.getSenha().clear();
        cadastroBancarioPage.getConfirmacaoDaSenha().clear();
    }

    public String inserirNome(){
        cadastroBancarioPage.getNome().clear();
        String nome = "Maria da Silva";
        cadastroBancarioPage.getNome().sendKeys(nome);
        gerenciador.salvarPropriedade("nome1", String.valueOf(nome));
        validaGetFullName();

        return nome;
    }
    private void validaGetFullName() {
        try {
            String valorNome = obterValorNome();
            Assertions.assertNotNull(valorNome, "O valor do campo de nome não deve ser nulo.");
            Assertions.assertFalse(valorNome.trim().isEmpty(), "O nome inserido não é válido.");
            Relatorio.extentTest.log(Status.PASS, "Nome inserido com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        }catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "O nome inserido não é válido!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    private String obterValorNome() {
        WebElement campoNome = cadastroBancarioPage.getNome();
        return campoNome.getAttribute("value");
    }

    public String inserirNome2(){
        cadastroBancarioPage.getNome().clear();
        String nome = "Jose da Silva";
        cadastroBancarioPage.getNome().sendKeys(nome);
        gerenciador.salvarPropriedade("nome2", String.valueOf(nome));
        validaGetFullName();

        return nome;
    }
    private  String senhaSegura = generateSecurePassword();

    public String generateSecurePassword() {
        Faker faker = new Faker(new Locale("pt-BR"));
        String parteAleatoria = faker.lorem().characters(4, 12);
        String senhaSegura="A1B2C3";
        return senhaSegura;
    }
    public void inserirSenha(){
        cadastroBancarioPage.getSenha().clear();
        cadastroBancarioPage.getSenha().isEnabled();
        cadastroBancarioPage.getSenha().isDisplayed();
        cadastroBancarioPage.getSenha().sendKeys(senhaSegura);
        gerenciador.salvarPropriedade("senha1", String.valueOf(senhaSegura));

        validaGetSenha();
    }

    private void validaGetSenha() {
        try {
            String valorSenha = obterValorSenha();
            Assertions.assertNotNull(valorSenha, "O valor do campo de senha não deve ser nulo.");
            Assertions.assertFalse(valorSenha.trim().isEmpty(), "A senha inserida não pode ser vazia.");
            Relatorio.extentTest.log(Status.PASS, "Senha inserida com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        }catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "A senha inserida não é válida!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
    private String obterValorSenha() {
        return cadastroBancarioPage.getSenha().getAttribute("value");
    }
    public void inserirSenha2(){
        cadastroBancarioPage.getSenha().clear();
        cadastroBancarioPage.getSenha().isEnabled();
        cadastroBancarioPage.getSenha().isDisplayed();
        cadastroBancarioPage.getSenha().sendKeys(senhaSegura);
        gerenciador.salvarPropriedade("senha2", String.valueOf(senhaSegura));
        validaGetSenha();

    }
    public void inserirConfirmacaoDaSenha(){
        cadastroBancarioPage.getConfirmacaoDaSenha().clear();
        cadastroBancarioPage.getConfirmacaoDaSenha().sendKeys(senhaSegura);
        validaGetConfirmacaoDaSenha();

    }

    private void validaGetConfirmacaoDaSenha() {
        try {
            String valorConfirmacaoSenha = obterValorConfirmacaoDaSenha();

            Assertions.assertTrue(!valorConfirmacaoSenha.trim().isEmpty(), "A confirmação da senha inserida não é válida.");
            Relatorio.extentTest.log(Status.PASS, "Confirmação da senha inserida com sucesso!", CapturaDeTela.capturaTelaBase64(driver));
        }catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "A confirmação da senha inserida não é válida!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }

    private String obterValorConfirmacaoDaSenha() {
       return cadastroBancarioPage.getConfirmacaoDaSenha().getAttribute("value");
    }
    public void inserirConfirmacaoDaSenha2(){
        cadastroBancarioPage.getConfirmacaoDaSenha().clear();
        cadastroBancarioPage.getConfirmacaoDaSenha().sendKeys(senhaSegura);
        validaGetConfirmacaoDaSenha();

    }
    public void selecionarBotaoToggleAddBalance(){
        cadastroBancarioPage.getBotaoToggleAddBalance().isDisplayed();
        cadastroBancarioPage.getBotaoToggleAddBalance().isEnabled();
        cadastroBancarioPage.getBotaoToggleAddBalance().click();

    }

    public void selecionarBotaoCadastrar(){
        cadastroBancarioPage.getBotaoCadastrar().click();
    }

    public void botaoVoltar() {
        cadastroBancarioPage.getBotaoVoltar().click();
    }

    public void botaoSair() {
        cadastroBancarioPage.getBotaoSair().click();
    }

}
