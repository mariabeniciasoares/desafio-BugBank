package Tasks;

import PageObjects.MenuPage;
import Suporte.*;
import Utilitarios.GeradorDeFake;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MenuTask {
    private static WebDriver driver;
    private Esperas espera;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    GerenciadorProperties gerenciador = GerenciadorProperties.getInstancia();


    private MenuPage menuPage;
    private static GeradorDeFake geradorDeFake;

    public MenuTask(WebDriver driver) {
        this.driver = driver;
        geradorDeFake = new GeradorDeFake(this.driver);
        espera = new Esperas(this.driver);
        menuPage = new MenuPage(this.driver);
    }

    public void validaDadosCorrentista() {
        menuPage.getMapearNomeCorrentista();
        validaNomeCorrentista();
    }

    private void validaNomeCorrentista() {
        try {
            String nomeCompleto = (menuPage.getMapearNomeCorrentista().getText()).replace("Olá ", "");
            String resultadoObtido1 = nomeCompleto.replace(",", "");
            boolean usarConta1;

            if (resultadoObtido1.equals("Maria da Silva")) {
                usarConta1 = true;
            } else {
                usarConta1 = false;
            }

            /* Valida o Nome */

            String nomePropriedade = usarConta1 ? "nome1" : "nome2";
            String resultadoEsperado1 = gerenciador.lerPropriedade(nomePropriedade);


            Assert.assertEquals(resultadoEsperado1, resultadoObtido1);

            /* Valida o Saldo */

            String saldoFinal = (menuPage.getSaldoEmConta().getText()).replace("Saldo em conta R$ ", "");
            String resultadoObtido3 = saldoFinal.replace(".", "");
            String resultadoObtido2 = resultadoObtido3.replace(",00", ".0");


            String saldoInicialPropriedade = usarConta1 ? "saldoInicial1" : "saldoInicial2";
            String transferenciaContaPropriedade = usarConta1 ? "transferencia1" : "transferencia2";
            double validaSaldo = Double.parseDouble(gerenciador.lerPropriedade(saldoInicialPropriedade));
            double validaTransfrencia = Double.parseDouble(gerenciador.lerPropriedade(transferenciaContaPropriedade));
            double resultadoEsperado2;
            if (resultadoObtido1.equals("Maria da Silva")) {
                resultadoEsperado2 = validaSaldo - validaTransfrencia;
            } else {
                resultadoEsperado2 = validaSaldo + validaTransfrencia;
            }
            String resultadoEsperadoString2 = Double.toString(resultadoEsperado2);


            Assert.assertEquals(resultadoEsperadoString2, resultadoObtido2);

            Relatorio.extentTest.log(Status.PASS, "Dados do correntista exibido estão corretos!", CapturaDeTela.capturaTelaBase64(driver));

        } catch (Exception e) {
            Relatorio.extentTest.log(Status.FAIL, "Dados do correntista exibido não estão corretos!" + e.getMessage(), CapturaDeTela.capturaTelaBase64(driver));
        }
    }
}
