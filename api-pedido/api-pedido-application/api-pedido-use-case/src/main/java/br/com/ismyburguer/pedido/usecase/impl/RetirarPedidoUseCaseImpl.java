package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarStatusPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.RetirarPedidoUseCase;

@UseCase
public class RetirarPedidoUseCaseImpl implements RetirarPedidoUseCase {
    private final AlterarStatusPedidoUseCase pedidoUseCase;

    public RetirarPedidoUseCaseImpl(AlterarStatusPedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @Override
    public void retirar(Pedido.PedidoId pedidoId) {
        pedidoUseCase.alterar(pedidoId, Pedido.StatusPedido.FINALIZADO);
    }
}
