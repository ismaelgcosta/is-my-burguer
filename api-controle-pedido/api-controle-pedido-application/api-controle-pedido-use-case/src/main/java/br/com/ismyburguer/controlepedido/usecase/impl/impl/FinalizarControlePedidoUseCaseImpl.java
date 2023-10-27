package br.com.ismyburguer.controlepedido.usecase.impl.impl;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.in.ConsultarControlePedidoUseCase;
import br.com.ismyburguer.controlepedido.ports.in.FinalizarControlePedidoUseCase;
import br.com.ismyburguer.controlepedido.ports.in.PrepararControlePedidoUseCase;
import br.com.ismyburguer.controlepedido.ports.out.out.AlterarControlePedidoRepository;
import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarStatusPedidoUseCase;

@UseCase
public class FinalizarControlePedidoUseCaseImpl implements FinalizarControlePedidoUseCase {
    private final AlterarControlePedidoRepository repository;
    private final ConsultarControlePedidoUseCase controlePedidoUseCase;
    private final AlterarStatusPedidoUseCase alterarStatusPedidoUseCase;
    public FinalizarControlePedidoUseCaseImpl(AlterarControlePedidoRepository repository,
                                              ConsultarControlePedidoUseCase controlePedidoUseCase,
                                              AlterarStatusPedidoUseCase alterarStatusPedidoUseCase) {
        this.repository = repository;
        this.controlePedidoUseCase = controlePedidoUseCase;
        this.alterarStatusPedidoUseCase = alterarStatusPedidoUseCase;
    }

    @Override
    public void finalizar(ControlePedido.PedidoId pedidoId) {
        ControlePedido controlePedido = controlePedidoUseCase.consultar(pedidoId);
        controlePedido.validate();
        controlePedido.pronto();
        repository.alterar(controlePedido);
        alterarStatusPedidoUseCase.alterar(new Pedido.PedidoId(pedidoId.getPedidoId()), Pedido.StatusPedido.PRONTO);
    }
}
