# Ralie API

Uma aplicação Spring Boot construída com Kotlin para gerenciar e processar dados de usinas de energia da ANEEL (Agência Nacional de Energia Elétrica).

## Visão Geral

A Ralie API é um serviço backend que processa e gerencia dados de usinas de energia do portal de dados abertos da ANEEL. A aplicação importa e processa automaticamente dados em CSV contendo informações sobre usinas de energia em todo o Brasil, incluindo sua capacidade, localização e status operacional.

## Funcionalidades Principais

### Gerenciamento de Dados
- Importação automática de dados CSV do portal de dados abertos da ANEEL
- Atualizações programadas de dados (configurável via expressão cron)
- Processamento em lotes para importação eficiente de dados
- Armazenamento em banco de dados PostgreSQL

### Informações de Usinas
- Acompanhamento de usinas de energia em todo o Brasil
- Armazenamento de informações detalhadas incluindo:
  - Código CEG (identificador único)
  - Nome da usina
  - Potência outorgada (kW)
  - Estado (UF)
  - Tipo de geração
  - Origem do combustível
  - Situação da obra

### Endpoints da API
- `GET /api/v1/usinas/top` - Recupera as 5 maiores usinas por potência outorgada

## Stack Tecnológica

- **Linguagem**: Kotlin
- **Framework**: Spring Boot 3.4.5
- **Banco de Dados**: PostgreSQL
- **Ferramenta de Build**: Gradle
- **Containerização**: Docker
- **Processamento de Dados**: Kotlin CSV JVM

## Modelo de Dados

### Usina
- `codCEG`: String - Identificador único
- `nomeEmpreendimento`: String - Nome da usina
- `potenciaOutorgadaKw`: Double - Potência outorgada em kW
- `uf`: String - Código do estado (2 caracteres)
- `tipoGeracao`: String - Tipo de geração
- `origemCombustivel`: String - Origem do combustível
- `situacaoObra`: String - Situação da obra

## Pré-requisitos

- Java 17
- Docker e Docker Compose
- Gradle (opcional, pois o projeto inclui o Gradle Wrapper)

## Começando

### Executando com Docker Compose

1. Clone o repositório
2. Altere o docker-compose.yml para ajustar as variáveis de ambiente conforme necessário
3. Apenas execute o seguinte comando para iniciar a aplicação:
   ```bash
   docker-compose up
   ```

A aplicação estará disponível em `http://localhost:8080`

### Variáveis de Ambiente

A aplicação utiliza as seguintes variáveis de ambiente:
- `SPRING_DATASOURCE_URL`: URL de conexão com o banco de dados (padrão: jdbc:postgresql://postgres:5432/raliedb)
- `SPRING_DATASOURCE_USERNAME`: Nome de usuário do banco de dados (padrão: postgres)
- `SPRING_DATASOURCE_PASSWORD`: Senha do banco de dados (padrão: postgres)
- `USINA_IMPORT_CRON`: Expressão cron para importação programada de dados (padrão: "0 0 1 * * *" (Todos os dias 01:00 am))
- `USINA_CSV_URL`: URL para a fonte de dados CSV (padrão: URL de dados abertos da ANEEL)
- `USINA_EXEC_STARTUP`: Flag para controlar a importação de dados na inicialização (padrão: "1")

## Processo de Importação de Dados

1. A aplicação importa automaticamente dados do arquivo CSV da ANEEL
2. Os dados são processados em lotes de 1000 para eficiência
3. Os dados existentes são limpos antes de cada importação
4. O progresso da importação é registrado para monitoramento
5. O processo inclui tratamento de erros e logging

## Dependências

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- PostgreSQL Driver
- Kotlin CSV JVM

## Licença

Este projeto está licenciado sob os termos da Licença MIT.