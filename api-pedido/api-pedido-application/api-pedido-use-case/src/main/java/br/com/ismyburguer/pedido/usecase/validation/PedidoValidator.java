package br.com.ismyburguer.pedido.usecase.validation;

import br.com.ismyburguer.cliente.ports.in.ConsultarClienteUseCase;
import br.com.ismyburguer.core.validation.DomainReferenceValidator;
import br.com.ismyburguer.core.validation.Validator;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.produto.ports.in.ConsultarProdutoUseCase;

import java.util.Optional;

@Validator
public class PedidoValidator {

    private final DomainReferenceValidator validator;

    public PedidoValidator(DomainReferenceValidator validator) {
        this.validator = validator;
    }

    public void validate(Pedido pedido) {
        pedido.validate();

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
