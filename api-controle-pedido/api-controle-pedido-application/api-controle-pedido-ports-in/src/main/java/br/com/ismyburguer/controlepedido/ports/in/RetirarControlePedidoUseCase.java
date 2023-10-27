package br.com.ismyburguer.controlepedido.ports.in;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;

public interface RetirarControlePedidoUseCase {

    void retirar(ControlePedido.PedidoId pedidoId);
}
