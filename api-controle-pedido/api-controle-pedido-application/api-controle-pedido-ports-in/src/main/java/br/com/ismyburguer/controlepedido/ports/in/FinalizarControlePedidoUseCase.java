package br.com.ismyburguer.controlepedido.ports.in;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

public interface FinalizarControlePedidoUseCase {

    void finalizar(ControlePedido.PedidoId pedidoId);
}
