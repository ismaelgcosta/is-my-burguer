package br.com.ismyburguer.controlepedido.ports.in;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

public interface PrepararControlePedidoUseCase {

    void preparar(ControlePedido.PedidoId pedidoId);
}
