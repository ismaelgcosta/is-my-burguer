package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.ConsultarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.FecharPedidoUseCase;
import br.com.ismyburguer.pedido.ports.out.FecharPedidoRepository;

@UseCase
public class FecharPedidoUseCaseImpl implements FecharPedidoUseCase {
    private final FecharPedidoRepository repository;
    private final ConsultarPedidoUseCase pedidoUseCase;

    public FecharPedidoUseCaseImpl(FecharPedidoRepository repository, ConsultarPedidoUseCase pedidoUseCase) {
        this.repository = repository;
        this.pedidoUseCase = pedidoUseCase;
    }

    @Override
    public void fechar(String pedidoId) {
        repository.fecharPedido(pedidoId);
    }
}
