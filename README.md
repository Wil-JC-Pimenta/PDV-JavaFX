**Projeto de Estudo**

# PDV JavaFX

Sistema de processamento de pagamentos desenvolvido em JavaFX que simula uma interface de PDV (Point of Sale).

## Requisitos

- Java Development Kit (JDK) 17 ou superior
- JavaFX SDK 17.0.15
- Variável de ambiente PATH_TO_FX configurada apontando para o diretório lib do JavaFX SDK

## Configuração do Ambiente

1. Baixe e instale o JDK 17 ou superior
2. Baixe o JavaFX SDK 17.0.15 do site oficial
3. Configure a variável de ambiente PATH_TO_FX:
   ```
   SET PATH_TO_FX=C:\seucaminho\javafx-sdk-22.0.1\lib
   ```

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── posgateway/
│   │               ├── PosGatewayApp.java
│   │               ├── controller/
│   │               │   └── PaymentController.java
│   │               └── service/
│   │                   ├── PaymentService.java
│   │                   ├── TerminalConnector.java
│   │                   └── TransactionResult.java
│   └── resources/
│       └── fxml/
│           └── PaymentForm.fxml
```

## Compilação e Execução

### Compilar o projeto

```cmd
javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls,javafx.fxml -encoding UTF-8 src/main/java/com/example/posgateway/*.java src/main/java/com/example/posgateway/controller/*.java src/main/java/com/example/posgateway/service/*.java
```

### Executar a aplicação

```cmd
java --module-path "%PATH_TO_FX%" --add-modules javafx.controls,javafx.fxml -cp "src/main/java;src/main/resources" com.posgateway.PosGatewayApp
```

### Gerar arquivo executável (JAR)

1. Primeiro, crie um arquivo `manifest.txt` na raiz do projeto com o seguinte conteúdo:

   ```
   Main-Class: com.posgateway.PosGatewayApp
   Class-Path: . javafx-controls.jar javafx-fxml.jar javafx-graphics.jar javafx-base.jar
   ```

2. Compile todas as classes do projeto:

   ```cmd
   mkdir target\classes
   javac --module-path "%PATH_TO_FX%" --add-modules javafx.controls,javafx.fxml -encoding UTF-8 -d target\classes src\main\java\com\example\posgateway\*.java src\main\java\com\example\posgateway\controller\*.java src\main\java\com\example\posgateway\service\*.java
   ```

3. Copie os recursos FXML para o diretório de classes:

   ```cmd
   xcopy /E /I src\main\resources\* target\classes
   ```

4. Crie o arquivo JAR:

   ```cmd
   cd target\classes
   jar cvfm PosGateway.jar ..\..\manifest.txt com\example\posgateway\*.class com\example\posgateway\controller\*.class com\example\posgateway\service\*.class fxml\*.fxml
   ```

5. Crie um script batch `run.bat` para executar o JAR:

   ```batch
   @echo off
   java --module-path "%PATH_TO_FX%" --add-modules javafx.controls,javafx.fxml -jar PosGateway.jar
   pause
   ```

6. Para executar a aplicação:
   - Copie o arquivo `PosGateway.jar` e `run.bat` para um diretório
   - Certifique-se que a variável PATH_TO_FX está configurada
   - Execute o arquivo `run.bat`

Observações:

- O JAR gerado depende do JavaFX, então o JavaFX SDK precisa estar instalado no computador de destino
- A variável PATH_TO_FX deve estar configurada no ambiente onde o JAR será executado
- Para distribuição, você pode criar um instalador que inclua o JDK, JavaFX SDK e configure as variáveis de ambiente automaticamente

## Funcionalidades

### Interface Gráfica

- Campo para inserção do valor da transação
- Campo para inserção do ID do pedido
- Botão para processar o pagamento
- Área de log para exibição dos resultados

### Serviços

- `PaymentService`: Responsável pelo processamento de pagamentos
- `TerminalConnector`: Interface para comunicação com o terminal de pagamento
- `TransactionResult`: Classe que representa o resultado da transação

## Endpoints do Serviço

### PaymentService

```java
public TransactionResult authorize(double amount, String orderId)
```

- **Descrição**: Autoriza uma transação de pagamento
- **Parâmetros**:
  - `amount`: Valor da transação
  - `orderId`: Identificador único do pedido
- **Retorno**: `TransactionResult` contendo o status da transação

### TerminalConnector

```java
public TransactionResult sendAuthorization(double amount, String transactionId)
```

- **Descrição**: Envia uma solicitação de autorização para o terminal
- **Parâmetros**:
  - `amount`: Valor da transação
  - `transactionId`: Identificador da transação
- **Retorno**: `TransactionResult` com o resultado do processamento

## Testes

### PaymentServiceTest

Testes unitários para validar o funcionamento do serviço de pagamento:

```java
@Test
public void testAuthorizePayment()
```

- **Objetivo**: Verificar se o serviço processa corretamente uma transação
- **Cenários testados**:
  - Autorização com sucesso
  - Validação de valores negativos
  - Validação de ID de pedido nulo ou vazio

## Logs e Monitoramento

O sistema registra as seguintes informações durante o processamento:

- Início da transação com valor e ID
- Resultado do processamento (Aprovado/Negado)
- Mensagens de erro em caso de falha

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
