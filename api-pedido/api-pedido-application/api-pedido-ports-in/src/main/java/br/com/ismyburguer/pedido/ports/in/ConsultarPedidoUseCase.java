package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

public interface ConsultarPedidoUseCase {

    Pedido buscarPorId(ConsultaPedidoPorId query);

    record ConsultaPedidoPorId(String pedidoId) {

    }
}
