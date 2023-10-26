package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarStatusPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.ConsultarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.out.AlterarStatusPedidoRepository;

@UseCase
public class AlterarStatusPedidoUseCaseImpl implements AlterarStatusPedidoUseCase {
    private final AlterarStatusPedidoRepository repository;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;
    public AlterarStatusPedidoUseCaseImpl(AlterarStatusPedidoRepository repository, ConsultarPedidoUseCase consultarPedidoUseCase) {
        this.repository = repository;
        this.consultarPedidoUseCase = consultarPedidoUseCase;
    }

    @Override
    public void alterar(String pedidoId, Pedido.StatusPedido statusPedido) {
        Pedido pedido = consultarPedidoUseCase.buscarPorId(new ConsultarPedidoUseCase.ConsultaPedidoPorId(pedidoId));
        statusPedido.validarProximoStatus(pedido.getStatusPedido());
        repository.alterar(pedidoId, statusPedido);
    }
}
