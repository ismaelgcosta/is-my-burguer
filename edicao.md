Para facilitar os testes dessa API está disponibilizada uma Collection para uso no Postman.
Para baixá-la [Clique Aqui](https://raw.githubusercontent.com/ismaelgcosta/is-my-burguer/main/is-my-burger%20-%20Gerenciamento%20de%20Pedidos.postman_collection.json).

Para aprender como importar a Collection no [Postman](https://www.postman.com/) [Clique Aqui](https://apidog.com/blog/how-to-import-export-postman-collection-data/)

### Passo 1 - Consultar Fila de Pedidos

Quando um pedido é enviado para fila ele é exibido num painel administrativo por ordem de chegada.
É possível consultar a fila pelo serviço abaixo:

`GET -> http://localhost:8080/controle-pedidos `

```json
[
  {
    "pedidoId": "b0f72cb4-3f9d-406e-92d7-a94fe7dce36a",
    "status": "RECEBIDO",
    "recebidoEm": "2023-10-29T23:59:05.424642",
    "inicioDaPreparacao": null,
    "fimDaPreparacao": null
  }
]
```

### Passo 2 - Alterar Pedidos para Em Preparação:

Uma vez que o chapeiro vá iniciar o Pedido ele precisa mover o pedido para
"Em Preparação" para que o Cliente saiba que seu pedido está sendo preparado.
É possível fazer isso através do serviço:

`PUT -> http://localhost:8080/controle-pedidos/{pedidoId}/em-preparacao `

Para o exemplo informado passamos o PedidoId b0f72cb4-3f9d-406e-92d7-a94fe7dce36a.

Será retornado o HTTP Status 204 confirmando que a alteração foi realizada com sucesso. Também é possível consultar novamente o pedido a partir do Passo 1 para confirmar a alteração.
Ao verificar a fila de Pedidos novamente a partir do Passo 1 é possível verificar o status do pedido

```json
[
  {
    "pedidoId": "b0f72cb4-3f9d-406e-92d7-a94fe7dce36a",
    "status": "EM_PREPARACAO",
    "recebidoEm": "2023-10-29T23:59:05.424642",
    "inicioDaPreparacao": "2023-10-30T00:09:56.971126",
    "fimDaPreparacao": null
  }
]
```

### Passo 3 - Alterar Pedidos para Pronto:

Uma vez que o chapeiro vá finalize o Pedido ele precisa mover o pedido para
"Pronto" para que o Cliente saiba que precisa fazer a retirada.
É possível fazer isso através do serviço:

`PUT -> http://localhost:8080/controle-pedidos/{pedidoId}/pronto `

Para o exemplo informado passamos o PedidoId b0f72cb4-3f9d-406e-92d7-a94fe7dce36a.

Será retornado o HTTP Status 204 confirmando que a alteração foi realizada com sucesso. Também é possível consultar novamente o pedido a partir do Passo 1 para confirmar a alteração.
Ao verificar a fila de Pedidos novamente a partir do Passo 1 é possível verificar o status do pedido

```json
[
  {
    "pedidoId": "b0f72cb4-3f9d-406e-92d7-a94fe7dce36a",
    "status": "PRONTO",
    "recebidoEm": "2023-10-29T23:59:05.424642",
    "inicioDaPreparacao": "2023-10-30T00:09:56.971126",
    "fimDaPreparacao": "2023-10-30T00:12:34.271772"
  }
]
```

### Passo 4 - Retirar Pedido:

Uma vez que o Cliente retire seu Pedido, a Atendente precisa marcar que o Pedido foi entregue para
que ele deixe de constar na Fila de Preparo e seja Finalizado.
É possível fazer isso através do serviço:

`PUT -> http://localhost:8080/controle-pedidos/{pedidoId}/retirada `

Para o exemplo informado passamos o PedidoId b0f72cb4-3f9d-406e-92d7-a94fe7dce36a.

Será retornado o HTTP Status 204 confirmando que a alteração foi realizada com sucesso. Também é possível consultar novamente o pedido a partir do Passo 1 para confirmar a alteração.
Ao verificar a fila de Pedidos novamente a partir do Passo 1 é possível verificar o pedido sumiu da listagem

```json
[]
```
Porém ao obter o Pedido através da [API de Pedidos](https://github.com/ismaelgcosta/is-my-burguer/wiki/API-de-Pedidos) é possível verificar
que o Pedido foi finalizado

``` json
{
    "pedidoId": "b0f72cb4-3f9d-406e-92d7-a94fe7dce36a",
    "clienteId": null,
    "itens": [
        {
            "itemPedidoId": "0fec8b49-7ed8-4f08-8019-12e447cdfcbf",
            "produtoId": "beab006c-6ab3-4c42-b526-10e686802771",
            "quantidade": 2,
            "preco": 15.50,
            "valorTotal": 31.00
        },
        {
            "itemPedidoId": "c27b705c-5bb3-4311-ae7b-8f29ad3ae864",
            "produtoId": "550858dd-bf71-44fc-9eb0-dd38f22d079a",
            "quantidade": 4,
            "preco": 3.50,
            "valorTotal": 14.00
        },
        {
            "itemPedidoId": "b3bd8fcb-6a17-438e-86d9-67fbbebb2639",
            "produtoId": "a1ca74a4-fdd5-4fcc-9ac9-0e35475e030e",
            "quantidade": 10,
            "preco": 5.50,
            "valorTotal": 55.00
        }
    ],
    "status": "FINALIZADO",
    "valorTotal": 100.00
}

```
