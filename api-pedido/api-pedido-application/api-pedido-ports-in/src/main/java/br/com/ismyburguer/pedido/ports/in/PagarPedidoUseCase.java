package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

public interface PagarPedidoUseCase {
    String pagar(Pedido.PedidoId pedidoId);

}
