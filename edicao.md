Para facilitar os testes dessa API está disponibilizada uma Collection para uso no Postman.
Para baixá-la [Clique Aqui](https://raw.githubusercontent.com/ismaelgcosta/is-my-burguer/main/is-my-burger%20-%20Gerenciamento%20de%20Clientes.postman_collection.json).

Para aprender como importar a Collection no [Postman](https://www.postman.com/) [Clique Aqui](https://apidog.com/blog/how-to-import-export-postman-collection-data/)

### Passo 1 - Cadastrar Novos Clientes: (Opcional)

Caso seja necessário cadastrar um novo Cliente no sistema é possível fazer através do serviço:

`POST -> http://localhost:8080/clientes `

Utilizando um requisição semelhante a que exibida abaixo com o Header `application/json` :

``` json
{
  "nome": "Fulano",
  "sobrenome": "da Silva Sauro",
  "email": "fulanodasilva@fulanodasilva.com",
  "cpf": "12345678909"
}

```
Será retornado um id para o novo cliente, semelhante ao id abaixo, que poderá ser utilizado na criação de um pedido:

`bd7977bc-ff7b-4793-a1c7-1bb38cec9f7b`

### Passo 2 - Consultar Clientes por E-mail (Opcional)

É possível consultar os Clientes tanto pelo e-mail quanto pelo ClienteId conforme os exemplos abaixo:

`GET -> http://localhost:8080/clientes/fulanodasilva@fulanodasilva.com `

```json
{
  "clienteId": "bd7977bc-ff7b-4793-a1c7-1bb38cec9f7b",
  "nome": "Fulano",
  "sobrenome": "da Silva Sauro",
  "cpf": "12345678909",
  "email": "fulanodasilva@fulanodasilva.com"
}
```

`GET -> http://localhost:8080/clientes/bd7977bc-ff7b-4793-a1c7-1bb38cec9f7b `

```json
{
  "clienteId": "bd7977bc-ff7b-4793-a1c7-1bb38cec9f7b",
  "nome": "Fulano",
  "sobrenome": "da Silva Sauro",
  "cpf": "12345678909",
  "email": "fulanodasilva@fulanodasilva.com"
}
```

### Passo 3 - Alterar Clientes existentes: (Opcional)

Caso seja necessário alterar os dados de um Cliente existente no sistema é possível fazer através do serviço:

`PUT -> http://localhost:8080/clientes/{clienteId} `

Utilizando um requisição semelhante a que exibida abaixo com o Header `application/json` , para o exemplo informado passamos o ClienteId `bd7977bc-ff7b-4793-a1c7-1bb38cec9f7b` :

``` json
{
  "nome": "Fulano",
  "sobrenome": "da Silva Sauro e Sauro",
  "email": "fulano@fulanodasilva.com",
  "cpf": "12345678901"
}

```
Será retornado o HTTP Status 204 confirmando que a alteração foi realizada com sucesso. Também é possível consultar novamente o cliente a partir do Passo 1 para confirmar a alteração


