package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.ConsultarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.out.ConsultarPedidoRepository;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.core.usecase.UseCase;

import java.util.UUID;

@UseCase
public class ConsultarPedidoUseCaseImpl implements ConsultarPedidoUseCase {

    private final ConsultarPedidoRepository repository;

    public ConsultarPedidoUseCaseImpl(ConsultarPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido buscarPorId(ConsultaPedidoPorId query) {
        return repository.obterPeloPedidoId(UUID.fromString(query.pedidoId()))
                .orElseThrow(() -> new EntityNotFoundException("Pedido não foi encontrado"));
    }
}
