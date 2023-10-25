package br.com.ismyburguer.pedido.adapters.web.request;

import br.com.ismyburguer.core.validation.EnumNamePattern;
import br.com.ismyburguer.core.validation.Validation;
import br.com.ismyburguer.pedido.domain.model.ItemPedido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class AlterarPedidoRequest implements Validation {

    @UUID(message = "o id informado está num formato inválido")
    private String clienteId;

    @Schema(description = "Categoria do Produto",
            allowableValues = {
                    "ABERTO",
                    "FECHADO",
                    "PAGO",
                    "RECEBIDO",
                    "EM_PREPARACAO",
                    "PRONTO",
                    "FINALIZADO"
            })
    @EnumNamePattern(
            regexp = "ABERTO|FECHADO|PAGO|RECEBIDO|EM_PREPARACAO|PRONTO|FINALIZADO",
            message = "O campo categoria do produto deve ser igual a {regexp}"
    )
    private String statusPedido;

    @Size(min = 1, message = "É necessário informar ao menos um item no pedido")
    private List<AlterarItemPedidoRequest> itens;

    public Optional<String> getClienteId() {
        return Optional.ofNullable(clienteId);
    }
}
