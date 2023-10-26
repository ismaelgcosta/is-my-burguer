package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.CadastrarPedidoUseCase;
import br.com.ismyburguer.pedido.ports.out.AlterarPedidoRepository;
import br.com.ismyburguer.pedido.ports.out.CadastrarPedidoRepository;
import br.com.ismyburguer.pedido.usecase.validation.PedidoValidator;
import jakarta.validation.Valid;

import java.util.UUID;

@UseCase
public class AlterarPedidoUseCaseImpl implements AlterarPedidoUseCase {
    private final AlterarPedidoRepository repository;
    private final PedidoValidator validator;

    public AlterarPedidoUseCaseImpl(AlterarPedidoRepository repository, PedidoValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void alterar(String pedidoId, @Valid Pedido pedido) {
        validator.validate(pedido);
        repository.alterarPedido(pedidoId, pedido);
    }
}
