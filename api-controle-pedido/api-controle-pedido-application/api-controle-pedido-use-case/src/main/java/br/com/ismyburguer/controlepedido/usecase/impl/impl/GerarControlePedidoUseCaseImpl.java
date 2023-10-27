package br.com.ismyburguer.controlepedido.usecase.impl.impl;

import br.com.ismyburguer.controlepedido.domain.model.ControlePedido;
import br.com.ismyburguer.controlepedido.ports.in.GerarControlePedidoUseCase;
import br.com.ismyburguer.controlepedido.ports.out.out.GerarControlePedidoRepository;
import br.com.ismyburguer.core.usecase.UseCase;
import jakarta.validation.Valid;

import java.util.UUID;

@UseCase
public class GerarControlePedidoUseCaseImpl implements GerarControlePedidoUseCase {
    private final GerarControlePedidoRepository repository;
    public GerarControlePedidoUseCaseImpl(GerarControlePedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID receberPedido(@Valid ControlePedido.PedidoId pedidoId) {
        ControlePedido controlePedido = new ControlePedido(pedidoId);
        controlePedido.validate();
        return repository.gerar(controlePedido);
    }
}
