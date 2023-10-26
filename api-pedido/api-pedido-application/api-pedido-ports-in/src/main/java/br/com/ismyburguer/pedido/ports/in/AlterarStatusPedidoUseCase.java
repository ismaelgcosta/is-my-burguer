package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

public interface AlterarStatusPedidoUseCase {
    void alterar(String pedidoId, Pedido.StatusPedido statusPedido);
}
