package TestsCases;

import Suporte.CapturaDeTela;
import Suporte.Relatorio;
import Suporte.TesteBase;
import Tasks.*;
import Utilitarios.ConfiguracaoProperties;
import Utilitarios.FileOperations;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarTransferenciaEntreContas extends TesteBase {
    private WebDriver driver = this.getDriver();

    private static FileOperations fileOperations = new FileOperations();

    LoginTask loginTask = new LoginTask(driver);
    CadastroBancarioTask cadastroBancarioTask = new CadastroBancarioTask(driver);
    ConfirmacaoContaAbertaTask confirmacaoContaAbertaTask = new ConfirmacaoContaAbertaTask(driver);
    MenuTask menuTask = new MenuTask(driver);
    TransferenciaTask transferenciaTask = new TransferenciaTask(driver);
    ExtratoTask extratoTask = new ExtratoTask(driver);

    ConfiguracaoProperties configuracaoProperties = new ConfiguracaoProperties();

    @Test
    public void RealizarTransferenciaEntreContas() {
        try {
            Relatorio.inicializaTesteRelatorio("Caso de teste: Realizar Transferencia entre Contas");
            loginTask.botaoRegistar();
            cadastroBancarioTask.inserirEmail();
            cadastroBancarioTask.inserirNome();
            cadastroBancarioTask.inserirSenha();
            cadastroBancarioTask.inserirConfirmacaoDaSenha();
            cadastroBancarioTask.selecionarBotaoToggleAddBalance();
            cadastroBancarioTask.selecionarBotaoCadastrar();
            confirmacaoContaAbertaTask.getNumeroContaAberta();
            confirmacaoContaAbertaTask.getFechar();
            loginTask.botaoRegistar();
            cadastroBancarioTask.inserirEmail2();
            cadastroBancarioTask.inserirNome2();
            cadastroBancarioTask.inserirSenha2();
            cadastroBancarioTask.inserirConfirmacaoDaSenha2();
            cadastroBancarioTask.selecionarBotaoToggleAddBalance();
            cadastroBancarioTask.selecionarBotaoToggleAddBalance();
            cadastroBancarioTask.selecionarBotaoCadastrar();
            confirmacaoContaAbertaTask.getNumeroContaAberta2();
            confirmacaoContaAbertaTask.getFechar();
            loginTask.digitarEmail();
            loginTask.digitarSenha();
            loginTask.botaoAcessar();
            transferenciaTask.botaoTransferencia();
            transferenciaTask.digitarNumeroDaContaTransferencia();
            transferenciaTask.digitarDigitoDaContaTransferencia();
            transferenciaTask.digitarValorTransferencia();
            transferenciaTask.digitarDescricaoDaTransferencia();
            transferenciaTask.botaoTransferirAgora();
            confirmacaoContaAbertaTask.getFechar();
            cadastroBancarioTask.botaoVoltar();
            menuTask.validaDadosCorrentista();
            extratoTask.botaoExtrato();
            extratoTask.exibeSaldoDisponivel();
            extratoTask.exibeSaldoAdicionadoAoAbrirConta();
            extratoTask.exibeValorTransferenciaEnviada();
            cadastroBancarioTask.botaoSair();
            loginTask.digitarEmail2();
            loginTask.digitarSenha2();
            loginTask.botaoAcessar();
            menuTask.validaDadosCorrentista();
            extratoTask.botaoExtrato();
            extratoTask.exibeSaldoDisponivel();
            extratoTask.exibeSaldoAdicionadoAoAbrirConta();
            extratoTask.exibeValorTransferenciaRecebida();
            cadastroBancarioTask.botaoVoltar();
            cadastroBancarioTask.botaoSair();
            Relatorio.extentTest.log(Status.PASS,"Caso de teste: Realizar Transferencia entre Contas - Finalizado !", CapturaDeTela.capturaTelaBase64(driver));
        } catch (Exception e){
            Relatorio.extentTest.log(Status.ERROR, e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
}
