package br.com.ismyburguer.controlepedido.ports.in;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

public interface ConsultarControlePedidoUseCase {

    ControlePedido consultar(ControlePedido.PedidoId pedidoId);
}
