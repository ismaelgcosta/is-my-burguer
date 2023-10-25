package br.com.ismyburguer.pedido.adapters.web.request;

import br.com.ismyburguer.core.validation.EnumNamePattern;
import br.com.ismyburguer.core.validation.Validation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CadastrarPedidoRequest implements Validation {

    private String clienteId;

    @Valid
    @Min(value = 1, message = "É necessário informar ao menos um item no pedido")
    private List<CadastrarItemPedidoRequest> itens;

    public Optional<String> getClienteId() {
        return Optional.ofNullable(clienteId);
    }
}
