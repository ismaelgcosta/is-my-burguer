package br.com.ismyburguer.pedido.adapters.web.request;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CadastrarPedidoRequest implements Validation {

    @UUID(message = "o id informado está num formato inválido")
    private String clienteId;

    @Valid
    @Size(min = 1, message = "É necessário informar ao menos um item no pedido")
    private List<CadastrarItemPedidoRequest> itens;

    public Optional<String> getClienteId() {
        return Optional.ofNullable(clienteId);
    }
}
