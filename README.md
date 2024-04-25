# Projeto Cryptography

Este projeto é uma aplicação Spring Boot que fornece uma API REST para criar e listar transações. As transações são criptografadas e descriptografadas usando a biblioteca Jasypt.

## Pré-requisitos

-   Java 11
-   Maven
-   Docker
-   Git

## Clonando o projeto

Para clonar o projeto, execute o seguinte comando no terminal:

```bash
git clone https://github.com/igor-marchi/cryptography.git
```

## Subindo o Docker

Para subir o Docker, navegue até a pasta docker no diretório do projeto e execute o seguinte comando:

```bash
docker-compose up
```

## Configurando a variável de ambiente

Este projeto requer uma variável de ambiente chamada `CRYPTO_PASSWORD`. Esta variável é usada para criptografar e descriptografar as transações.

Para definir a variável de ambiente, execute o seguinte comando no terminal:

```bash
export CRYPTO_PASSWORD=your_password
```

Substitua `your_password` pela senha que você deseja usar.

## Executando o projeto

Para executar o projeto, navegue até o diretório do projeto e execute o seguinte comando:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

-   `POST /transactions`: Cria uma nova transação.
-   `GET /transactions`: Lista todas as transações.

Para mais detalhes sobre os endpoints, consulte os arquivos `TransactionController.java` e `request.http`.

## Arquivo request.http

O arquivo `request.http` é um arquivo de teste de API que contém exemplos de solicitações HTTP que podem ser feitas para a API do projeto. Ele é útil para testar rapidamente as funcionalidades da API sem a necessidade de um cliente externo, como o Postman.

Aqui estão as solicitações HTTP presentes no arquivo:

1. **Criar Transação**

    Este é um exemplo de uma solicitação POST para criar uma nova transação. A URL da solicitação é `http://localhost:8080/transactions`. O corpo da solicitação é um objeto JSON que contém os detalhes da transação, incluindo o documento do usuário, o token do cartão de crédito e o valor da transação.

    ```http

    ### Create Transaction

    POST http://localhost:8080/transactions
    Content-Type: application/json

    {
    "userDocument": "12345678910",
    "creditCardToken": "abcd1234",
    "amount": 1000
    }
    ```

2. **Listar Transações**

    Este é um exemplo de uma solicitação GET para listar todas as transações. A URL da solicitação é `http://localhost:8080/transactions?page=0&size=11`. Os parâmetros de consulta `page` e `size` são usados para implementar a paginação.

    ```http

    ### List Transactions

    GET http://localhost:8080/transactions?page=0&size=11
    ```

3. **Listar Transação por id**

    Este é um exemplo de uma solicitação GET para listar uma transação específica pelo id. A URL da solicitação é `http://localhost:8080/transactions/{{id}}`. O `{{id}}` é um placeholder que deve ser substituído pelo id da transação que você deseja visualizar.

    ```http

    ### List Transaction by id

    GET http://localhost:8080/transactions/{{id}}
    ```

4. **Atualizar Transação**

    Este é um exemplo de uma solicitação PUT para atualizar uma transação existente. A URL da solicitação é `http://localhost:8080/transactions/{{id}}`. O `{{id}}` é um placeholder que deve ser substituído pelo id da transação que você deseja atualizar. O corpo da solicitação é um objeto JSON que contém os detalhes da transação que você deseja atualizar.

    ```http

    ### Update Transaction

    PUT http://localhost:8080/transactions/{{id}}
    Content-Type: application/json

    {
    "amount": 100
    }
    ```

5. **Deletar Transação por id**

    Este é um exemplo de uma solicitação DELETE para deletar uma transação específica pelo id. A URL da solicitação é `http://localhost:8080/transactions/{{id}}`. O `{{id}}` é um placeholder que deve ser substituído pelo id da transação que você deseja deletar.

    ```http

    ### Delete Transaction by id

    DELETE http://localhost:8080/transactions/{{id}}
    ```

Para executar essas solicitações no Visual Studio Code, você pode instalar a extensão "REST Client" e abrir o arquivo `request.http`. Clique no link "Send Request" que aparece acima de cada solicitação.

<p align="center">Feito com amor por <a href="https://www.linkedin.com/in/igor-marchi/">Igor Marchi</a> ❤️</p>
