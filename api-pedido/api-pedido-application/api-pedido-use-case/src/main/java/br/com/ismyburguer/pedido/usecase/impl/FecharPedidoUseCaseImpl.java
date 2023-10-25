package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.FecharPedidoUseCase;
import br.com.ismyburguer.pedido.ports.out.FecharPedidoRepository;

@UseCase
public class FecharPedidoUseCaseImpl implements FecharPedidoUseCase {
    private final FecharPedidoRepository repository;

    public FecharPedidoUseCaseImpl(FecharPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void fechar(String pedidoId) {
        repository.fecharPedido(pedidoId);
    }
}
