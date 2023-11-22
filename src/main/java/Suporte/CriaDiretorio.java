package Suporte;

import java.io.File;

public class CriaDiretorio {

    public static void criaDiretoriaRelatorio(String caminho){
        File caminhoRelatorio = new File(caminho);
        if (!caminhoRelatorio.exists()){
            caminhoRelatorio.mkdir();
        }
    }
}
