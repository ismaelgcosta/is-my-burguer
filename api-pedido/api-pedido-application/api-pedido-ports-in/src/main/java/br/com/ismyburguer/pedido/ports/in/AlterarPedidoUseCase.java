package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

public interface AlterarPedidoUseCase {
    void alterar(String pedidoId, Pedido pedido);
}
