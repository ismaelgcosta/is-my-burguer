package br.com.ismyburguer.pedido.adapters.web.request;

import br.com.ismyburguer.core.validation.Validation;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AlterarItemPedidoRequest implements Validation {

    @NotNull(message = "Informe o código do Produto")
    private String produtoId;

    @NotNull(message = "Informe a quantidade do item")
    @Min(value = 1, message = "A quantidade do item do pedido deve ser de no mínimo 1")
    private Integer quantidade;

    @NotNull(message = "Informe o preço do item")
    @DecimalMin(value = "0.01", message = "O preço do item deve ser de no mínimo R$0,01")
    private BigDecimal preco;

}
