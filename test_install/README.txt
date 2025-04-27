POS Gateway - Sistema de Pagamento
================================

Requisitos:
-----------
1. Java Development Kit (JDK) 17 ou superior
2. Windows 10 ou superior
3. Mínimo de 4GB de RAM
4. 100MB de espaço em disco

Instalação:
-----------
1. Extraia o arquivo PosGateway-Installer.zip para uma pasta de sua preferência
2. Execute o arquivo 'install.bat' como administrador:
   - Clique com botão direito -> "Executar como administrador"
   - O instalador irá:
     a) Verificar se o Java está instalado corretamente
     b) Configurar as variáveis de ambiente necessárias
     c) Copiar as bibliotecas do JavaFX
     d) Criar atalhos no menu iniciar (opcional)

3. Aguarde a conclusão da instalação
4. Reinicie o computador para garantir que as variáveis de ambiente sejam aplicadas

Execução:
---------
1. Após a instalação, você pode executar o aplicativo de três formas:
   a) Pelo atalho no Menu Iniciar (se criado durante a instalação)
   b) Pelo arquivo 'run.bat' na pasta 'bin'
   c) Pelo executável PosGateway.exe na pasta 'bin' (novo)

Recursos do Sistema:
------------------
1. Interface Gráfica
   - Design moderno e responsivo
   - Temas claro e escuro (novo)
   - Suporte a múltiplos idiomas (novo)
   - Interface adaptativa para diferentes resoluções

2. Processamento de Pagamentos
   - Suporte a diferentes valores e moedas
   - Validação em tempo real
   - Log detalhado de transações
   - Backup automático de dados (novo)

3. Segurança
   - Criptografia de dados sensíveis
   - Registro de atividades
   - Proteção contra inputs maliciosos
   - Autenticação de usuário (novo)

Estrutura do Pacote:
-------------------
PosGateway/
├── bin/
│   ├── PosGateway.jar
│   ├── PosGateway.exe (novo)
│   └── run.bat
├── lib/
│   ├── javafx.base.jar
│   ├── javafx.controls.jar
│   ├── javafx.fxml.jar
│   └── javafx.graphics.jar
├── config/
│   ├── settings.json
│   └── themes/
├── logs/
│   └── transactions.log
├── backup/
├── install.bat
├── uninstall.bat (novo)
└── README.txt

Processo de Instalação Detalhado:
-------------------------------
1. Pré-instalação:
   - Verifique se não há versões anteriores instaladas
   - Feche todos os programas em execução
   - Tenha privilégios de administrador

2. Durante a instalação:
   - O instalador verifica automaticamente os requisitos
   - Configuração das variáveis de ambiente:
     * POSGATEWAY_HOME: Diretório base da aplicação
     * PATH_TO_FX: Localização das bibliotecas JavaFX
   - Cópia dos arquivos necessários
   - Criação da estrutura de diretórios

3. Pós-instalação:
   - Verificação da instalação
   - Teste inicial do sistema
   - Criação de logs de instalação

Solução de Problemas:
--------------------
1. Se ocorrer erro "Java não encontrado":
   - Verifique se o Java está instalado: 'java -version'
   - Download do JDK: https://www.oracle.com/java/technologies/downloads/
   - Variável JAVA_HOME deve estar configurada

2. Se ocorrer erro "JavaFX não encontrado":
   - Execute install.bat novamente como administrador
   - Verifique o conteúdo da pasta 'lib'
   - Logs de erro em logs/install.log

3. Se a aplicação não iniciar:
   - Verifique as variáveis de ambiente (execute 'echo %POSGATEWAY_HOME%')
   - Consulte logs/application.log
   - Execute como administrador

4. Problemas comuns:
   - Erro de permissão: Use "Executar como administrador"
   - Tela em branco: Atualize driver de vídeo
   - Erro de conexão: Verifique firewall

Backup e Recuperação:
-------------------
- Backups automáticos em backup/
- Para restaurar: use o menu Configurações
- Mantenha seus dados seguros

Desinstalação:
-------------
1. Execute uninstall.bat como administrador
2. Selecione se deseja manter os dados
3. Aguarde a conclusão

Suporte:
--------
- Documentação online: https://posgateway.docs
- Email: suporte@posgateway.com
- Horário: Seg-Sex, 9h-18h
- Versão: 1.0.0

Notas de Segurança:
-----------------
- Mantenha o sistema atualizado
- Use senhas fortes
- Faça backup regularmente
- Monitore os logs 