# Projeto Cryptography

Este projeto é uma aplicação Spring Boot que fornece uma API REST para criar e listar transações. As transações são criptografadas e descriptografadas usando a biblioteca Jasypt.

## Pré-requisitos

- Java 11
- Maven
- Docker
- Git

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

- `POST /transactions`: Cria uma nova transação.
- `GET /transactions`: Lista todas as transações.

Para mais detalhes sobre os endpoints, consulte os arquivos `TransactionController.java` e `request.http`.

## Arquivo request.http

O arquivo `request.http` é um arquivo de teste de API que contém exemplos de solicitações HTTP que podem ser feitas para a API do projeto. Ele é útil para testar rapidamente as funcionalidades da API sem a necessidade de um cliente externo, como o Postman.

Aqui estão as solicitações HTTP presentes no arquivo:

1. **Criar Transação**

   Este é um exemplo de uma solicitação POST para criar uma nova transação. A URL da solicitação é `http://localhost:8080/transactions`. O corpo da solicitação é um objeto JSON que contém os detalhes da transação, incluindo o documento do usuário, o token do cartão de crédito e o valor da transação.

   \`\`\`http
   ### Create Transaction
   POST http://localhost:8080/transactions
   Content-Type: application/json

   {
   "userDocument": "12345678910",
   "creditCardToken": "abcd1234",
   "amount": 1000
   }
   \`\`\`

2. **Listar Transações**

   Este é um exemplo de uma solicitação GET para listar todas as transações. A URL da solicitação é `http://localhost:8080/transactions?page=0&size=11`. Os parâmetros de consulta `page` e `size` são usados para implementar a paginação.

   \`\`\`http
   ### List Transactions
   GET http://localhost:8080/transactions?page=0&size=11
   \`\`\`

Para executar essas solicitações no IntelliJ IDEA, você pode abrir o arquivo `request.http` e clicar no ícone de reprodução verde ao lado de cada solicitação.

Feito com amor por [Igor Marchi](https://www.linkedin.com/in/igor-marchi/) ❤️
#   c r y p t o g r a p h y  
 