# Desafio WEB - BugBank

**Nome do Projeto:** Desafio BugBank

**Descrição do projeto**:

O projeto “Desafio BugBank” tem como objetivo demonstrar o conhecimentos em Automação de Testes.

Será desenvolvido o Caso de teste “Realizar Transferência entre Contas” seguindo as etapas definidas abaixo:
1. Acessar o site https://bugbank.netlify.app/
2. Criar duas contas com Saldo e salvar os seus dados.
3. Acessar uma conta e realizar uma transferência de valor para outra.
4. Validar a saída e entrada das contas envolvidas.


**Tecnologias Utilizadas**

Para realizar os testes foram utilizadas as seguintes tecnologias:

•	Java 8 Update 231

•	Junit5 5.6.2

•	IntelliJ IDEA 2023.1.3 (Community Edition)

•	Maven 4.0.0


**Padrões Utilizados**

Este teste se divide em:

**Main**


*Suporte*: Pasta onde ficam classes com métodos auxiliares que podem ser usadas em várias outras classes.

*Utilitários*: Esta pasta divide-se em duas classes: FileOperations e GeradorDeFake (DIUS/java-faker).
1) Classe FileOperations responsável por definir o caminho para a pasta de recursos onde se espera que os arquivos
de propriedades (.properties) estejam localizados. O caminho é construído com base no diretório atual do projeto
através da constante DIR_PATH_PROPERTIES e o método getProperties(String fileName)

2) Classe GeradorDeFake responsável por criar dados falsos usando a biblioteca JavaFaker. 

     **Não foi possível o uso desta funcionalidade em razão que todos os testes os dados geraram erros nas consultas.**

*Resources*: Pasta aonde esta descrita a URL "https://bugbank.netlify.app/" deste desafio.

**Test**

*PageObjects*: Pasta onde ficam todas as classes devidamente mapeadas

*Tasks*: Pasta onde ficam todos os métodos específicos para cada classe mapeada na pasta PageObjects

*TestsCases*: Pasta onde fica o cenário de teste – Realizar uma compra com sucesso


**Como executar o projeto?**

*1º- Serão geradas duas contas contábeis informando: email, nome e senha.*

*2º- Será realizada a transferencia de R$ 100,00 da conta da Maria para a conta do José.*

*3º- Serão validados os extratos contábeis das duas contas salientando e débito da primeira e o crédito da segunda conta.*