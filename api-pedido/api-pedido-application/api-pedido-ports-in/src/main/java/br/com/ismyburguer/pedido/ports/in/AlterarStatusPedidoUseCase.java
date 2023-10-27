package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

public interface AlterarStatusPedidoUseCase {
    void alterar(Pedido.PedidoId pedidoId, Pedido.StatusPedido statusPedido);
}
