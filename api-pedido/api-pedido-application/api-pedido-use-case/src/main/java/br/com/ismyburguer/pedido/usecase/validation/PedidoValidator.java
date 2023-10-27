package br.com.ismyburguer.pedido.usecase.validation;

import br.com.ismyburguer.cliente.ports.in.ConsultarClienteUseCase;
import br.com.ismyburguer.controlepedido.ports.in.ListarControlePedidoUseCase;
import br.com.ismyburguer.core.exception.BusinessException;
import br.com.ismyburguer.core.validation.DomainReferenceValidator;
import br.com.ismyburguer.core.validation.Validator;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.produto.ports.in.ConsultarProdutoUseCase;

import java.util.Optional;

@Validator
public class PedidoValidator {

    private final DomainReferenceValidator validator;
    private final ListarControlePedidoUseCase controlePedidoUseCase;

    public PedidoValidator(DomainReferenceValidator validator, ListarControlePedidoUseCase controlePedidoUseCase) {
        this.validator = validator;
        this.controlePedidoUseCase = controlePedidoUseCase;
    }

    public void validate(Pedido pedido) {
        pedido.validate();

        if(pedido.getStatusPedido() != Pedido.StatusPedido.ABERTO) {
            throw new BusinessException("O Pedido não está mais aberto e não pode ser alterado");
        }

        Optional<Pedido.ClienteId> clienteId = pedido.getClienteId();
        clienteId.ifPresent(id -> validator.validate(ConsultarClienteUseCase.class, "Cliente", id.getClienteId()));
        pedido
                .getItens()
                .forEach(item -> {
                    item.validate();
                    validator.validate(ConsultarProdutoUseCase.class, "Produto", item.getProdutoId().getProdutoId());
                });
    }
}
